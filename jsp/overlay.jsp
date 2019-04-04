<div onclick="obj.hide();" class="midlayer" id="mlayer"></div>
<div class="signupSection" id="signupSection1">
<!--form start here-->
		  <form action="<%=request.getContextPath() %>/CommonController" id="signupForm" name="signupform" method="post">
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
			  <li><input type="hidden"  name="signupaction" value="signup"></li>
			  <li><input type="hidden" id="path" name="signupaction" value="<%=request.getContextPath() %>"></li>
			   <li><input type="hidden" id="conpath" name="signupaction" value="<%=request.getContextPath() %>"></li>
			   <li><input type="hidden" name="action" id="mainpath" value="<%=request.getContextPath()%>"></li>
			  <li>
				<input type="submit" id="leftbtn" name="leftbtn" alt="leftbtn" value="Submit">
				<input type="reset" id="rightbtn" name="rightbtn" alt="rightbtn" value="Cancel">
				</li><br>
				 <li>
				<div class="anchor" onclick="obj.showloginpopup();">already have an account Click here to <span  class="loglink">Login</span></div>
				</li>
			</ul>
		  </form>
<!--form end here-->
</div>
<div id="loginsection">
	<form  id="logininfo" name="signupform" action="CommonController" method="post">
	<a href="#" class="js-close-modal" onclick="obj.hide();">X</a> 	
		<h2>Login</h2><br>
			<hr><br>
			<ul class="noBullet">
			  <b>User name:<i>*</i></b><li>
				<label for="First name"></label>
				<input type="text" class="inputFields" id="firstname_log" name="email" placeholder="Firstname" /><span id="fnameerror_log"></span>
			  </li>
			   <b>Password:<i>*</i></b><li>
				<label for="Choose password"></label>
				<input type="password" class="inputFields" id="password_log" name="password" placeholder="Choose Password" maxlength="15" /><span id="passworderror_log"></span>
			  </li>
			   <li><input type="hidden"  name="signupaction" value="login"></li>
			  <li>
			  <input type="submit" id="loginbtn"  value="Submit">
			  </li>
			  <br>
			  <li>
			  <div class="anchor" onclick="obj.showpopup();">New user click here for <span class="loglink">Sign up</span></div>
			  </li> 
			  </ul>
	</form>
</div>