package fr.alteca.mobithinkvelo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import fr.alteca.mobithinkvelo.model.Event;
import fr.alteca.mobithinkvelo.model.RollingPoint;
import fr.alteca.mobithinkvelo.model.Trajet;

public class TrajetsMemory implements Trajets{


	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = null;
	Transaction tx = null;
//	UUID uuid = UUID.randomUUID();
//    TrajetId id = new TrajetId(uuid);
	
	@Override
	public Long create(Long id, String startTrajet, String endTrajet) {
		session = sf.openSession();
		tx = session.beginTransaction();
		try {
	        Trajet t = new Trajet(id, startTrajet, endTrajet);
			session.persist(t);
			tx.commit();
		}catch (Exception e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
			//sf.close();
		}
		return id;
	}
	

	@Override
	public void addEvent(Event event) {//Long id, String eventName, String startCatchTime, double startCatchLatitude,
//			double startCatchLongitude, String endCatchTime, double endCatchLatitude, double endCatchLongitude,
//			String eventType) {
		System.out.println("helleo world !!");
		System.out.println("addEvent " + event);
		try {
			//session = sf.openSession();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("helleo world !!");
		tx = session.beginTransaction();
		if (tx != null) {
			System.out.println("tx is empty !!!!");
		}
		try {
//			Event event = new Event(id, eventName, startCatchTime, startCatchLatitude, startCatchLongitude, 
//					endCatchTime, endCatchLatitude, endCatchLongitude, eventType);
			session.persist(event);
			tx.commit();
		}catch (Exception e) {
			System.out.println("Exception Event: " + e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
			//sf.close();
		}
	}

	@Override
	public void addRollingPoint(RollingPoint rollingPoint) {
		session = sf.openSession();
		tx = session.beginTransaction();
		try {
			//RollingPoint rollingPoint = new RollingPoint(id, catchTime, catchLatitude, catchLongitude);
			session.persist(rollingPoint);
			tx.commit();
		}catch (Exception e) {
			System.out.println("Exception Event: " + e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
			//sf.close();
		}
		
	}




}
