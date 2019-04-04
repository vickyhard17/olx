<%@page import="com.olx.bean.AdPostOutBean"%>
<%@page import="java.util.ArrayList"%>
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
				<div class="proddisplay" id="<%=bean.getAdid() %>" onclick="obj.showAllProduct(this.id)">
					<div><%=bean.getTitle() %></div>
					<div><%=bean.getDescription() %></div>
					<div><%=bean.getPrice() %></div>
					<div><%=bean.getName() %></div>
					<div><%=bean.getContact() %></div>
					<div><%=bean.getArea() %></div>
					<div><%=bean.getCity() %></div>
					<div><%=bean.getState() %></div>
					<div><%=bean.getSubcategory() %></div>
			</div>

				<%} %>
				<div class="cleargrid"></div>
				</div>
</body>
</html>