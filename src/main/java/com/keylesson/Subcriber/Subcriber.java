package com.keylesson.Subcriber;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.keylesson.DaoClasses.userDaoImpl;
import com.keylesson.EntityClasses.Daily_Usage;
import com.keylesson.EntityClasses.Board;
import com.keylesson.EntityClasses.Room;
import main.java.com.keylesson.HibernateUtil.HibernateUtil;
import com.keylesson.Publisher.Publisher;

public class Subcriber implements MqttCallback {
	private static final Logger LOGGER = Logger.getLogger(userDaoImpl.class
			.getName());

	private static final String brokerUrl = "tcp://192.168.7.245:1883";

	@SuppressWarnings("unused")
	private static final String clientId = "Home";

	private static final String topic = "KITEscott";

	public static void main(String[] args) {
		new Subcriber().subscribe(topic);
	}

	public void subscribe(String topic) {

		MemoryPersistence persistence = new MemoryPersistence();

		try {

			MqttClient sampleClient = new MqttClient(brokerUrl,
					MqttClient.generateClientId(), persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("checking");
			System.out.println("Mqtt Connecting to broker: " + brokerUrl);
			sampleClient.connect(connOpts);
			System.out.println("Mqtt Connected");
			sampleClient.setCallback(this);
			sampleClient.subscribe(topic);
			System.out.println("Subscribed");
			System.out.println("Listening");
		} catch (MqttException me) {
			System.out.println("Mqtt reason " + me.getReasonCode());
			System.out.println("Mqtt msg " + me.getMessage());
			System.out.println("Mqtt loc " + me.getLocalizedMessage());
			System.out.println("Mqtt cause " + me.getCause());
			System.out.println("Mqtt excep " + me);
		}
	}

	public void connectionLost(Throwable arg0) {

	}

	public void deliveryComplete(IMqttDeliveryToken arg0) {

	}

	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		Publisher pub = new Publisher();
		String getmessage = message.toString();
		String[] receivemessage = getmessage.split(" ");
		String MAC = receivemessage[0];
		String Power = receivemessage[1];
		String Water = receivemessage[2];
		System.out.println("MAC: " + MAC);
		System.out.println("Power: " + Power);
		System.out.println("Water: " + Water + "\n");
		@SuppressWarnings("unused")
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Daily_Usage d = new Daily_Usage();
		try {
			trns1 = session.beginTransaction();

			@SuppressWarnings("unused")
			Calendar calendar = Calendar.getInstance();
			Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
			String dateInString = new java.text.SimpleDateFormat("YYYY-MM-dd")
					.format(System.currentTimeMillis());
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

			@SuppressWarnings("unused")
			Date parsedDate = formatter.parse(dateInString);
			String getmessage1 = updatedAt.toString();
			String[] receivemessage1 = getmessage1.split(" ");
			String date = receivemessage1[0].trim();
			String hql = "from Daily_Usage where room_ID="
					+ new Subcriber().getRoomIdByMAC(MAC)
					+ " AND DATE(dmy) = '" + date + "'";
			System.out.println(date);
			Query query = session.createQuery(hql);

			if (query.list().size() > 0) {
				d = (Daily_Usage) query.list().get(0);
				d.setPower(d.getPower() + (int) Float.parseFloat(Power));
				d.setWater(d.getWater() + (int) Float.parseFloat(Water));
				d.setUpdatedAt(updatedAt);
				session.update(d);
			} else {
				String stringBoard = "From Board where MAC='" + MAC + "'";
				Query queryBoard = session.createQuery(stringBoard);
				if (queryBoard.list().size() > 0) {
					Board board = (Board) queryBoard.list().get(0);
					Room room = board.getRoom();
					d.setRoom(room);
					d.setPower((int) Float.parseFloat(Power));
					d.setWater((int) Float.parseFloat(Water));
					d.setDmy(updatedAt);
					d.setCreatedAt(updatedAt);
					d.setUpdatedAt(updatedAt);
					session.save(d);
				}

			}

			session.getTransaction().commit();
			pub.sub(MAC);
		} catch (RuntimeException e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			System.out.println("I got Error");
		} finally {
			session.flush();
			session.close();
		}
		
	}

	public int getRoomIdByMAC(String MAC) {

		@SuppressWarnings("unused")
		Transaction trns1 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Board b = new Board();
		try {
			trns1 = session.beginTransaction();
			String queryString = "from Board where MAC=:MAC";
			Query query = session.createQuery(queryString);
			query.setString("MAC", MAC);
			b = (Board) query.uniqueResult();
		} catch (RuntimeException e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);

		} finally {
			session.flush();
			session.close();
		}
		return b.getRoom().getID();

	}
}
