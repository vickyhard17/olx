package com.olx.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.bean.CateogOutBean;
import com.olx.bean.CtaegoryOutputBean;
import com.olx.bean.StateOutputBean;
import com.olx.util.HibernateUtil;

public class CategoryDAO 
{
	Session session=null;
	Transaction transaction=null;
	public List showCategory()
	{
		CateogOutBean outBean=null;
		List sublist=new ArrayList<>();
		try
		{
			session=com.olx.util.HibernateUtil.hibernateConnection();
			String sql="select c.pkcategoryid,c1.pkcategoryid,c.categoryname,c1.categoryname,c.isparent from Categories c join c.categories c1  "
							+ "where c.isactive='Y' order by c.categoryname";
			Query query=session.createQuery(sql);
			List qry=query.list();
			if(qry!=null && !qry.isEmpty())
			{
				for(Object o:qry)
				{
					outBean=new CateogOutBean();
					Object obj[]=(Object[])o;
					outBean.setCatogId((Long)obj[0]);
					outBean.setSubcatogId((Long)obj[1]);
					outBean.setCatogName((String)obj[2]);
					outBean.setSubcatogName((String)obj[3]);
					outBean.setIsparent((Character)obj[4]);
					sublist.add(outBean);
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
		return sublist;
	}

	public List showCategoryRecord()
	{
		boolean flag=false;
		List qry=null;
		List records=new ArrayList<>();
		StateOutputBean outputBean=null;
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select c.pkcategoryid,c.categoryname from Categories c where c.isparent='Y' and c.isactive='Y'";
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
	public List showSubCategoryRecord(Long id)
	{
		boolean flag=false;
		List qry=null;
		List records=new ArrayList<>();
		StateOutputBean outputBean=null;
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select s.pkcategoryid,s.categoryname from Categories c join c.categories s where c.pkcategoryid=:id and s.isparent='N' "
					+ " and s.isactive='Y'";
			Query query=session.createQuery(sql);
			query.setParameter("id", id);
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
	
	public List showSearchCategory(String name) 
	{
		boolean flag=false;
		List qry=null;
		List records=new ArrayList<>();
		CtaegoryOutputBean outputBean=null;
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select s.pkcategoryid,s.categoryname from Categories c join c.categories s where  s.isparent='N' and s.categoryname like:name";
			Query query=session.createQuery(sql);
			query.setParameter("name","%"+name+"%");
			 qry=query.list();
			if(qry!=null && !qry.isEmpty())
			{
				for(Object obj:qry)
				 {
					outputBean=new CtaegoryOutputBean();
					 Object obj1[]=(Object[])obj;
					 outputBean.setId((Long)obj1[0]);
					 outputBean.setName((String)obj1[1]);
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
}
