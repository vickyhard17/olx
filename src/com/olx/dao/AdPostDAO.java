package com.olx.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CosTrading.AdminPOATie;

import com.olx.bean.AdPostOutBean;
import com.olx.bean.UserProfileBean;
import com.olx.pojo.AdPost;
import com.olx.pojo.Area;
import com.olx.pojo.Categories;
import com.olx.pojo.UserInfo;
import com.olx.util.HibernateUtil;

public class AdPostDAO 
{
	Session session=null;
	Transaction transaction=null;
	public int insertAdPostRecord(AdPost post,Long id,Long pkid,Long subid)
	{
		List qry=null;
		List qry1=null;
		List qry2=null;
		Area area=null;
		UserInfo info=null;
		Categories category=null;
		int rows=0;
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			transaction=session.beginTransaction();
			Query query=session.createQuery("select a from Area a where a.pkareaid=:id ");
			query.setParameter("id", id);
			qry=query.list();
			Area a=(Area)qry.get(0);
			Query query1=session.createQuery("select u from UserInfo u where u.pkuserid=:pkid ");
			query1.setParameter("pkid", pkid);
			qry1=query1.list();
			UserInfo u=(UserInfo)qry1.get(0);
			Query query2=session.createQuery("select c from Categories  c where c.pkcategoryid=:subid ");
			query2.setParameter("subid", subid);
			qry2=query2.list();
			Categories c=(Categories)qry2.get(0);
			post.setArea(a);
			post.setUserinfo(u);
			post.setCategories(c);
			session.save(post);
			rows=1;
			transaction.commit();
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
	public List showAllProduct(Long subid) 
	{
		session=HibernateUtil.hibernateConnection();
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			String sql=" select ap.imagename,ap.title,ap.description,ap.price,u.username,u.usermobile, "
					+ " a.areaname,ci.cityname,s.statename,c.categoryname,ap.pkadid "
					+ " from AdPost ap "
					+ "  join ap.area a "
					+ " join a.city ci "
					+ " join ci.state s "
					+ " join ap.userinfo u "
					+ " join ap.categories c "
					+ " where "
					+ " ap.pkadid=:subid and ap.isactive='Y'";
			Query query=session.createQuery(sql);
			query.setParameter("subid", subid);
			List list =query.list();
			if(list!=null && !list.isEmpty())
			{
				for(Object ob:list)
				{
					bean=new AdPostOutBean();
					Object adpost[]=(Object[])ob;
					bean.setImagename((String)adpost[0]);
					bean.setTitle((String)adpost[1]);
					bean.setDescription((String)adpost[2]);
					bean.setPrice((Float)adpost[3]);
					bean.setName((String)adpost[4]);
					bean.setContact((Long)adpost[5]);
					bean.setArea((String)adpost[6]);
					bean.setCity((String)adpost[7]);
					bean.setState((String)adpost[8]);
					bean.setSubcategory((String)adpost[9]);
					bean.setAdid((Long)adpost[10]);
					output.add(bean);
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
		return output;
	}
	public List showProduct(Long subid) 
	{
		session=HibernateUtil.hibernateConnection();
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			String sql=" select  ap.title,ap.description,ap.price, "
					+ " a.areaname,ci.cityname,s.statename,c.categoryname,ap.pkadid,ap.imagename "
					+ " from AdPost ap "
					+ "  join ap.area a "
					+ " join a.city ci "
					+ " join ci.state s "
					+ " join ap.userinfo u "
					+ " join ap.categories c "
					+ " where "
					+ " c.pkcategoryid=:subid and ap.isactive='Y'";
			Query query=session.createQuery(sql);
			query.setParameter("subid", subid);
			List list =query.list();
			if(list!=null && !list.isEmpty())
			{
				for(Object ob:list)
				{
					bean=new AdPostOutBean();
					Object adpost[]=(Object[])ob;
					bean.setTitle((String)adpost[0]);
					bean.setDescription((String)adpost[1]);
					bean.setPrice((Float)adpost[2]);
					bean.setArea((String)adpost[3]);
					bean.setCity((String)adpost[4]);
					bean.setState((String)adpost[5]);
					bean.setSubcategory((String)adpost[6]);
					bean.setAdid((Long)adpost[7]);
					bean.setImagename((String)adpost[8]);
					output.add(bean);
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
		return output;
	}
	public List allPostRecord(Long userid) 
	{
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql=" select ap.title,ap.description,ap.price,u.username,u.usermobile, "
						+ " a.areaname,ci.cityname,s.statename,c.categoryname,ap.pkadid,ap.imagename "
						+ " from AdPost ap "
						+ "  join ap.area a "
						+ " join a.city ci "
						+ " join ci.state s "
						+ " join ap.userinfo u "
						+ " join ap.categories c "
						+ " where "
						+ " u.pkuserid=:userid and ap.isactive='Y'";
				Query querys=session.createQuery(sql);
				querys.setParameter("userid", userid);
				List list =querys.list();
				if(list!=null && !list.isEmpty())
				{
					for(Object ob:list)
					{
						bean=new AdPostOutBean();
						Object adpost[]=(Object[])ob;
						bean.setTitle((String)adpost[0]);
						bean.setDescription((String)adpost[1]);
						bean.setPrice((Float)adpost[2]);
						bean.setName((String)adpost[3]);
						bean.setContact((Long)adpost[4]);
						bean.setArea((String)adpost[5]);
						bean.setCity((String)adpost[6]);
						bean.setState((String)adpost[7]);
						bean.setSubcategory((String)adpost[8]);
						bean.setAdid((Long)adpost[9]);
						bean.setImagename((String)adpost[7]);
						output.add(bean);
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
		return output;

	}
	public List userRecord(Long userid) 
	{
		UserProfileBean bean=null;
		List output=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select u.username,u.useremail,u.usermobile,u.address from UserInfo u"
						+ " where "
						+ " u.pkuserid=:userid and u.isactive='Y'";
				Query querys=session.createQuery(sql);
				querys.setParameter("userid", userid);
				List list =querys.list();
				if(list!=null && !list.isEmpty())
				{
					for(Object ob:list)
					{
						bean=new UserProfileBean();
						Object user[]=(Object[])ob;
						bean.setName((String)user[0]);
						bean.setEmail((String)user[1]);
						bean.setMobile((Long)user[2]);
						bean.setAddress((String)user[3]);
						output.add(bean);
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
		return output;

	}
	public List allVerify() 
	{
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql=" select ap.title,ap.description,ap.price,u.username,u.usermobile, "
						+ " a.areaname,ci.cityname,s.statename,c.categoryname,ap.pkadid "
						+ " from AdPost ap "
						+ "  join ap.area a "
						+ " join a.city ci "
						+ " join ci.state s "
						+ " join ap.userinfo u "
						+ " join ap.categories c "
						+ " where "
						+ " ap.isverified='Y' and ap.isactive='Y'";
				Query querys=session.createQuery(sql);
				List list =querys.list();
				for(Object ob:list)
				{
					bean=new AdPostOutBean();
					Object adpost[]=(Object[])ob;
					bean.setTitle((String)adpost[0]);
					bean.setDescription((String)adpost[1]);
					bean.setPrice((Float)adpost[2]);
					bean.setName((String)adpost[3]);
					bean.setContact((Long)adpost[4]);
					bean.setArea((String)adpost[5]);
					bean.setCity((String)adpost[6]);
					bean.setState((String)adpost[7]);
					bean.setSubcategory((String)adpost[8]);
					bean.setAdid((Long)adpost[9]);
					output.add(bean);
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
		return output;

	}
	
	public List allUnVerify() 
	{
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql=" select ap.title,ap.description,ap.price,u.username,u.usermobile, "
						+ " a.areaname,ci.cityname,s.statename,c.categoryname,ap.pkadid "
						+ " from AdPost ap "
						+ "  join ap.area a "
						+ " join a.city ci "
						+ " join ci.state s "
						+ " join ap.userinfo u "
						+ " join ap.categories c "
						+ " where "
						+ " ap.isverified='N' and ap.isactive='N'";
				Query querys=session.createQuery(sql);
				List list =querys.list();
				if(list!=null && !list.isEmpty())
				{
					for(Object ob:list)
					{
						bean=new AdPostOutBean();
						Object adpost[]=(Object[])ob;
						bean.setTitle((String)adpost[0]);
						bean.setDescription((String)adpost[1]);
						bean.setPrice((Float)adpost[2]);
						bean.setName((String)adpost[3]);
						bean.setContact((Long)adpost[4]);
						bean.setArea((String)adpost[5]);
						bean.setCity((String)adpost[6]);
						bean.setState((String)adpost[7]);
						bean.setSubcategory((String)adpost[8]);
						bean.setAdid((Long)adpost[9]);
						output.add(bean);
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
		return output;

	}
	public boolean allUnverifyById(Long unverid)
	{
		AdPostOutBean bean=null;
		AdPost adPost=null;
		boolean flag=false;
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql=" select ap "
						+ " from AdPost ap "
						+ " where "
						+ " ap.pkadid=:unverid and ap.isactive='Y' ";
				Query querys=session.createQuery(sql);
				querys.setParameter("unverid", unverid);
				List list =querys.list();
				if(list!=null && !list.isEmpty())
				{
					for(Object ob:list)
					{
						 adPost=(AdPost)list.get(0);
						adPost.setIsactive('N');
						transaction=session.beginTransaction();
						session.update(adPost);
						transaction.commit();
						flag=true;
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
		return flag;
	}
	public boolean allVerifyById(Long verid)
	{
		AdPostOutBean bean=null;
		AdPost adPost=null;
		boolean flag=false;
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql=" select ap "
						+ " from AdPost ap "
						+ " where "
						+ " ap.pkadid=:verid and ap.isactive='Y'";
				Query querys=session.createQuery(sql);
				querys.setParameter("verid", verid);
				List list =querys.list();
				if(list!=null && !list.isEmpty())
				{
					for(Object ob:list)
					{
						 adPost=(AdPost)list.get(0);
						adPost.setIsverified('Y');
						transaction=session.beginTransaction();
						session.update(adPost);
						transaction.commit();
						flag=true;
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
		return flag;
	}
	public List showProducts()
	{
		session=HibernateUtil.hibernateConnection();
		AdPostOutBean bean=null;
		List output=new ArrayList<>();
		try
		{
			String sql=" select  ap.title,ap.description,ap.price, "
					+ " a.areaname,ci.cityname,s.statename,c.categoryname,ap.pkadid,ap.imagename "
					+ " from AdPost ap "
					+ "  join ap.area a "
					+ " join a.city ci "
					+ " join ci.state s "
					+ " join ap.userinfo u "
					+ " join ap.categories c "
					+ " where "
					+ " ap.isactive='Y'";
			Query query=session.createQuery(sql);
			List list =query.list();
			if(list!=null && !list.isEmpty())
			{
				for(Object ob:list)
				{
					bean=new AdPostOutBean();
					Object adpost[]=(Object[])ob;
					bean.setTitle((String)adpost[0]);
					bean.setDescription((String)adpost[1]);
					bean.setPrice((Float)adpost[2]);
					bean.setArea((String)adpost[3]);
					bean.setCity((String)adpost[4]);
					bean.setState((String)adpost[5]);
					bean.setSubcategory((String)adpost[6]);
					bean.setAdid((Long)adpost[7]);
					bean.setImagename((String)adpost[8]);
					output.add(bean);
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
		return output;
	}
}
