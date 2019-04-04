<%@page import="com.olx.dao.CategoryDAO"%>
<%@page import="com.olx.bean.StateOutputBean"%>
<%@page import="java.util.List"%>
<%@page import="com.olx.dao.StateDAO"%>
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
<style type="text/css">
body{background-color: aquamarine;}
.headadpost h1{ text-align: center;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="headadpost"><h1>USER ADPOST DETAILS</h1><br><br></div>
<div class="adpostSection" >
<!--form start here-->
		  <form action="<%=request.getContextPath()%>/CommonController"  name="signupform" method="post">
			<h2>Adpost</h2><br>
			<hr><br>
				<input type="hidden"  name="signupaction" value="adpost">
			<ul class="noBullet">
			
					  <%
				  CategoryDAO categoryDAO=new CategoryDAO();
			  List list1=categoryDAO.showCategoryRecord();
			 %>
			   <li><b>Select Maincategory:</b>
					<select id="Maincategory" name="Maincategory" onchange="obj.subCatog(this.value);">
					 <option value='' >Select Maincategory</option>
			<%
			for (int i = 0; i < list1.size(); i++) {
				StateOutputBean category=(StateOutputBean)list1.get(i);
			  %>
			  <option value="<%=category.getPkId()%>" ><%=category.getStatename()%></option>
				<%
				session.setAttribute("categpkid", category.getPkId());		
			} %></select><span id="displaymaincategory"></span>
				</li><br><br>
				<li><b>Select Subcategory:</b>
					<select id="Subcateg" name="Subcateg" >
					</select><span id="displaysubcategory"></span>
				</li><br><br>
			  <b>Title:</b><li>
				<label for="Title"></label>
				<input type="text" class="inputFields" id="Title" name="Title" placeholder="Title" maxlength="15"/><span id="Titleerror"></span>
			  </li>
			  <b>Description:</b><li>
				<label for="Description"></label>
				<input type="text" class="inputFields" id="Description" name="Description" placeholder="Description" maxlength="100" /><span id="descerror"></span>
			  </li>
			  <b>Price:</b><li>
				<label for="Price"></label>
				<input type="text" class="inputFields" id="Price" name="Price" placeholder="Price" maxlength="15"/><span id="priceerror"></span>
			  </li>
			   <b>Post Image:</b><li>
				<label for="PostImage"></label>
				<input type="file" class="inputFields" id="PostImage" name="PostImage" placeholder="Post Image" />
				<span id="posterror"></span>
			  </li>
			   <%
			  StateDAO stateDAO=new StateDAO();
			  List list=stateDAO.showStateRecord();
			  int count=0;  %>
			   <li><b>Select State:</b>
			   <select id="state" name="state"  onchange="obj.showCity(this.value);">	
			   <option value='' >Select State</option>
			<%
			for (int i = 0; i < list.size(); i++) {
				StateOutputBean state=(StateOutputBean)list.get(i);
			  %>
			  <option value="<%=state.getPkId()%>" ><%=state.getStatename()%></option>
				<%
			session.setAttribute("stateid", state.getPkId());	
			} %>
				</select>
					<span id="displaystate"></span>
				</li><br><br>
			  <li><b>Select City:</b>
					<select id="city" name="city" onchange="obj.showArea(this.value);">
					</select><span id="displaycity"></span>
				</li><br><br>
			 <li><b>Select Area:</b>
					<select id="area" name="area">
					</select><span id="displayarea"></span>
				</li><br><br>
			  <b>Name:</b><li>
			  <b id="uname" ><%=(String)session.getAttribute("firstname") %></b>
							  </li>
			   <b>Contact:</b><li>
				<label for="Contact"></label>
				<!-- <input type="text" class="inputFields" id="contact" name="contact" placeholder="Contact" maxlength="10" onblur="obj.checkMobile();"/> -->
				<b id="mob" ><%=(Long)session.getAttribute("contact")%></b>
				<span id="contacterror"></span>
			  </li>
			  <li>
				<label for="Show Mobile"><b>Show Mobile:&nbsp;&nbsp;</b></label>
				&nbsp;&nbsp;&nbsp;<input type="radio"  name="gender" value="Y"/>&nbsp;&nbsp;&nbsp;Yes&nbsp;&nbsp;&nbsp;
				<input type="radio"  name="mobile" value="N"/>&nbsp;&nbsp;&nbsp;No
				<span id="displaygender"></span>
			  </li><br><br>
			   <li><input type="hidden"  name="signupaction" value="adpost"></li>
			  <li><input type="hidden" id="path" name="signupaction" value="<%=request.getContextPath() %>"></li>
			   <li><input type="hidden" id="conpath" name="signupaction" value="<%=request.getContextPath() %>"></li>
			   <li><input type="hidden" name="action" id="mainpath" value="<%=request.getContextPath()%>"></li>
			  <li>
				<input type="submit" id="postbtn" name="leftbtn" alt="leftbtn" value="POST">
				</li><br>
			</ul>
		  </form>
<!--form end here-->
</div>
</body>
</html>