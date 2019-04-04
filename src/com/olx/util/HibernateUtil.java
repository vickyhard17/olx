package com.olx.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		static SessionFactory factory =null;
		static Session session=null;
		static
		{
			try
			{
				Configuration cfg = new Configuration();
				cfg.configure("Hibernate.cfg.xml"); 
				 factory = cfg.buildSessionFactory();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static Session hibernateConnection()
		{
			session=factory.openSession();
			return session;
		}
		public static void closeFactorySession()
		{
			factory.close();
		}
		public static void sessionClose(Session session1)
		{
			 if(session1!=null)
			 {
				 session1.close();
			 }
		}
}
