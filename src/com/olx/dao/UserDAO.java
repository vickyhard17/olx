package com.olx.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.bean.OutputBean;
import com.olx.bean.UserInputBean;
import com.olx.bean.UserOutputBean;
import com.olx.pojo.UserInfo;
import com.olx.util.HibernateUtil;


public class UserDAO 
{
	Session session=null;
	Transaction transaction=null;
	boolean flag1=false;
	public UserOutputBean InsertUser(UserInfo userInfo)
	{
		UserOutputBean userOutputBean=new UserOutputBean();
		List qry=null;
		try
		{
			session=HibernateUtil.hibernateConnection();
			transaction=session.beginTransaction();
			session.save(userInfo);
			transaction.commit();
			String hql="select ui.pkuserid,ui.username,ui.usermobile,ui.isadmin from UserInfo ui where ui.useremail=:username and ui.userpassword=:password";
			Query query=session.createQuery(hql);
			query.setParameter("username", userInfo.getUseremail());
			query.setParameter("password", userInfo.getUserpassword());
			 qry=query.list();
			 if(qry!=null && !qry.isEmpty())
			 {
				 for(Object obj:qry)
				 {
					 Object obj1[]=(Object[])obj;
					 userOutputBean.setPkid((Long)obj1[0]);
					 userOutputBean.setName((String)obj1[1]);
					 userOutputBean.setContact((Long)obj1[2]);
					 userOutputBean.setIsAdmin((Character)obj1[3]);
				 }
			 }

		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.sessionClose(session);
		}
		return userOutputBean;
	}
	public boolean checkMobile(UserInfo userInfo)
	{
		try
		{
			session=HibernateUtil.hibernateConnection();
			String hql="select ui from UserInfo ui where ui.usermobile =:contact";
			Query qry=session.createQuery(hql);
			qry.setParameter("contact", userInfo.getUsermobile());
			List listQuery=qry.list();
			Iterator itr=listQuery.iterator();
			if(listQuery != null && !listQuery.isEmpty())
			{
				flag1 = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.sessionClose(session);
		}
		return flag1;
	}
	public boolean checkEmail(UserInfo userInfo)
	{
		try
		{
			session=HibernateUtil.hibernateConnection();
			String hql="select ui from UserInfo ui where ui.useremail =:emailid";
			Query qry=session.createQuery(hql);
			qry.setParameter("emailid", userInfo.getUseremail());
			List listQuery=qry.list();
			if(listQuery != null && !listQuery.isEmpty())
			{
				flag1 = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.sessionClose(session);
		}
		return flag1;
	}
	public UserInfo showLoginRecord(UserInputBean inputBean)
	{
			UserInfo userInfo=new UserInfo();;
			List qry=null;
			try
			{
				session=HibernateUtil.hibernateConnection();
				String hql="select ui.pkuserid,ui.username,ui.usermobile,ui.isadmin,ui.useremail from UserInfo ui where ui.useremail=:username and ui.userpassword=:password";
				Query query=session.createQuery(hql);
				query.setParameter("username", inputBean.getUserEmail());
				query.setParameter("password", inputBean.getUserPassword());
				 qry=query.list();
				 if(qry!=null && !qry.isEmpty())
				 {
					 for(Object obj:qry)
					 {
						 Object obj1[]=(Object[])obj;
						 userInfo.setPkuserid((Long)obj1[0]);
						 userInfo.setUsername((String)obj1[1]);
						 userInfo.setUsermobile((Long)obj1[2]);
						 userInfo.setIsadmin((Character)obj1[3]);
						 userInfo.setUseremail((String)obj1[4]);
					 }
				 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				HibernateUtil.sessionClose(session);
			}
			return userInfo;
	}
	public Long checkSellerId(UserInputBean inputBeanSignup)
	{
		List qry=null;
		 Long pkid=0L;
		try
		{
			UserInfo userInfo=new UserInfo();
			userInfo.setUseremail(inputBeanSignup.getUserEmail());
			String email=userInfo.getUseremail();
			session=HibernateUtil.hibernateConnection();
			String hql="select ui from UserInfo ui where ui.useremail=:email";
			Query query=session.createQuery(hql);
			query.setParameter("email", email);
			 qry=query.list();
			 if(qry!=null && !qry.isEmpty())
			 {
				 for(Object obj:qry)
				 {
					 userInfo=(UserInfo)obj;
					 System.out.println(userInfo.getPkuserid());
					  pkid=userInfo.getPkuserid();
				 }
			 }
			 else
			 {
				 pkid=0L;
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.sessionClose(session);
		}
		return pkid;
	}
	public int nameUpdate(String names,String email,String val,String pass) 
	{
		int rows=0;
		UserInfo userInfo=null;
		Long value=0L;
		String cont=null;
		try
		{
			value=Long.parseLong(val) ;
			cont=value.toString();
			session=HibernateUtil.hibernateConnection();
			Date date=new Date();
			String sql="select u "
					+ " from UserInfo u where u.useremail=:email and u.isadmin='N'";
			Query query=session.createQuery(sql);
			query.setString("email", email);
			List list=query.list();
			 if(list!=null && !list.isEmpty())
			 {
				 for(Object obj:list)
				 {
					 userInfo=(UserInfo)obj;
				 }
			 }
			if(userInfo.getUseremail().equals(email))
			{
				userInfo.setUsername(names);
				transaction=session.beginTransaction();
				session.update(userInfo);
				transaction.commit();
				rows=1;
			}
			String num=userInfo.getUsermobile().toString();
			 if(!num.equals(cont))
			{
				userInfo.setUsermobile(value);
				transaction=session.beginTransaction();
				session.update(userInfo);
				transaction.commit();
				rows=1;
			}
			 if(!userInfo.getUserpassword().equals(pass))
				{
					userInfo.setUserpassword(pass);
					transaction=session.beginTransaction();
					session.update(userInfo);
					transaction.commit();
					rows=1;
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.sessionClose(session);
		}
		return rows;
	}
	
}
