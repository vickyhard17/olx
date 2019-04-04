<%@page import="com.olx.bean.OutputBean"%>
<%@page import="com.olx.helper.Helper"%>
<%@page import="java.util.List"%>
<%@page import="com.olx.dao.StateDAO"%>
<%@page import="com.olx.bean.StateOutputBean"%>
<%@page import="com.olx.dao.CategoryDAO"%>
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
body{background-color: white;}
.head h1{    text-align: center;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="head"><h1>ADMIN HOME PAGE</h1><br><br></div>
<div class="adminhome" >
<!--form start here-->
		  <form action="<%=request.getContextPath()%>/CommonController"  name="signupform" method="post">
			<h2>ADMIN POST</h2><br>
			<hr><br>
			<ul class="noBullet">
			<%
			Long id=(Long)session.getAttribute("pkid");
			Long adminid=(Long)session.getAttribute("adid");
			  StateDAO stateDAO=new StateDAO();
			  List list=stateDAO.showStateRecord();
			  int count=0;  
				String sid=request.getParameter("name");
				String cid=request.getParameter("cid");
				String sid1=request.getParameter("sid");
				String arid=request.getParameter("arid");
				String stid=request.getParameter("stid");
				String citiid=request.getParameter("citid");
				String catog=request.getParameter("catog");
				String catid=request.getParameter("catid");
				String subcatid=request.getParameter("subcatid");
				
				Helper helper=new Helper();
				OutputBean row=helper.addState(sid); 
				OutputBean cityrow=helper.addCity(sid1, cid);
				OutputBean arearow=helper.addArea(arid, stid, citiid);
				OutputBean catrow=helper.addCategory(catog);
				OutputBean subcat=helper.addSubCategory(catid,subcatid);
		
				
				
				%>
				 <b>State:</b><li>
				<label for="Title"></label>
				<input type="text" class="inputFields" id="stateid" name="stateid" placeholder="state" maxlength="15"/><span id="Titleerror"></span>
						<span id="displaystate"><%=row.getMessage()
					%></span>
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="ADD STATE" onclick="obj.addState();">
				</li>
			  <b>City:</b><li>
				<label for="Description"></label>
				
			   <b>Select State:</b>
			   <select id="state" name="state"  onchange="obj.showCity(this.value);">	
			      <option value='' >Select State</option>
			   <%
			for (int i = 0; i < list.size(); i++) {
			 	StateOutputBean state=(StateOutputBean)list.get(i);
			 	session.setAttribute("stateid", state.getPkId());	
			  %>
			  <option value="<%=state.getPkId()%>" ><%=state.getStatename()%></option>
			  <%	} %>
				</select>
				<input type="text" class="inputFields" id="cityid" name="cityid" placeholder="city" maxlength="15" /><span id="descerror"><%=cityrow.getMessage() %></span>
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="ADD CITY" onclick="obj.addCity();">
			  </li>  	
			  <b>Area:</b><li>
				
			  <b>Select State:</b>
			   <select id="state1" name="state"  onchange="obj.showCity(this.value);">	
			      <option value='' >Select State</option>
			   <%
			for (int i = 0; i < list.size(); i++) {
			 	StateOutputBean state=(StateOutputBean)list.get(i);
			 	session.setAttribute("stateid", state.getPkId());	
			  %>
			  <option value="<%=state.getPkId()%>" ><%=state.getStatename()%></option>
			  <%	} %>
				</select>
			  <b>Select city:</b>
				<select id="city" name="city" onchange="obj.showArea(this.value);">
					</select><span id="displaycity"></span><span id="displayarea"></span>
					<input type="text" class="inputFields" id="areaid" name="areaid" placeholder="area" maxlength="15"/><span id="priceerror"><%=arearow.getMessage() %></span>
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="ADD AREA" onclick="obj.addArea();">
			  </li>
			   <b>Category:</b><li>
				<input type="text" class="inputFields" id="cat" name="cat" placeholder="cat" maxlength="15"/>
				</select><span id="displaymaincategory"><%=catrow.getMessage() %></span>
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="ADD CATEGORY" onclick="obj.addCategory();">
			  </li>
				 <b>Subcategory:</b><li>
			  <b>Select Maincategory:</b>
					<select id="Maincategory" name="Maincategory" onchange="obj.subCatog(this.value);">
					<% CategoryDAO categoryDAO=new CategoryDAO();
					  List list1=categoryDAO.showCategoryRecord();
						for (int i = 0; i < list1.size(); i++) {
							StateOutputBean category=(StateOutputBean)list1.get(i); %>
				  <option value="<%=category.getPkId()%>" ><%=category.getStatename()%></option>
				<%
				session.setAttribute("categpkid", category.getPkId());		
			} %>
			</select>
				<input type="text" class="inputFields" id="subcat" name="subcat" placeholder="subcat" maxlength="15"/><span id="cerror"><%=subcat.getMessage() %></span>
				<input type="button" id="postbtn" name="leftbtn" alt="leftbtn" value="ADD SUBCATEGORY" onclick="obj.addSubCategory();">
			  </li>
				 <li><input type="hidden"  name="signupaction" value="admin"></li>
			  <li><input type="hidden" id="path" name="signupaction" value="<%=request.getContextPath() %>"></li>
			   <li><input type="hidden" id="conpath" name="signupaction" value="<%=request.getContextPath() %>"></li>
			   <li><input type="hidden" name="action" id="mainpath" value="<%=request.getContextPath()%>"></li>
			  </ul>
			  </form>
			  </div>
</body>
</html>