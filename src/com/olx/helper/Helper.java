package com.olx.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.olx.bean.AdminInputBean;
import com.olx.bean.AdpostInputBean;
import com.olx.bean.OutputBean;
import com.olx.bean.UserInputBean;
import com.olx.bean.UserOutputBean;
import com.olx.dao.AdPostDAO;
import com.olx.dao.AdminDAO;
import com.olx.dao.StateDAO;
import com.olx.dao.UserDAO;
import com.olx.pojo.AdPost;
import com.olx.pojo.ServerSideValidation;
import com.olx.pojo.UserInfo;

public class Helper 
{
	OutputBean outputBean=new OutputBean();
	public boolean isEmpty(String value)
	{
		boolean flag=false;
		if(value!=null || !"".trim().equals(value))
		{
			flag= true;
		}
		else
		{
			flag= false;
		}
		return flag;
	}
	ServerSideValidation serverSideValidation=new ServerSideValidation();
	public UserOutputBean validateUser(UserInputBean userInputBean)
	{
		UserOutputBean flagstatus=null;
		if(isEmpty(userInputBean.getUserName()) && serverSideValidation.firstNamevalidate(userInputBean.getUserName()))
		{
			outputBean.setIsFlag(false);
			outputBean.setMessage("first name cannot be empty");
		}
		if(isEmpty(userInputBean.getUserPassword()) && serverSideValidation.password(userInputBean.getUserPassword()))
		{
			outputBean.setIsFlag(false);
			outputBean.setMessage("password cannot be empty");
		}
		if(isEmpty(userInputBean.getUserEmail()) && serverSideValidation.email(userInputBean.getUserEmail()))
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("email cannot be empty");
		}
		if(isEmpty(userInputBean.getAddress()) && serverSideValidation.address(userInputBean.getAddress()))
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("first name cannot be empty");
		}
		UserInfo userInfo=new UserInfo();
		userInfo.setUsername(userInputBean.getUserName());
		userInfo.setUseremail(userInputBean.getUserEmail());;
		userInfo.setUserpassword(userInputBean.getUserPassword());
		userInfo.setUsermobile(userInputBean.getUserMobile());
		userInfo.setAddress(userInputBean.getAddress());
		userInfo.setIsactive('Y');
		userInfo.setIsadmin('N');
		Date date=new Date();
		userInfo.setCreateddate(date);
		userInfo.setCreatedby(1L);
		flagstatus=new UserDAO().InsertUser(userInfo);
		return flagstatus;
	}
	public OutputBean checkEmail(UserInputBean inpBeanRegistration)
	{
		OutputBean output=new OutputBean();
		UserInfo userInfo=new UserInfo();
		userInfo.setUseremail(inpBeanRegistration.getUserEmail());
		if(isEmpty(userInfo.getUseremail()))
		{
			UserDAO rdbquery=new UserDAO();
			boolean flag=rdbquery.checkEmail(userInfo);
			if(flag)
			{
				output.setIsFlag(true);
				output.setMessage("email is already taken");
			}
		}
		return output;
	}
	public OutputBean checkMobile(UserInputBean beanRegistration) throws ClassNotFoundException, SQLException, IOException
	{
		UserDAO rdbquery=new UserDAO();
		OutputBean output=new OutputBean();
		UserInfo userInfo=new UserInfo();
		userInfo.setUsermobile(beanRegistration.getUserMobile());
			boolean flag=rdbquery.checkMobile(userInfo);
			if(flag)
			{
				output.setIsFlag(true);
				output.setMessage("number is already taken");
			}
		return output;
	}
	public UserInfo validateLogin(UserInputBean loginInputBean) 
	{
		UserDAO userDAO=new UserDAO();
		UserInfo status=userDAO.showLoginRecord(loginInputBean);
		return status;
	}

	public boolean adPostUser(AdpostInputBean bean,Long id,Long pkid,Long subid) 
	{
		boolean flag=false;
		Date date=new Date();
		AdPost adpost=new AdPost();
		adpost.setTitle(bean.getTitle());
		adpost.setDescription(bean.getDescription());
		adpost.setPrice(bean.getPrice());
		adpost.setShowmobile("Y");
		adpost.setIsactive('Y');
		adpost.setCreateddate(date);
		adpost.setCreatedby(1L);
		adpost.setIsverified('N');
		int aPost=new AdPostDAO().insertAdPostRecord(adpost,id,pkid,subid);
		if(aPost>0)
		{
			flag=true;
		}
		return flag;
	}

	public boolean isAdmin(AdminInputBean adminInputBean)
	{
		boolean status=false;
		boolean flag=new AdminDAO().insertAdminRecord(adminInputBean);
		if(flag)
		{
			status=true;
		}
		return status;
	}
	public OutputBean addState(String sid)
	{
		OutputBean outputBean=new OutputBean();
		int row=new StateDAO().addState(sid);
		if(row>0)
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("added successfully");
		}
		else
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("not added yet");
		}
		return outputBean;
	}
	public OutputBean addCity(String sid,String cid)
	{
		OutputBean outputBean=new OutputBean();
		int row=new StateDAO().addCity(sid,cid);
		if(row>0)
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("added successfully");
		}
		else
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("not added yet");
		}
		return outputBean;
	}
	public OutputBean addArea(String arid,String stid,String citiid)
	{
		OutputBean outputBean=new OutputBean();
		int row=new StateDAO().addArea(arid,stid,citiid);
		if(row>0)
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("added successfully");
		}
		else
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("not added yet");
		}
		return outputBean;
	}
	public OutputBean addCategory(String catog)
	{
		OutputBean outputBean=new OutputBean();
		int row=new StateDAO().addCategory(catog);
		if(row>0)
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("added successfully");
		}
		else
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("not added yet");
		}
		return outputBean;
	}
	public OutputBean addSubCategory(String catid,String subcatid)
	{
		OutputBean outputBean=new OutputBean();
		int row=new StateDAO().addSubCategory(catid,subcatid);
		if(row>0)
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("added successfully");
		}
		else
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("not added yet");
		}
		return outputBean;
	}
	public OutputBean updateName(String names,String email,String value,String pass)
	{		OutputBean outputBean=new OutputBean();
		int row=new UserDAO().nameUpdate(names,email,value,pass);
		if(row>0)
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("added successfully");
		}
		else
		{
			outputBean.setIsFlag(true);
			outputBean.setMessage("not added yet");
		}
		return outputBean;
	}

	public List allPost(Long userid) 
	{
		List list=new AdPostDAO().allPostRecord(userid);
		return list;
	}
	public List userProfile(Long userid) 
	{
		List list=new AdPostDAO().userRecord(userid);
		return list;
	}
	public List allIsVerify()
	{
		List list=new AdPostDAO().allVerify();
		return list;
	}
	public List allUnVerify()
	{
		List list=new AdPostDAO().allVerify();
		return list;
	}
	
}
