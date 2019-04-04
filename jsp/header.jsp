<div class="wrapper">
	 <input type="hidden" name="action" id="headpath" value="<%=request.getContextPath()%>">
	<div class="headermain">
		<div class="imgdiv">
			<a href="<%=request.getContextPath() %>/index.jsp">
			<img alt="no image found" src="<%=request.getContextPath() %>/images/olx.png">
			</a>
		</div>
		<div class="searchdiv">
			<input type="text" placeholder="Find Cars,Mobile Phones and more.."  id="searchbar" onkeyup="obj.searchCategory();">
		</div>
		<div class="searchimg"><img alt="no image found" src="<%=request.getContextPath()%>/images/search.png"></div>
			<%
			Long id=(Long)session.getAttribute("pkid");
			System.out.print(session.getAttribute("isadmin"));	
			String email1=(String)session.getAttribute("email1");
			String email=(String)session.getAttribute("email");
			Character isadmin=(Character)session.getAttribute("isadmin");
			//Character isadmin = null;
			Long userid=null;
		//	session=request.getSession(false);
			if(id != null && isadmin!=null && (email1!=null || email!=null))
			{
				String admin=isadmin.toString();
			if(admin.equals("N"))
			{
			String password=(String)session.getAttribute("password");
			String name=(String)session.getAttribute("firstname");
			Long contact=(Long)session.getAttribute("contact");
			Long uid=(Long)session.getAttribute("pkid");
			 userid=id;
			%>
		<div class="dropclass" >
		<button class="dropbtn">HI,<%=name%></button>
  					<div class="dropdown-content">
    						<a href="<%=request.getContextPath()%>/jsp/profile.jsp">My Profile</a>
    						<a    href="<%=request.getContextPath()%>/jsp/productdetail.jsp">My Ads</a>
   							 <a href="<%=request.getContextPath()%>/jsp/logout.jsp">Logout</a>
 				 	</div></div>
 					<div class="sellimg"><a href="#"  id="<%=(Long)session.getAttribute("pkid")%>" onclick="obj.sellerlogin(this.id);"><input type="hidden"  id="sellerpath" name="action" value="<%=request.getContextPath()%>"><img alt="no image found" src="<%=request.getContextPath()%>/images/sellicon.png"></a></div>
 					<div class="cleargrid"></div>
		<%} else
		{
			String password=(String)session.getAttribute("password");
			String name=(String)session.getAttribute("firstname");
			Long contact=(Long)session.getAttribute("contact");
			Long pkadid=(Long)session.getAttribute("adid");
			Long uid=(Long)session.getAttribute("pkid");
			 userid=id;
		
		%>
			<div class="dropclass" >
		<button class="dropbtn">HI,<%=name%></button>
  					<div class="dropdown-content">
    						<a href="<%=request.getContextPath()%>/jsp/profile.jsp">My Profile</a>
    						<a    href="<%=request.getContextPath()%>/jsp/verify.jsp">All Active Ads</a>
    						<a    href="<%=request.getContextPath()%>/jsp/unverified.jsp">All UnVerified Ads</a>
   							 <a href="<%=request.getContextPath()%>/jsp/logout.jsp">Logout</a>
 				 	</div></div>
 					<div class="sellimg"><a href="#"  id="<%=(Long)session.getAttribute("pkid")%>" onclick="obj.sellerlogin(this.id);"><input type="hidden"  id="sellerpath" name="action" value="<%=request.getContextPath()%>"><img alt="no image found" src="<%=request.getContextPath()%>/images/sellicon.png"></a></div>
 					<div class="cleargrid"></div>
		<% }}
		else{%>
					<div class="anchordiv" ><a href="#" onclick="obj.showloginpopup();">LOGIN</a></div>
		<div class="sellimg"><a href="#"  id="<%=userid%>" onclick="obj.sellerlogin(this.id);"><input type="hidden"  id="sellerpath" name="action"  value="<%=request.getContextPath()%>"><img alt="no image found" src="<%=request.getContextPath()%>/images/sellicon.png"></a></div>
 					<div class="cleargrid"></div>
			<%}%>
			
	   			<input type="hidden"  name="action" id="loginpath" value="<%=request.getContextPath()%>">
			  <input type="hidden" id="path" name="signupaction" value="<%=request.getContextPath() %>">
			   <input type="hidden" id="conpath" name="signupaction" value="<%=request.getContextPath() %>">
			   <input type="hidden" name="action" id="mainpath" value="<%=request.getContextPath()%>">
</div></div>
<div onclick="obj.hide();" class="midlayer" id="mlayer"></div>
<div class="signupSection" id="signupSection1">
<!--form start here-->
		  <form  action="<%=request.getContextPath() %>/CommonController" id="signupForm" name="signupform" method="post">
		  <a href="#" class="js-close-modal" onclick="obj.hide();">X</a>
			<h2>Signup</h2><br>
			<hr><br>
			<ul class="noBullet">
			  <b>FIrst Name:<i>*</i></b><li>
				<label for="First name"></label>
				<input type="text" class="inputFields" id="firstname" name="firstname" placeholder="Firstname" maxlength="15"/><span id="fnameerror"></span>
			  </li>
			  <b>Choose Password:<i>*</i>(start with max 1 upper,min 4 lower,max 1 special @_. min 2 number)</b><li>
				<label for="Choose password"></label>
				<input type="password" class="inputFields" id="password" name="password" placeholder="Choose Password" maxlength="15" /><span id="passworderror"></span>
			  </li>
			  <b>Confirm Password:<i>*</i></b><li>
				<label for="Confirm password"></label>
				<input type="password" class="inputFields" id="confirmpass" name="confirmpass" placeholder="Confirm password" maxlength="15"/><span id="confirmerror"></span>
			  </li>
			<!--   <b>Address:<i>*</i></b><li>
				<label for="Address"></label>
				<input type="text" class="inputFields" id="address" name="address" placeholder="write your address here" maxlength="250"/><span id="addresserror"></span>
			  </li> -->
			   <b>Email:<i>*</i></b><li>
				<label for="Email"></label>
				<input type="text" class="inputFields" id="email" name="email" placeholder="Email"  onblur="obj.checkEmail();"/>
				<span id="emailerror"></span>
			  </li>
			  <b>Address:<i>*</i></b><li>
				<label for="Address"></label>
				<input type="text" class="inputFields" id="address" name="address" placeholder="write your address here" maxlength="250"/><span id="addresserror"></span>
			  </li>
			   <b>Contact:<i>*</i></b><li>
				<label for="Contact"></label>
				<input type="text" class="inputFields" id="contact" name="contact" placeholder="Contact" maxlength="10" onblur="obj.checkMobile();"/>
				<span id="contacterror"></span>
			  </li>
			  <li>
				<input type="submit" id="leftbtn" name="leftbtn" alt="leftbtn" value="Submit">
				<input type="reset" id="rightbtn" name="rightbtn" alt="rightbtn" value="Cancel">
	   			<input type="hidden"  name="signupaction" value="signup">
	   			<input type="hidden"  name="signupaction" value="admin">
				</li><br>
				 <li>
				<div class="anchor" onclick="obj.showloginpopup();">already have an account Click here to <span  class="loglink">Login</span></div>
				</li>
			</ul>
		  </form>
<!--form end here-->
</div>
<div id="loginsection">
	<form  id="logininfo" name="signupform"  method="post" action="<%=request.getContextPath() %>/CommonController"><!-- action="CommonController" --> 
	<a href="#" class="js-close-modal" onclick="obj.hide();">X</a> 	
		<h2>Login</h2><br>
			<hr><br>
	   			<input type="hidden"  name="signupaction" value="login">
			<ul class="noBullet">
			  <b>User name:<i>*</i></b><li>
				<label for="First name"></label>
				<input type="text" class="inputFields" id="firstname_log" name="email" placeholder="Firstname" /><span id="fnameerror_log"></span>
			  </li>
			   <b>Password:<i>*</i></b><li>
				<label for="Choose password"></label>
				<input type="password" class="inputFields" id="password_log" name="password" placeholder="Choose Password" maxlength="15" /><span id="passworderror_log"></span>
			  </li>
			 <!--   <li><input type="hidden"  name="signupaction" value="login"></li> -->
			  <%--    <li><input type="hidden"  name="action" id="loginpath" value="<%=request.getContextPath()%>"></li> --%>
			  <li>
			  <input type="button" id="loginbtn"  value="Submit"  onclick="obj.userLogin();"><!-- onclick="obj.userLogin();" -->
			  </li>
			  <br>
			  <li>
			  <div class="anchor" onclick="obj.showpopup();">New user click here for <span class="loglink">Sign up</span></div>
			  </li> 
			  </ul>
	</form>
</div>
<div id="loginsection1">
	<form   name="signupform"  method="post" action="<%=request.getContextPath() %>/CommonController"><!-- action="CommonController" --> 
	<a href="#" class="js-close-modal" onclick="obj.hide();">X</a> 	
		<h2>Login</h2><br>
			<hr><br>
			<ul class="noBullet">
			  <b>User name:<i>*</i></b><li>
				<label for="First name"></label>
				<input type="text" class="inputFields" id="firstname_log1" name="email" placeholder="Firstname" /><span id="fnameerror_log1"></span>
			  </li>
			   <b>Password:<i>*</i></b><li>
				<label for="Choose password"></label>
				<input type="password" class="inputFields" id="password_log1" name="password" placeholder="Choose Password" maxlength="15" /><span id="passworderror_log1"></span>
			  </li>
			  <li><input type="hidden"  name="loginaction" value="login1"></li>
			 <!--   <li><input type="hidden"  name="signupaction" value="login"></li> -->
			  <%--    <li><input type="hidden"  name="action" id="loginpath" value="<%=request.getContextPath()%>"></li> --%>
			  <li>
			  <input type="submit" id="loginbtn1"  value="Submit"  ><!-- onclick="obj.userLogin();" -->
			  </li>
			  <br>
			  <li>
			  <div class="anchor" onclick="obj.showpopup();">New user click here for <span class="loglink">Sign up</span></div>
			  </li> 
			  </ul>
	</form>
</div>
<div id="loginsection2">
	<form   name="signupform"  method="post" action="<%=request.getContextPath() %>/CommonController"><!-- action="CommonController" --> 
	<a href="#" class="js-close-modal" onclick="obj.hide();">X</a> 	
		<h2>Login</h2><br>
			<hr><br>
			<ul class="noBullet">
			  <b>User name:<i>*</i></b><li>
				<label for="First name"></label>
				<input type="text" class="inputFields" id="firstname_log2" name="email" placeholder="Firstname"  /><span id="fnameerror_log2"></span>
			  </li>
			   <b>Password:<i>*</i></b><li>
				<label for="Choose password"></label>
				<input type="password" class="inputFields" id="password_log2" name="password" placeholder="Choose Password" maxlength="15" /><span id="passworderror_log2"></span>
			  </li>
			  <li><input type="hidden"  name="loginaction" value="login2"></li>
			 <li>
			  <input type="Submit" id="loginbtn2"  value="Submit"  ><!-- onclick="obj.userLogin();" -->
			  </li>
			  <br>
			  <li>
			  <div class="anchor" onclick="obj.showpopup();">New user click here for <span class="loglink">Sign up</span></div>
			  </li> 
			  </ul>
	</form>
</div>
<div id="overlay" onclick="obj.hide();"></div>
<div id="autosearch">

</div>


