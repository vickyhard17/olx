package com.olx.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.olx.bean.CtaegoryOutputBean;
import com.olx.bean.OutputBean;
import com.olx.bean.UserInputBean;
import com.olx.dao.AdPostDAO;
import com.olx.dao.AreaDAO;
import com.olx.dao.CategoryDAO;
import com.olx.dao.CityDAO;
import com.olx.dao.StateDAO;
import com.olx.dao.UserDAO;
import com.olx.helper.Helper;
import com.olx.pojo.AdPost;
import com.olx.pojo.UserInfo;


public class CommonAjaxController
{
	public String toJSON(Object obj)
	{
		Gson gsonObj=new GsonBuilder().create();
		return gsonObj.toJson(obj);
	}
	public String checkShowCategory(HttpServletRequest request,HttpServletResponse response)
	{
		List category=new CategoryDAO().showCategory();
		return toJSON(category);
	}
	public String checkSearchCategory(HttpServletRequest request,HttpServletResponse response)
	{
		String name=request.getParameter("id");
		List category=new CategoryDAO().showSearchCategory(name);
		return toJSON(category);
	}
	public String checkEmail(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{
		Helper rghelper=new Helper();
		UserInputBean inputBeanSignup=new UserInputBean();
		OutputBean outputBean=new OutputBean();
		String email=req.getParameter("email");
		inputBeanSignup.setUserEmail(email);
		outputBean =rghelper.checkEmail(inputBeanSignup);
		return toJSON(outputBean);
	}
	public String checkMobile(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException, IOException
	{
		Helper rghelper=new Helper();
		UserInputBean inputBeanSignup=new UserInputBean();
		OutputBean outputBean=new OutputBean();
		Long contact=Long.parseLong(req.getParameter("contact"));
		inputBeanSignup.setUserMobile(contact);
		outputBean=rghelper.checkMobile(inputBeanSignup);
		return toJSON(outputBean);
	}
	public String checkSellerId(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		UserDAO userDAO=new UserDAO();
		UserInputBean inputBeanSignup=new UserInputBean();
		String email=req.getParameter("emailid");
		session.setAttribute("email", email);
		inputBeanSignup.setUserEmail(email);
		Long sellerid=userDAO.checkSellerId(inputBeanSignup);
		return  toJSON(sellerid);
	}
	public String checkLogin(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession session=req.getSession();
		UserDAO userDAO=new UserDAO();
		UserInputBean inputBeanSignup=new UserInputBean();
		String email=req.getParameter("eid");
		String password=req.getParameter("pid");
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		inputBeanSignup.setUserEmail(email);
		inputBeanSignup.setUserPassword(password);
		UserInfo userInfo=new Helper().validateLogin(inputBeanSignup);
		return  toJSON(userInfo);
	}
	public String checkState(HttpServletRequest req,HttpServletResponse res)
	{
		List state=new StateDAO().showStateRecord();
		return  toJSON(state);
	}
	public String checkCity(HttpServletRequest req,HttpServletResponse res)
	{
		Long sid=Long.parseLong(req.getParameter("sid"));
		List city=new CityDAO().showCityRecord(sid);
		return  toJSON(city);
	}
	public String checkArea(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		Long aid=Long.parseLong(req.getParameter("aid"));
		session.setAttribute("aid", aid);
		List area=new AreaDAO().showAreaRecord(aid);
		return  toJSON(area);
	}
	public String checkSubcatog(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		Long subid=Long.parseLong(req.getParameter("subid"));
		session.setAttribute("subid", subid);
		List subcategory=new CategoryDAO().showSubCategoryRecord(subid);
		return  toJSON(subcategory);
	}
	public String checkProduct(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session=req.getSession();
		Long subid=Long.parseLong(req.getParameter("pid"));
		session.setAttribute("pid", subid);
		List subcategory=new AdPostDAO().showProduct(subid);
		session.setAttribute("list", subcategory);
		return  toJSON(subcategory);
	}
	public String checkProducts(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session=req.getSession();
		List subcategory=new AdPostDAO().showProducts();
		session.setAttribute("list", subcategory);
		return  toJSON(subcategory);
	}
	public String checkAllProduct(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session=req.getSession();
		Long subid=Long.parseLong(req.getParameter("pid"));
		session.setAttribute("ppid", subid);
		List subcategory=new AdPostDAO().showAllProduct(subid);
		session.setAttribute("list", subcategory);
		return  toJSON(subcategory);
	}
}
