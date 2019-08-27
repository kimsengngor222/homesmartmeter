package main.java.com.keylesson.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.HashMap;
import java.util.Map;


public class HibernateUtil1 {

    private static final Map<String, Object> map = buildSessionFactory();
//    private static final SessionFactory sessionFactory = buildSessionFactory();

    @SuppressWarnings("deprecation")
    public static  Map<String, Object> buildSessionFactory()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            JSch j = new JSch();
            Session session = null;
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            try {
                j.addIdentity("C:\\Users\\Tan VengTry\\.ssh\\id_rsa");
                j.setKnownHosts("C:\\Users\\Tan VengTry\\.ssh\\known_hosts");
                session = j.getSession("root", "165.22.184.18", 22);
                session.setConfig(config);
                session.connect();
                session.setPortForwardingL(1111, "localhost", 3306);
            } catch (JSchException e) {
                e.printStackTrace();
            }
            // Create the SessionFactory from hibernate.cfg.xml
            map.put("session", session);
            map.put("factory", new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
            return map;
        }
        catch (Throwable ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Map<String, Object> getSessionFactory() {
        return map;
    }
}