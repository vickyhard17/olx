<%@page import="com.olx.bean.OutputBean"%>
<%@page import="com.olx.helper.Helper"%>
<%@page import="com.olx.bean.UserProfileBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OLX</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/app.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include> 
 <div class="proddiv" >
<%
Long userid=(Long)session.getAttribute("pkid");
String name=request.getParameter("name");
String email=request.getParameter("email");
String mobile=request.getParameter("mob");
String pass=request.getParameter("pass");
OutputBean names=new Helper().updateName(name,email,mobile,pass);
List obj=new Helper().userProfile(userid);
if(obj != null)
{
	for(int i=0;i<obj.size();i++)
	{
		UserProfileBean bean=(UserProfileBean)obj.get(i);
		session.setAttribute("emailid", bean.getEmail());
		session.setAttribute("uname", bean.getName());
		session.setAttribute("umobile", bean.getMobile());
%>
	<div class="proddisplay2" >
	<div class="uname">user-name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=bean.getName() %></div>
	<div class="uemail">user-email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=bean.getEmail()%></div>
	<div class="umob">user-password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=bean.getMobile() %></div>
	<div class="uadd">user-address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=bean.getAddress() %></div>
</div>
	<%} 
	}%>
	<div class="cleargrid"></div>
	<div>
	<ul class="noBullet">
	<b>Update Your Name:</b>
	<li>
	<input type="text" class="inputFields" id="updatename" name="updatename" maxlength="15" value="<%=(String)session.getAttribute("uname")%>"/><span id="nerror"><%=names.getMessage() %></span>
				<input type="hidden"  id="eid" value="<%=(String)session.getAttribute("emailid")%>"> 
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="UPDATE NAME" onclick="obj.nameUpdate();">
			  </li>
	<b>Update Your Mobile No:</b>
	<li>
	<input type="text" class="inputFields" id="updatemob" name="updatemob" maxlength="10" value="<%=(Long)session.getAttribute("umobile")%>"/><span id="nerror"><%=names.getMessage() %></span>
				<input type="hidden"  id="eid" value="<%=(String)session.getAttribute("emailid")%>"> 
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="UPDATE MOBILE" onclick="obj.nameUpdate();">
			  </li>
			  <b>Old Password:</b>
	<li>
	<input type="text" class="inputFields" id="oldone" name="oldone"  maxlength="15"/><span id="oerror"></span>
			  </li>
			   <b>New  Password:</b>
	<li>
	<input type="text" class="inputFields" id="newone" name="newone"  maxlength="15"/><span id="nerror"></span>
			  </li>
			  <b>Confirm  Password:</b>
	<li>
	<input type="text" class="inputFields" id="cnfone" name="cnfone"  maxlength="15"/><span id="cnferror"></span>
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="UPDATE PASSWORD"  onclick="obj.nameUpdate();">
			  </li>
	</ul>
	</div>
</div>
</body>
</html>