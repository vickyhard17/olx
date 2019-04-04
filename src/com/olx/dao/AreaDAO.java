package com.olx.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.olx.util.HibernateUtil;

public class AreaDAO
{
	Session session=null;
	List qry=null;
	public List showAreaRecord(Long id)
	{
		boolean flag=false;
		List arearecord=null;
		List records=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select a.pkareaid,a.areaname from City c join c.areas a where c.pkcityid=:id and a.isactive='Y'";
			Query query=session.createQuery(sql);
			query.setParameter("id", id);
			 qry=query.list();
			if(qry!=null && !qry.isEmpty())
			{
				for(Object obj:qry)
				 {
					arearecord=new ArrayList<>();
					 Object obj1[]=(Object[])obj;
					 arearecord.add((Long)obj1[0]);
					 arearecord.add((String)obj1[1]);
					 records.add(arearecord);
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
		return records;
	}
}
