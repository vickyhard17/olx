package com.olx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import com.olx.bean.AdminInputBean;
import com.olx.bean.AdpostInputBean;
import com.olx.bean.OutputBean;
import com.olx.bean.UserInputBean;
import com.olx.bean.UserOutputBean;
import com.olx.dao.AdPostDAO;
import com.olx.helper.Helper;
import com.olx.pojo.AdPost;
import com.olx.pojo.UserInfo;
import com.olx.util.HibernateUtil;

/**
 * Servlet implementation class CommonController
 */
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    @Override
    public void init() throws ServletException 
    {
    	 HibernateUtil hibernateUtil=new HibernateUtil();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserInputBean userInputBean=new UserInputBean();
		Helper helper=new Helper();
		HttpSession session=request.getSession();
		String action=request.getParameter("signupaction");
		String action1=request.getParameter("loginaction");
		if(action!=null && !"".equals(action))
		{
			if("signup".equals(action))
			{
				userInputBean.setUserName(request.getParameter("firstname"));
				userInputBean.setUserEmail(request.getParameter("email"));
				userInputBean.setUserPassword(request.getParameter("password"));
				userInputBean.setUserMobile(Long.parseLong(request.getParameter("contact")));
				userInputBean.setAddress(request.getParameter("address"));
				UserOutputBean result=helper.validateUser(userInputBean);
				if(result!=null && result.getIsAdmin()=='N')
				{
					session.setAttribute("firstname", result.getName());
					session.setAttribute("contact",result.getContact());
					session.setAttribute("id", result.getPkid());
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}
				else if(result!=null && result.getIsAdmin()=='Y')
				{
					session.setAttribute("firstname", result.getName());
					session.setAttribute("contact",result.getContact());
					session.setAttribute("id", result.getPkid());
					response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
				}
				else
				{
					RequestDispatcher rreDispatcher=request.getRequestDispatcher("/index.jsp");
					rreDispatcher.include(request, response);
				}
			}
			else if("login".equals(action))
			{
				String loginaction=request.getParameter("loginaction");
				 session=request.getSession();
				Helper helper1=new Helper();
				UserInputBean inputBean=new UserInputBean();
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				inputBean.setUserEmail(email);
				inputBean.setUserPassword(password);
				UserInfo result=null;
				 if(email!=null && password!=null)
				 {
						result=helper1.validateLogin(inputBean);
						try
						{
							if(result!=null && result.getIsadmin()=='N')
							{
								session.setAttribute("email", email);
								session.setAttribute("password", password);
								session.setAttribute("firstname", result.getUsername());
								session.setAttribute("contact", result.getUsermobile());
								session.setAttribute("pkid",result.getPkuserid());
								session.setAttribute("isadmin",result.getIsadmin());
								response.sendRedirect(request.getContextPath()+"/index.jsp");
							}
							else if(result!=null && result.getIsadmin()=='Y')
							{
								session.setAttribute("email", email);
								session.setAttribute("password", password);
								session.setAttribute("firstname", result.getUsername());
								session.setAttribute("contact", result.getUsermobile());
								session.setAttribute("pkid",result.getPkuserid());
								session.setAttribute("isadmin",result.getIsadmin());
								response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
							}
							else
							{
								response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
							}
						}
						catch(Exception e)
						{
							response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
						}
					} 
				 	else
					{
						response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
					}
				 }
			}
		else if("adpost".equals(action))
			{
				AdpostInputBean bean=new AdpostInputBean();
				bean.setTitle(request.getParameter("Title"));
				bean.setDescription(request.getParameter("Description"));
				bean.setPrice(Float.parseFloat(request.getParameter("Price")));
				bean.setPostImages(request.getParameter("PostImage"));
				bean.setName((String)request.getAttribute("firstname"));
				bean.setShowMobile(request.getParameter("mobile"));
				bean.setContact((Long)session.getAttribute("contact"));
				Long id=Long.parseLong(request.getParameter("area"));
				Long userid=(Long)session.getAttribute("pkid");
				Long subid=Long.parseLong(request.getParameter("Subcateg"));
				boolean adPost=new Helper().adPostUser(bean,id,userid,subid);
				try
				{
					if(adPost)
					{
						response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+"/jsp/adposterror.jsp");
					}
				}
				catch(Exception e)
				{
					response.sendRedirect(request.getContextPath()+"/jsp/adposterror.jsp");
				}
			}
			else if("admin".equals(action))
			{
				AdminInputBean adminInputBean=new AdminInputBean();
				adminInputBean.setState("state");
				adminInputBean.setCity("city");
				adminInputBean.setArea("area");
				adminInputBean.setCategory("cat");
				adminInputBean.setSubCategory("subcat");
				adminInputBean.setShowVerified('Y');
				adminInputBean.setShowAllAdd('Y');
				boolean flag=new Helper().isAdmin(adminInputBean);
				if(flag)
				{
					response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
				}
			}
			else if("post".equals(action))
			{
				Long userid=(Long)session.getAttribute("pkid");
				List list=new Helper().allPost(userid);
				if(list!=null && !list.isEmpty())
				{
					session.setAttribute("list", list);
					response.sendRedirect(request.getContextPath()+"/jsp/productdetail.jsp");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/jsp/adposterror.jsp");
				}
			}
			else if("unverify".equals(action))
			{
				Long verid=Long.parseLong(request.getParameter("unid"));
				boolean adpost=new AdPostDAO().allVerifyById(verid);
				if(adpost)
				{
					response.sendRedirect(request.getContextPath()+"/jsp/unverified.jsp");
				}
				else
				{
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("/jsp/admin.jsp");
					requestDispatcher.include(request, response);
				}
			}
			else if("verify".equals(action))
			{
				Long verid=Long.parseLong(request.getParameter("vid"));
				boolean adpost=new AdPostDAO().allUnverifyById(verid);
				if(adpost)
				{
					response.sendRedirect(request.getContextPath()+"/jsp/verify.jsp");
				}
				else
				{
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("/jsp/admin.jsp");
					requestDispatcher.include(request, response);
				}
			}
	
		if(action1!=null && !"".equals(action1))
		{
			if("login1".equals(action1))
			{
				 session=request.getSession();
				Helper helper1=new Helper();
				UserInputBean inputBean=new UserInputBean();
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				inputBean.setUserEmail(email);
				inputBean.setUserPassword(password);
				UserInfo result=null;
				 if(email!=null && password!=null)
				 {
					try
					{
						result=helper1.validateLogin(inputBean);
						if(result!=null && result.getIsadmin()=='N')
						{
							session.setAttribute("email", email);
							session.setAttribute("password", password);
							session.setAttribute("firstname", result.getUsername());
							session.setAttribute("contact", result.getUsermobile());
							session.setAttribute("pkid",result.getPkuserid());
							response.sendRedirect(request.getContextPath()+"/jsp/adpost.jsp");
						}
						else if(result!=null && result.getIsadmin()=='Y')
						{
							session.setAttribute("email", email);
							session.setAttribute("password", password);
							session.setAttribute("firstname", result.getUsername());
							session.setAttribute("contact", result.getUsermobile());
							session.setAttribute("pkid",result.getPkuserid());
							response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
						}
						else
						{
							response.sendRedirect(request.getContextPath()+"/index.jsp");
						}				
					} 
					catch (Exception  e)
					{
						e.printStackTrace();	
					} 
				 }
			}

			 else if("login2".equals(action1))
				{
					 session=request.getSession();
					Helper helper2=new Helper();
					UserInputBean inputBean1=new UserInputBean();
					String email1=request.getParameter("email");
					String password1=request.getParameter("password");
					inputBean1.setUserEmail(email1);
					inputBean1.setUserPassword(password1);
					UserInfo result1=null;
					 if(email1!=null && password1!=null)
					 {
						try
						{
							result1=helper2.validateLogin(inputBean1);
							if(result1!=null && result1.getIsadmin()=='N')
							{
								session.setAttribute("email1", email1);
								session.setAttribute("password1", password1);
								session.setAttribute("firstname1", result1.getUsername());
								session.setAttribute("contact1", result1.getUsermobile());
								session.setAttribute("pkid1",result1.getPkuserid());
								session.setAttribute("isadmin1", result1.getIsadmin());
								response.sendRedirect(request.getContextPath()+"/jsp/categorydetails.jsp");
							}
							else if(result1!=null && result1.getIsadmin()=='Y')
							{
								session.setAttribute("email1", email1);
								session.setAttribute("password1", password1);
								session.setAttribute("firstname1", result1.getUsername());
								session.setAttribute("contact1", result1.getUsermobile());
								session.setAttribute("pkid1",result1.getPkuserid());
								session.setAttribute("isadmin1", result1.getIsadmin());
								response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
							}
							else
							{
								response.sendRedirect(request.getContextPath()+"/index.jsp");
							}				
						} 
						catch (Exception  e)
						{
							e.printStackTrace();	
						} 
					 }
					 
				}
		}
}	
	@Override
	public void destroy()
	{
		HibernateUtil.closeFactorySession();
	}

}
