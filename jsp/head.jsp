<div class="wrapper">
	 <input type="hidden" name="action" id="headpath" value="<%=request.getContextPath()%>">
	<div class="headermain">
		<div class="imgdiv">
		<a href="<%=request.getContextPath() %>/index.jsp">
			<img alt="no image found" src="<%=request.getContextPath() %>/images/olx.png">
			</a>
		</div>
		<div class="searchdiv">
			<input type="text" placeholder="Find Cars,Mobile Phones and more.."  id="searchbar" name="search-bar" onkeypress="obj.searchCategory();">
		</div>
		<div class="searchimg"><img alt="no image found" src="<%=request.getContextPath()%>/images/search.png"></div>
		<div class="anchordiv" ><a   href="#" onclick="obj.showloginpopup();">LOGIN</a></div>
			<%
				String email=(String)session.getAttribute("email");
		%>
		<div class="sellimg"><a  id="<%=email%>" onclick="obj.sellerlogin(this.id);" href="#"><img alt="no image found" src="<%=request.getContextPath()%>/images/sellicon.png"></a><input type="hidden"  id="sellerpath" name="action" value="<%=request.getContextPath()%>"></div>
		<div class="cleargrid"></div>
	</div>
</div>

	
