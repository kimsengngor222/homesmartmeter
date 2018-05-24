package com.keylesson.DaoClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.keylesson.EntityClasses.Board;
import com.keylesson.EntityClasses.Daily_Usage;
import com.keylesson.EntityClasses.Data;
import com.keylesson.EntityClasses.Location;
import com.keylesson.EntityClasses.Region;
import com.keylesson.EntityClasses.Room;
import com.keylesson.EntityClasses.User_Registration;
import com.keylesson.HibernateUtil.HibernateUtil;
import com.keylesson.ModelClasses.boardreg;
import com.keylesson.ModelClasses.delete;
import com.keylesson.ModelClasses.update;
import com.keylesson.ModelClasses.event;

@Repository
public class userDaoImpl implements usersDao {
	private static final Logger LOGGER = null;

	public List<Map<String, Object>> getSource() {
		List<Map<String, Object>> locations = new ArrayList<Map<String, Object>>();
		Session session = HibernateUtil.getSessionFactory().openSession();
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

			LOGGER.log(Level.SEVERE, "Exception occured", e);
		}
		return locations;
	}

	public List<Map<String, Object>> getAllRegion() {
		List<Map<String, Object>> regions = new ArrayList<Map<String, Object>>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			Query qury = session
					.createQuery("select D.room.region.name, sum(D.power)/1000, sum(D.water)/1000 from Daily_Usage D Group by(D.room.region.ID)");
			@SuppressWarnings("unchecked")
			List<Object[]> q = qury.list();
			for (Object b[] : q) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("region_name", b[0]);
				map.put("power", b[1]);
				map.put("water", b[2]);
				regions.add(map);
			}
			trns.commit();

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
		} finally {

			session.flush();
			session.close();
		}
		return regions;

	}

	@SuppressWarnings("unchecked")
	public List<User_Registration> getUsers() {
		List<User_Registration> user = new ArrayList<User_Registration>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			user = session.createQuery("FROM User_Registration").list();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return user;
		} finally {

			session.flush();
			session.close();

		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getAllLocation() {
		List<Location> location = new ArrayList<Location>();
		List<Map<String, Object>> locations = new ArrayList<Map<String, Object>>();

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			String queryString = ("from Location");
			Query query = session.createQuery(queryString);
			location = query.list();
			for (int i = 0; i < location.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", location.get(i).getName());
				map.put("id", location.get(i).getID());
				locations.add(map);
			}
			trns.commit();

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
		} finally {

			session.flush();
			session.close();

		}
		return locations;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getRegion(String id) {
		List<Region> region = new ArrayList<Region>();
		List<Map<String, Object>> regions = new ArrayList<Map<String, Object>>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			String queryString = "from Region where location.ID = " + id;
			Query query = session.createQuery(queryString);

			region = query.list();
			for (int i = 0; i < region.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", region.get(i).getID());
				map.put("name", region.get(i).getName());
				regions.add(map);
			}
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {

			session.flush();
			session.close();
		}
		return regions;

	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getRoom(String id) {
		List<Room> room = new ArrayList<Room>();
		List<Map<String, Object>> rooms = new ArrayList<Map<String, Object>>();

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			String queryString = "from Room where region.ID = " + id;

			Query query = session.createQuery(queryString);

			room = query.list();
			for (int i = 0; i < room.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", room.get(i).getID());
				map.put("name", room.get(i).getName());
				rooms.add(map);
			}

			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {

			session.flush();
			session.close();
		}
		return rooms;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getSingleRoom(int id) {
		List<Data> data = new ArrayList<Data>();
		List<Map<String, Object>> room = new ArrayList<Map<String, Object>>();

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			String queryString = "from Data where room_ID =" + id;
			Query query = session.createQuery(queryString);

			data = query.list();
			for (int i = 0; i < data.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("roomID", data.get(i).getRoom().getID());
				map.put("name", data.get(i).getRoom().getName());
				room.add(map);
			}
			trns.commit();

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {

			session.flush();
			session.close();
		}

		return room;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getReport(String id, String export_from,
			String export_until) {
		List<Daily_Usage> daily_usage = new ArrayList<Daily_Usage>();
		List<Room> room = new ArrayList<Room>();
		Transaction trns = null;
		Map<String, Object> rooms = new HashMap<String, Object>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			String queryString = "from Daily_Usage where room.ID=:id  and dmy>=:export_from and dmy<=:export_until";
			String queryString2 = "from Room where ID=" + id;
			Query query = session.createQuery(queryString);
			Query query2 = session.createQuery(queryString2);
			room = query2.list();
			query.setString("id", id);
			query.setString("export_from", export_from.concat(" 00:00"));
			query.setString("export_until", export_until.concat(" 23:59"));
			daily_usage = query.list();
			float total_power = 0;
			float total_water = 0;
			for (Daily_Usage d : daily_usage) {
				total_power += d.getPower();
				total_water += d.getWater();

			}

			rooms.put("name", room.get(0).getName());
			rooms.put("id", id);
			rooms.put("power", total_power / 1000);
			rooms.put("water", total_water / 1000);
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {

			session.flush();
			session.close();
		}
		return rooms;

	}

	public int getEvent(event event) {

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			Data data = new Data();
			String hql = "from Data where room_ID =" + event.getRoomID();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0)
				return 5;

			else {
				Room room = (Room) session.load(Room.class, event.getRoomID());
				data.setRoom(room);
				data.setOverUsagePower(event.getPower());
				data.setOverUsageWater(event.getWater());
				data.setEmail(event.getEmail());
				data.setMessage(event.getMessage());
				data.setRoomName(event.getRoomName());
				session.save(data);
				trns.commit();
				return 1;

			}

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return 0;
		} finally {

			session.flush();
			session.close();

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String, Object>> getEvents() {
		ArrayList<Data> data = new ArrayList<Data>();
		Transaction trns = null;
		List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			String queryString = "from Data";
			Query query = session.createQuery(queryString);
			data = (ArrayList) query.list();
			for (int i = 0; i < data.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("power", data.get(i).getPower());
				map.put("water", data.get(i).getWater());
				map.put("id", data.get(i).getID());
				map.put("roomID", data.get(i).getRoom().getID());
				map.put("roomName", data.get(i).getRoom().getName());
				map.put("over_usage_power", data.get(i).getOverUsagePower());
				map.put("over_usage_water", data.get(i).getOverUsageWater());
				map.put("email", data.get(i).getEmail());
				events.add(map);
				System.out.println("asdasdasdsss"+events);
			}
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {

			session.flush();
			session.close();
		}
		return events;

	}

	public int registerBoard(boardreg boardreg) {
		Board board = new Board();
		Board boardToDelete = new Board();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trns = null;

		try {
			trns = session.beginTransaction();
			String hql = "from Board where room_ID =" + boardreg.getRoomID();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0) {
				boardToDelete = (Board) query.list().get(0);
				session.delete(boardToDelete);
				Room room = (Room) session.load(Room.class,
						boardreg.getRoomID());
				room.setID(boardreg.getRoomID());
				board.setRoom(room);
				board.setMAC(boardreg.getMac());
				session.save(board);
				trns.commit();
				return 5;
			} else {
				Room room = (Room) session.load(Room.class,
						boardreg.getRoomID());
				room.setID(boardreg.getRoomID());
				board.setRoom(room);
				board.setMAC(boardreg.getMac());
				session.save(board);
				trns.commit();
				return 1;
			}
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			
			}

			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return 0;
		} finally {

			session.flush();
			session.close();

		}

	}

	public int registerRoom(boardreg boardreg) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction trns = null;

		try {
			trns = session.beginTransaction();
			String hql = "from Room where ID =" + boardreg.getRoomID();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0)
				return 5;
			else {
				Region region = new Region();
				Room room = new Room();
				region.setID(boardreg.getRegionID());
				room.setRegion(region);
				room.setID(boardreg.getRoomID());
				room.setName(boardreg.getRoomName());
				room.setUserID(1);

				session.save(room);
			}

			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return 0;
		} finally {

			session.flush();
			session.close();

		}
		return 1;
	}

	public int registerRegionName(boardreg boardreg) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			String hql = "from Region where ID =" + boardreg.getRegionID();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0)
				return 5;
			else {
				Region region = new Region();
				Location location = new Location();
				location.setID(boardreg.getLocationID());
				region.setID(boardreg.getRegionID());
				region.setLocation(location);
				region.setName(boardreg.getRegionName());

				session.save(region);

			}
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return 0;
		} finally {

			session.flush();
			session.close();

		}
		return 1;
	}

	public int registerLocation(boardreg boardreg) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trns = null;

		try {
			trns = session.beginTransaction();
			String hql = "from Location where ID =" + boardreg.getLocationID();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0)
				return 5;
			else {
				Location location = new Location();
				location.setID(boardreg.getLocationID());
				location.setName(boardreg.getLocationName());
				session.save(location);
				trns.commit();
			}
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return 0;
		} finally {

			session.flush();
			session.close();

		}
		return 1;
	}

	public boolean getUpdation(update update) {
		Transaction trns = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trns = session.beginTransaction();
			Data data = new Data();
			String hql = "from Data where room_ID =" + update.getRoomID();
			Query query = session.createQuery(hql);
			if (query.list().size() > 0) {
				data = (Data) query.list().get(0);
				Room room = (Room) session.load(Room.class, update.getRoomID());
				data.setRoom(room);
				data.setOverUsagePower(update.getUpdateElectric());
				data.setOverUsageWater(update.getUpdateWater());
				data.setEmail(update.getUpdateEmail());
				session.update(data);

			}
			trns.commit();

			return true;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
				// throw e;
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {

			session.flush();
			session.close();
		}
		return false;
	}

	public boolean getDeletion(delete delete) {

		Transaction trns = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Data data = new Data();
		try {
			trns = session.beginTransaction();
			String hql = "from Data where room_ID =" + delete.getRoomID();
			Query query = session.createQuery(hql);
			data = (Data) query.uniqueResult();
			session.delete(data);
			trns.commit();
			return true;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

}
