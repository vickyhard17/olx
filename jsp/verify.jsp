<%@page import="com.olx.bean.AdPostOutBean"%>
<%@page import="java.util.List"%>
<%@page import="com.olx.bean.OutputBean"%>
<%@page import="com.olx.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<title>OLX</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/app.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include> 
 <div class="proddiv2" >
<% 
Helper helper=new Helper();
String name=(String)session.getAttribute("firstname");
List isverified=helper.allUnVerify();
if(isverified != null)
{
	for(int i=0;i<isverified.size();i++)
	{
		AdPostOutBean bean=(AdPostOutBean)isverified.get(i);
		session.setAttribute("adid", bean.getAdid());
	%>
	<div class="proddisplay2" >
	<div class="image2"><img src="<%=request.getContextPath() %>/images/<%=bean.getImagename() %>"></div>
	<div class="title"><%=bean.getTitle() %></div>
	<div class="description"><%=bean.getDescription() %></div>
	<div class="price"><%=bean.getPrice() %></div>
	<div class="name"><%=bean.getName() %></div>
	<div><%=bean.getContact() %></div>
	<div class="area">
	<span><%=bean.getArea() %></span>
	<span><%=bean.getCity() %></span>
	<span><%=bean.getState() %></span>
	</div>
	<form action="<%=request.getContextPath() %>/CommonController"  name="signupform" method="post">
	<input type="hidden"  name="signupaction" value="unverify"  id="<%= bean.getAdid()%>">
	<input type="hidden"  name="unid" value="<%= bean.getAdid()%>" >
	<input type="submit" id="btn-info" name="leftbtn" alt="leftbtn" value="INACTIVE" >
	</form>
	</div>
	<div class="cleargrid"></div>
	<%} 
	}
	else
	{
		
	}%>
</div>
</body>
</html>