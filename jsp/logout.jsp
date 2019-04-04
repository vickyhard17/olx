 
<%

String email=(String)session.getAttribute("email");
String password=(String)session.getAttribute("password");
if(email!=null && password!=null)
{
session.setAttribute("email", null);
session.setAttribute("password", null);
session.invalidate();
response.sendRedirect(request.getContextPath()+"/index.jsp");
}

 else
{
	session.setAttribute("email", null);
	session.setAttribute("password", null);
	session.invalidate();
	session=null;
	response.sendRedirect(request.getContextPath()+"/index.jsp");
}
%>