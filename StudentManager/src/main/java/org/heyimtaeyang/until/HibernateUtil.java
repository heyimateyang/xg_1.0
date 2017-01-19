package org.heyimtaeyang.until;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author heyimtaeyang
 *
 *  工具类,连接Hibernate
 */


@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static final ThreadLocal<Session> threadLocal =
			new ThreadLocal<Session>();
	
	
	private static SessionFactory sessionFactory = null;
	static{
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("创建失败");
			e.printStackTrace();
		}
	}
	
	//获取Session
	public static Session getSession()throws HibernateException{
		Session session = threadLocal.get(); 
		if(session==null||!session.isOpen()){
			if(sessionFactory==null){
				rebuildSessionFactory();
			}
			session = (sessionFactory!=null)?sessionFactory.openSession():null;
			threadLocal.set(session);
		}
		return session;
		
	}
	
	//创建会话工厂
	public static void rebuildSessionFactory(){
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("创建失败");
			e.printStackTrace();
		}
	}
	
	//获取Session工厂对象
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//关闭Session工厂对象
	public static void closeSession()throws HibernateException{
		Session session = (Session)threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}
	

}
