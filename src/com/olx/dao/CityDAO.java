package com.olx.dao;

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.mapping.Array;

import org.hibernate.Query;
import org.hibernate.Session;

import com.olx.util.HibernateUtil;

public class CityDAO
{
	Session session=null;
	List qry=null;
	public List showCityRecord(Long id)
	{
		boolean flag=false;
		List cityrecord=null;
		List records=new ArrayList<>();
		try
		{
			session=HibernateUtil.hibernateConnection();
			String sql="select c.pkcityid,c.cityname from State s join s.cities c where s.pkstateid=:id and c.isactive='Y'";
			Query query=session.createQuery(sql);
			query.setParameter("id", id);
			 qry=query.list();
			if(qry!=null && !qry.isEmpty())
			{
				for(Object obj:qry)
				 {
					 cityrecord=new ArrayList<>();
					 Object obj1[]=(Object[])obj;
					 cityrecord.add((Long)obj1[0]);
					 cityrecord.add((String)obj1[1]);
					 records.add(cityrecord);
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
