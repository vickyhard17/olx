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
<body onload="obj.showCategory();obj.showManyInOne();">
<%-- <jsp:include page="<%=request.getContextPath() %>/jsp/header.jsp" /> --%>
<%@ include file="/jsp/header.jsp" %>
	<div class="banner">
		<img alt="no image found" src="<%=request.getContextPath()%>/images/banner.png">
	</div>
	<div class="section">
<h2 class="popular">Popular Categories</h2>
<div class="categories">
</div>
<div class='cleargrid'></div>
<div class="proddiv">

</div>
</div>
</body>
</html>