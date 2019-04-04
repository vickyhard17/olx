<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.olx.bean.AdPostOutBean"%>
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

	List obj=(ArrayList)session.getAttribute("list");
	/* for(int i=0;i<obj.size();i++)
	{ */if(obj != null && obj.size() > 0)
	{
		AdPostOutBean bean=(AdPostOutBean)obj.get(0);
	%>
	<div class="proddisplay1" id="<%=bean.getAdid()%>" >
	<div class="image1"><img src="<%=request.getContextPath() %>/images/<%=bean.getImagename() %>"></div>
	<div class="title1"><%=bean.getTitle() %></div>
	<div class="desc1"><%=bean.getDescription() %></div>
	<div class="rightpart">
	<div class="price1"><img src="<%=request.getContextPath()%>/images/rupeesymbol.png"><span class="rupee"><%=bean.getPrice() %></span></div>
		<div class="catprod"><%=bean.getSubcategory() %></div>
	<div class="name"><%=bean.getName() %></div>
	<% 
	String email1=(String)session.getAttribute("email1");
	String email=(String)session.getAttribute("email");
	if(email == null && email1  == null)
	{%>

		<div id="<%=email %>"  class="number">+91-<input type="hidden"  id="sellerpath" name="action" value="<%=request.getContextPath()%>"><a href="#" id="number" onclick="obj.showloginpopup2();">Show mobile number</a></div>
	<% }
	else
	{%>
		<div id="<%=email %>" class="number">+91-<input type="hidden"  id="detailpath" name="action" value="<%=request.getContextPath()%>"><a href="#" id="number"><%=bean.getContact() %></a></div>
	<% }
	%>
	
	
	<div class="area1"><span><%=bean.getArea() %></span>
	<span><%=bean.getCity() %></span>
	<span><%=bean.getState() %></span>
</div>
	</div>
		
	<%} %>
	<div class="cleargrid"></div>
	</div></div>
</body>
</html>