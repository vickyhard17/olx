package com.olx.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.bean.StateOutputBean;
import com.olx.pojo.Area;
import com.olx.pojo.Categories;
import com.olx.pojo.City;
import com.olx.pojo.State;
import com.olx.pojo.UserInfo;
import com.olx.util.HibernateUtil;

public class StateDAO 
{
	Session session=null;
	Transaction transaction=null;
	List qry=null;
	public List showStateRecord()
	{
		boolean flag=false;
		List records=new ArrayList<>();
		StateOutputBean outputBean=null;
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select s.pkstateid,s.statename from State s where s.isactive='Y'";
			Query query=session.createQuery(sql);
			 qry=query.list();
			if(qry!=null && !qry.isEmpty())
			{
				for(Object obj:qry)
				 {
					outputBean=new StateOutputBean();
					 Object obj1[]=(Object[])obj;
					 outputBean.setPkId((Long)obj1[0]);
					 outputBean.setStatename((String)obj1[1]);
					 records.add(outputBean);
				 }
				System.out.println(records.toString());
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
		return records;
	}
	public int addState(String sname)
	{
		int rows=0;
		try
		{
			session=HibernateUtil.hibernateConnection();
			State state=new State();
			Date date=new Date();
			state.setStatename(sname);
			state.setIsactive('Y');
			state.setCreateddate(date);
			state.setCreatedby(1L);
			transaction=session.beginTransaction();
			session.save(state);
			transaction.commit();
			rows=1;
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
	public int addCity(String sid,String cid)
	{
		int rows=0;
		try
		{
			session=HibernateUtil.hibernateConnection();
			Long stateid=Long.parseLong(sid);
			City city=new City();
			Date date=new Date();
			city.setCityname(cid);
			city.setCreateddate(date);
			city.setIsactive('Y');
			city.setCreatedby(1L);
			State state=(State)session.get(State.class, stateid);
			Long s=(Long)state.getPkstateid();
			city.setState(state);
			if(s == stateid)
			{
				session.save(city);
				Set set=state.getCities();
				set.add(city);
				state.setCities(set);
				transaction=session.beginTransaction();
				session.update(state);
				transaction.commit();
				rows=1;
			}
			else
			{
				transaction=session.beginTransaction();
				session.save(city);
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
	public int addArea(String arid, String stid, String citiid)
	{
		int rows=0;
		try
		{
			session=HibernateUtil.hibernateConnection();
			Long stateid=Long.parseLong(stid);
			Long citd=Long.parseLong(citiid);
			Area area=new Area();
			Date date=new Date();
			area.setAreaname(arid);
			area.setCreateddate(date);
			area.setIsactive('Y');
			area.setCreatedby(1L);
			State state=(State)session.get(State.class, stateid);
			Long s=(Long)state.getPkstateid();
			City city=(City)session.get(City.class, citd);
			Long c=(Long)city.getPkcityid();
			area.setCity(city);
			city.setState(state);
			if(s == stateid && c == citd)
			{
				session.save(area);
				Set set=state.getCities();
				Set set1=city.getAreas();
				set.add(city);
				set1.add(area);
				state.setCities(set);
				city.setAreas(set1);
				transaction=session.beginTransaction();
				session.update(state);
				session.update(city);
				transaction.commit();
				rows=1;
			}
			else
			{
				transaction=session.beginTransaction();
				session.save(area);
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
	public int addCategory(String catog) 
	{
		int rows=0;
		try
		{
			session=HibernateUtil.hibernateConnection();
			Categories categories=null;
			Date date=new Date();
			String sql="select c "
					+ " from Categories c  where c.categoryname=:catog and c.isparent='Y'";
			Query query=session.createQuery(sql);
			query.setString("catog", catog);
			List list=query.list();
			Categories category=null;
			if(list!=null && !list.isEmpty())
			{
				 category=(Categories)list.get(0);
				String cat=(String)category.getCategoryname();
				if(cat.equals(catog))
				{
				}
				else
				{
					categories=new Categories();
					categories.setCategoryname(catog);
					categories.setIsactive('Y');
					categories.setCreateddate(date);
					categories.setCreatedby(1L);
					categories.setIsparent('Y');
					transaction=session.beginTransaction();
					session.save(categories);
					transaction.commit();
					rows=1;
				}
			}
			else
			{
				categories=new Categories();
				categories.setCategoryname(catog);
				categories.setIsactive('Y');
				categories.setCreateddate(date);
				categories.setCreatedby(1L);
				categories.setIsparent('Y');
				transaction=session.beginTransaction();
				session.save(categories);
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
	public int addSubCategory(String catid, String subcatid) 
	{
		int rows=0;
		try
		{
			session=HibernateUtil.hibernateConnection();
			Long catogid=Long.parseLong(catid);
			Categories subCategories=new Categories();
			Date date=new Date();
			subCategories.setCategoryname(subcatid);
			subCategories.setCreateddate(date);
			subCategories.setIsactive('Y');
			subCategories.setCreatedby(1L);
			subCategories.setIsparent('N');
			Categories subcat=(Categories)session.get(Categories.class, catogid);
			Long categid=(Long)subcat.getPkcategoryid();
			subCategories.setCategory(subcat);
			if(categid == catogid)
			{
				session.save(subCategories);
				Set set=subcat.getCategories();
				set.add(subCategories);
				subcat.setCategories(set);
				transaction=session.beginTransaction();
				session.update(subcat);
				transaction.commit();
				rows=1;
			}
			else
			{
				transaction=session.beginTransaction();
				session.save(subCategories);
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
