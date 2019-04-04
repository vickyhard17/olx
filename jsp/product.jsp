<%@page import="java.util.ArrayList"%>
<%@page import="com.olx.bean.AdPostOutBean"%>
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

	List obj=(ArrayList)session.getAttribute("list");
	for(int i=0;i<obj.size();i++)
	{
		AdPostOutBean bean=(AdPostOutBean)obj.get(i);
	%>
	<div class="proddisplay" id="<%=bean.getAdid()%>" onclick="obj.showAllProduct(this.id)">
	<div class="image"><img src="<%=request.getContextPath() %>/images/<%=bean.getImagename() %>"></div>
	<div class="title"><%=bean.getTitle() %></div>
	<div class="description"><%=bean.getDescription() %></div>
	<div class="price"><img src="<%=request.getContextPath()%>/images/rupeesymbol.png"><%=bean.getPrice() %></div>
	<div class="subcatogary"><%=bean.getSubcategory() %></div>
	<div class="area">
	<span><%=bean.getArea() %></span>
	<span><%=bean.getCity() %></span>
	<span><%=bean.getState() %></span>
	</div>
	</div>
	<%} %>
	<div class="cleargrid"></div>
	</div>
</body>
</html>