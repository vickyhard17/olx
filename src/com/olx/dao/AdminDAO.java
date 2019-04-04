package com.olx.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.olx.bean.AdminInputBean;
import com.olx.pojo.Area;
import com.olx.pojo.Categories;
import com.olx.pojo.City;
import com.olx.pojo.State;
import com.olx.util.HibernateUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class AdminDAO
{
	Session session=null;
	Transaction transaction=null;
	public boolean insertAdminRecord(AdminInputBean adminInputBean)
	{
		boolean flag=false;
		try
		{
			Date date=new Date();
			session=HibernateUtil.hibernateConnection();
			State state=new State();
			state.setStatename(adminInputBean.getState());
			state.setIsactive('Y');
			state.setCreateddate(date);
			state.setCreatedby(1L);
			City city=new City();
			city.setCityname(adminInputBean.getCity());
			city.setIsactive('Y');
			city.setCreateddate(date);
			city.setCreatedby(1L);
			Set c=new HashSet<>();
			c.add(city);
			state.setCities(c);
			Area area=new Area();
			area.setAreaname(adminInputBean.getArea());
			area.setIsactive('Y');
			area.setCreateddate(date);
			area.setCreatedby(1L);
			Set a=new HashSet<>();
			a.add(area);
			city.setAreas(a);
			Categories category=new Categories();
			category.setCategoryname(adminInputBean.getCategory());
			category.setIsactive('Y');
			category.setIsparent('Y');
			category.setCreateddate(date);
			category.setCreatedby(1L);
			Categories subCategories=new Categories();
			subCategories.setCategoryname(adminInputBean.getSubCategory());
			subCategories.setIsparent('N');
			subCategories.setIsactive('Y');
			subCategories.setCreateddate(date);
			subCategories.setCreatedby(1L);
			Set s=new HashSet<>();
			s.add(subCategories);
			category.setCategories(s);
			transaction=session.beginTransaction();
			session.save(state);
			session.save(city);
			session.save(category);
			transaction.commit();
			flag=true;
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
}
