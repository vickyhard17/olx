<%@page import="com.olx.bean.AdPostOutBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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