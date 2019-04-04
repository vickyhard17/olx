<%@page import="com.olx.bean.AdPostOutBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
 	 <script type="text/javascript" src="<%=request.getContextPath() %>/js/app.js"></script>
	 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Successfully Added Adpost Record</h1>
<div class="adminhome" >
		  <form action="<%=request.getContextPath()%>/CommonController"  name="signupform" method="post">
				<h2>ALL POST</h2><br>
				<hr><br>
				<ul class="noBullet">
					<li>
						<input type="submit" id="postbtn" name="leftbtn" alt="leftbtn" value="ALL POST">
						 <input type="hidden"  name="signupaction" value="post"></li>
				</ul>
			 </form>
		</div>
		</body>
</html>