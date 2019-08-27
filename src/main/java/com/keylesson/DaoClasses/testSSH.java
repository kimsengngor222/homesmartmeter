package main.java.com.keylesson.DaoClasses;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.keylesson.HibernateUtil.HibernateUtil1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class testSSH {
    public static void main(String args[]){

        List<Map<String, Object>> locations = new ArrayList<Map<String, Object>>();
        Map<String, Object> mapUtil2 = HibernateUtil1.getSessionFactory();

        SessionFactory factory = (SessionFactory)(mapUtil2.get("factory"));
        com.jcraft.jsch.Session tunnel_session = (com.jcraft.jsch.Session)(mapUtil2.get("session"));
        Session session = factory.openSession();

        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            Query qury = session
                    .createQuery("Select D.room.region.ID, D.room.region.name , D.room.ID, D.room.name ,Sum(D.power)/1000, Sum(D.water)/1000, D.dmy from Daily_Usage D Group by(D.room.ID)");
            @SuppressWarnings("unchecked")
            List<Object[]> q = qury.list();
            for (Object b[] : q) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("region_name", b[0]);
            }
            for (Object b[] : q) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("region_id", b[0]);
                map.put("region_name", b[1]);
                map.put("room", b[2]);
                map.put("room_name", b[3]);
                map.put("power", b[4]);
                map.put("water", b[5]);
                map.put("date", b[6]);
                locations.add(map);
            }

            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }

        }
        finally {
            session.flush();
            session.close();
            tunnel_session.disconnect();
        }

    }
}
