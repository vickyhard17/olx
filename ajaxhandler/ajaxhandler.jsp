
<%@page import="com.olx.controller.CommonAjaxController"%>
<%@page import="com.olx.controller.CommonController"%>
<%!
public String ajaxhandler(HttpServletRequest request,HttpServletResponse response)
{
	HttpSession session=request.getSession();
	String action=request.getParameter("action");
	String email=(String)session.getAttribute("email");
	String password=(String)session.getAttribute("password");
	String string="";
		if(action!=null && !"".equals(action))
			{
				if("checkShowCategory".equals(action))
				{
					try
					{
						string=new CommonAjaxController().checkShowCategory(request, response);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else if("checkLogin".equals(action))
				{
					try
					{
						string=new CommonAjaxController().checkLogin(request, response);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else if("checkEmail".equals(action))
					{
						try
						{
							string=new CommonAjaxController().checkEmail(request, response);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					else if("checkMobile".equals(action))
					{
						try
						{
							string=new CommonAjaxController().checkMobile(request, response);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					} 
					else if("checkSellerId".equals(action))
					{
						try
						{
							string=new CommonAjaxController().checkSellerId(request, response);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					else if("checkState".equals(action))
					{
						try
						{
							string=new CommonAjaxController().checkState(request, response);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					else if("checkCity".equals(action))
					{
						try
						{
							string=new CommonAjaxController().checkCity(request, response);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					else if("checkArea".equals(action))
					{
						try
						{
							string=new CommonAjaxController().checkArea(request, response);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
						else if("checkSubcatog".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkSubcatog(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else if("checkSearchCategory".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkSearchCategory(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else if("checkProduct".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkProduct(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else if("checkAllProduct".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkAllProduct(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else if("checkProducts".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkProducts(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
					/* 	else if("checkUnverify".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkUnverify(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						} */
					/* 	else if("checkVerify".equals(action))
						{
							try
							{
								string=new CommonAjaxController().checkVerify(request, response);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						} */
				
				}
		return string;
	}
%>
<%=ajaxhandler(request,response) %>