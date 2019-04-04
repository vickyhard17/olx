var obj=new Olx();
/*object function start here*/
function Olx()
{	this.isEmpty=isEmpty;
	this.restrictAlphabets=restrictAlphabets;
	this.restrictNumbers=restrictNumbers;
	this.nameRegex=nameRegex;
	this.firstNameValidate=firstNameValidate;
	this.passwordValidate=passwordValidate;
	this.confirmPassword=confirmPassword;
	this.emailValidate=emailValidate;
	this.checkEmail=checkEmail;
	this.contactValidate=contactValidate;
	this.checkMobile=checkMobile;
	this.resetData=resetData;
	this.displayResult=displayResult;
	this.showResult=showResult;
	this.loginResult=loginResult;
	this.firstNameValidatelog=firstNameValidatelog;
	this.passwordValidatelog=passwordValidatelog;
	this.addressValidate=addressValidate;
	this.showImage=showImage;
	this.nameUpdate=nameUpdate;
	this.hide=hide;
	this.showForm=showForm;
	this.showloginpopup1=showloginpopup1;
	this.showloginpopup2=showloginpopup2;
	this.category=category;
	this.showCategory=showCategory;
	this.subCategory=subCategory;
	this.searchBar=searchBar;
	this.sellerlogin=sellerlogin;
	this.showstate=showstate;
	this.addState=addState;
	this.showArea=showArea;
	this.cityValidate=cityValidate;
	this.stateValidate=stateValidate;
	this.showCity=showCity;
	this.addCity=addCity;
	this.addArea=addArea;
	this.subCatog=subCatog;
	this.addCategory=addCategory;
	this.addSubCategory=addSubCategory;
	this.searchCategory=searchCategory;
	this.showProduct=showProduct;
	this.showAllProduct=showAllProduct;
	this.showNumber=showNumber;
	this.userLogin=userLogin;
	this.unverify=unverify;
	this.verify=verify;
	this.clear=clear;
	this.showManyInOne=showManyInOne;
	var flag;
	var flag1;

	/*empty,null,undefined checking start here*/
	function isEmpty(val)
	{	if(val!="" && val!=undefined && val!=null)
		{	return true;
		}
		else
		{	return false;
		}
	}
	/*empty,null,undefined checking end here*/
	/*alphabet restricted start here*/
	function restrictAlphabets(e)
	{
		var x=e.which||e.keycode;
		if((x>=48 && x<=57) || x==8 ||
			(x>=35 && x<=40) || x==47)
			return true;
		else
			return false;
	}
	/*alphabet restricted end here*/
	/*number restricted start here*/
	function restrictNumbers(e)
	{
		var x=e.which||e.keycode;
		if((x>=48 && x<=57) || x==8 ||
			(x>=35 && x<=40)|| x==46)
			return false;
		else
			return true;
	}
	/*number restricted end here*/
	/*regex validation for name start here*/
	function nameRegex(x)
	{
			var regname=/^[a-zA-Z]{2,12}$/;
			var result=regname.test(x);
			return result;
	}
	/*regex validation for name end here*/
	/*first name validation start here*/
	function firstNameValidate()
	{
		var name=$("#firstname").val();
		var resname=isEmpty(name);
		if(!resname)
		{
			$("#fnameerror").text("first name cannot be empty");
			$("#fnameerror").css("color","red");
			return false;
		}
		else if(nameRegex(name))
		{
			$("#fnameerror").text("");
			return true;
		}
		else
		{
			$("#fnameerror").text("min 3-11 character allowed");
			$("#fnameerror").css("color","red");
			return false;
		}	
	
	}
	/*first name validation end here*/
	/*password validation start here*/
	function passwordValidate()
	{
		var passwrd=$("#password").val();
		var passpattern=/^[A-Z]{1}[a-z]{4,}[./@_]{1}[0-9]{2,}$/;
		var resname=isEmpty(passwrd);
		if(!resname)
		{
			$("#passworderror").text("password cannot be empty");
			$("#passworderror").css("color","red");
			return false;
		}
		else if(passpattern.test(passwrd))
		{
			$("#passworderror").text("");
			return true;
		}
		else
		{
			$("#passworderror").text("invalid password");
			$("#passworderror").css("color","red");
			return false;
		}
	
	}
	/*password validation end here*/
	/*confirmpassword validation start here*/
	function confirmPassword()
	{
		var conpasswrd=$("#confirmpass").val();
		var passwrd=$("#password").val();
		var resname=isEmpty(conpasswrd);
		if(!resname)
		{
			$("#confirmerror").text("password cannot be empty");
			$("#confirmerror").css("color","red");
			return false;
		}
		else if(conpasswrd==passwrd)
		{
			$("#confirmerror").text("password match Successfully!!!!");
			$("#confirmerror").css("color","green");
			return true;
		}
		else
		{
			$("#confirmerror").text("password not matched");
			$("#confirmerror").css("color","red");
			return false;
		}
	}
	/*confirmpassword validation end here*/
	
	/*email validation start here*/
	function emailValidate()
	{
		var email=$("#email").val();
		var emailpattern= /^([^.])([a-z0-9]+[\.]{0,1})*[\_]{0,1}[a-zA-Z0-9]+@[a-z0-9]{4,}\.([com]{3}|[gov]{3}\.[in]{2}|[co]{2}\.[in]{2})/;
		var resname=isEmpty(email);
		
		if(!resname)
		{
			$("#emailerror").text("email cannot be empty");
			$("#emailerror").css("color","red");
			return false;
		}
		else if(emailpattern.test(email))
		{
			$("#emailerror").text("");
			return true;
		}
		else
		{
			$("#emailerror").text("invalid email id");
			$("#emailerror").css("color","red");
			return false;
		}
	}
	/*email validation end here*/
	/*check email ajax start here*/
	function checkEmail()
	{
		if(emailValidate())
		{
			var path=$("#path").val();
			var email=$("#email").val();
			$.post(path+"/ajaxhandler/ajaxhandler.jsp",
			{
				action:"checkEmail",
				email:email
			},function(data)
			{
				var parsedata = $.parseJSON(data);
				if(parsedata.isFlag)
				{
					$("#emailerror").text(parsedata.message);
					$("#emailerror").css("color","red");
					flag=false;
				}
				else
				{
					flag=true;
				}
				return flag;;
			});
		}
		else
		{
			return false;
		}
	}
	/*check email ajax end here*/
	/*address validation start here*/
	function addressValidate()
	{
		var address=$("#address").val();
		var resname=isEmpty(address);
		if(!resname)
		{
			$("#addresserror").text("address cannot be empty");
			$("#addresserror").css("color","red");
			return false;
		}
		else
		{
			$("#addresserror").text("");
			return true;
		}
	}
	/*address validation end here*/
	/*contact validation start here*/
	function contactValidate()
	{
		var contact=$("#contact").val();
		var contactpattern=/^[789]{1}[0-9]{9}$/;
		var resname=isEmpty(contact);
		if(!resname)
		{
			$("#contacterror").text("contact cannot be empty");
			$("#contacterror").css("color","red");
			return false;
		}
		else if(contactpattern.test(contact))
		{
			$("#contacterror").text("");
			return true;
		}
		else
		{
			$("#contacterror").text("invalid contact");
			$("#contacterror").css("color","red");
			return false;
		}
		
	}
	/*contact validation end here*/
	function checkMobile()
	{
		if(contactValidate())
		{
			var path=$("#conpath").val();
			var contact=$("#contact").val();
			$.post(path+"/ajaxhandler/ajaxhandler.jsp",
			{
				action:"checkMobile",
				contact:contact
			},function(data)
			{
				var parsedata = $.parseJSON(data);
				if(parsedata.isFlag)
					{
						$("#contacterror").text(parsedata.message);
						$("#contacterror").css("color","red");
						flag1=false;
					}
				else
					{
					flag1=true;
					}
				return flag1;
			});
		
		}
		else
		{
			return false;
		}
	}

	/*reset logic start here*/
	function resetData()
	{
		$("#fnameerror").text("");
		$("#contacterror").text("");
		$("#emailerror").text("");
		$("#confirmerror").text("");
		$("#passworderror").text("");
		$("#addresserror").text("");
		$("#displaygender").text("");
	}

	/*reset logic start here*/

	/*display result start here*/
	function displayResult()
	{
		if(firstNameValidate() && passwordValidate() &&
				emailValidate() && addressValidate() && contactValidate() && flag && flag1)
		{
			setTimeout(function()
			{
			//$("#signupSection1").hide();
			$("#output").hide();
			$("#signupSection1").css('display','none');
			$("#mlayer").css('display','none');
			},5000);
			return true;
			
		}
		else
		{
			return false;
		}
	}

	function firstNameValidatelog()
	{
		var email=$("#firstname_log").val();
		var emailpattern= /^([^.])([a-z0-9]+[\.]{0,1})*[\_]{0,1}[a-zA-Z0-9]+@[a-z0-9]{4,}\.([com]{3}|[gov]{3}\.[in]{2}|[co]{2}\.[in]{2})/;
		var resname=isEmpty(email);
		if(!resname)
		{
			$("#fnameerror_log").text("email cannot be empty");
			$("#fnameerror_log").css("color","red");
			return false;
		}
		else if(emailpattern.test(email))
		{
			$("#fnameerror_log").text("");
			return true;
		}
		else
		{
			$("#fnameerror_log").text("invalid email id");
			$("#fnameerror_log").css("color","red");
			return false;
		}
		
	
	}
	
	function passwordValidatelog()
	{
		var passwrd=$("#password_log").val();
		var passpattern=/^[A-Z]{1}[a-z]{4,}[./@_]{1}[0-9]{2,}$/;
		var resname=isEmpty(passwrd);
		if(!resname)
		{
			$("#passworderror_log").text("password cannot be empty");
			$("#passworderror_log").css("color","red");
			return false;
		}
		else if(passpattern.test(passwrd))
		{
			$("#passworderror_log").text("");
			return true;
		}
		else
		{
			$("#passworderror_log").text("invalid password");
			$("#passworderror_log").css("color","red");
			return false;
		}
	}

	/*Gender validation start here*/
	function isMobileShow()
	{
		var gender = $("input[name='gender']:checked").val();
		if(gender!="" && gender!=undefined)
		{
			$("#displaygender").text("");
			return true;
		}
		else
		{
			$("#displaygender").text("**Required !");
			$("#displaygender").css("color","red");
			return false;
		}
	}
	/*Gender validation end here*/
	function hide()
	{
		$(".blur").css('display','none');
		$(".winpopup1").css('display','none');	
	}
	function loginResult()
	{
		if(firstNameValidatelog() && passwordValidatelog())
		{
			$("#fnameerror_log").text("");
			$("#passworderror_log").text("");
			setTimeout(function()
			{
			//$("#loginsection").hide();
			$("#loginop").hide();
			$("#loginsection").css('display','none');
			$("#mlayer").css('display','none');
			},5000);
			return true;
		}
		else
		{
		
		return false;
		}
	}
	function showImage()
	{
		var path=$("#path1").val();
		var path3=$("#path3").val();
		var prodpath="";
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkData",
			
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			var div="";
			prodpath+=path3+"/images/";
			for(var i=0;i<parsedata.length;i++)
			{
				div+="<div class='gridBox'><img src="+ prodpath+parsedata[i][4]+" alt='Title' title='Title' width='240' height='185' class='prodImg' id="+parsedata[i][0]+" onclick='obj.showProductDetails(this.id);'> <div class='prodInfo'><p class='prodPrice'><b  id='prodname'>"+parsedata[i][1]+" </b></p><p class='prodDesc' id='prodtype'>"+parsedata[i][2]+"</p><p class='prodDescOffer' id='weight'>"+parsedata[i][3]+"</p></div></div>";
			}
				$("#maingrid").append(div);
		});
	}
	function sellerlogin(id)
	{
		var path=$("#sellerpath").val();
		var emailid=id;
			if(emailid == "null")
			{
				obj.showloginpopup();
			}
			else
			{
				window.location=path+"/jsp/adpost.jsp?name="+emailid;
			}
	}
	function showNumber(id)
	{
		var path=$("#sellerpath").val();
		var emailid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkSellerId",
			emailid:emailid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			if(parsedata==0 || parsedata==null)
			{
				obj.showloginpopup();
			}
			else
			{
				window.location=path+"/jsp/categorydetails.jsp?name="+encodeURIComponent(parsedata);
			}
	});
	}
	var logres;
	function userLogin()
	{
		var flagStatus=true;
		var path=$("#loginpath").val();
		var eid=$("#firstname_log").val();
		var pid=$("#password_log").val();
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkLogin",
			eid:eid,
			pid:pid
		},
		function(data)
		{
			var parsedata = $.parseJSON(data);
			flagStatus=false;
		});
		return flagStatus;
	}
	
	/*display result end here*/
	/*Final display result start here*/
	function showResult()
	{
		$("#firstname").blur(firstNameValidate);
		$("#firstname").keypress(restrictNumbers);
		$("#password").blur(passwordValidate);
		$("#confirmpass").blur(confirmPassword);
		$("#email").blur(emailValidate);
		$("#contact").blur(contactValidate);
		$("#contact").keypress(restrictAlphabets);
		$("#signupForm").submit(displayResult);
		$("#rightbtn").click(resetData);
		$("#loginbtn").click(loginResult);
		$("#address").blur(addressValidate);
	}	
	function category()
	{
		var path=$("#categorypath").val();
		//var cid=id1;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkCategory",
		//	cid:cid
		},function(data)
		{
			var html="";
		var parsedata = $.parseJSON(data);
		$(".categ").text("");
		html="<div class='categ'><ul class='catoglist'>";
		$.each(parsedata,function(key,value){
			html+="<li id="+key+" onmouseover='obj.subCategory(this.id)'>"+value+"</li>";
		})
		html+="</ul></div>"
		$("#categ").append(html);
		$('.categ').css("style","block");
		});
	}
	function showstate()
	{
	var path=$("#conpath").val();
	$.post(path+"/ajaxhandler/ajaxhandler.jsp",
	{
		action:"checkState",
	},function(data)
	{
		var parsedata = $.parseJSON(data);
		$("#state2").html("");
		var html="";
		html+="<option value='' >Select State</option>";
	for(var i=0;i<parsedata.length;i++)
	{
		html+="	<option value="+parsedata[i].pkId+"  onclick='obj.showCity(this.value)'  >"+parsedata[i].statename+"</option>";
		}
		$("#state2").append(html);
	});
}
	function addState()
	{
		var path=$("#conpath").val();
		var id=$("#stateid").val();
		window.location=path+"/jsp/admin.jsp?name="+id;
	}
	function addCity()
	{
		var path=$("#conpath").val();
		var cid=$("#cityid").val();
		var sid=$("#state").val();
		window.location=path+"/jsp/admin.jsp?cid="+cid+"&sid="+sid;
	}
	function addArea()
	{
		var path=$("#conpath").val();
		var arid=$("#areaid").val();
		var stid=$("#state1").val();
		var citid=$("#city").val();
		window.location=path+"/jsp/admin.jsp?arid="+arid+"&stid="+stid+"&citid="+citid;
	}
	function addCategory()
	{
		var path=$("#conpath").val();
		var catog=$("#cat").val();
		window.location=path+"/jsp/admin.jsp?catog="+catog;
	}
	function addSubCategory()
	{
		var path=$("#conpath").val();
		var catid=$("#Maincategory").val();
		var subcatid=$("#subcat").val();
		window.location=path+"/jsp/admin.jsp?catid="+catid+"&subcatid="+subcatid;
	}
	function nameUpdate()
	{
		var path=$("#conpath").val();
		var name=$("#updatename").val();
		var email=$("#eid").val();
		var mob=$("#updatemob").val();
		var pass=$("#newone").val();
		window.location=path+"/jsp/profile.jsp?name="+name+"&email="+email+"&mob="+mob+"&pass="+pass;
	}
	function showCity(id)
	{
		var path=$("#conpath").val();
		var sid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkCity",
			sid:sid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			$("#city").html("");
			var html="";
			html+="<option value='' >Select City</option>";
			for(var i=0;i<parsedata.length;i++)
			{
				html+="	<option value="+parsedata[i][0]+"  >"+parsedata[i][1]+"</option>";
			}
			$("#city").append(html);
		});
	}
	function showArea(id)
	{
		var path=$("#conpath").val();
		var aid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkArea",
			aid:aid
		},function(data)
		{
			var count=0;
			var parsedata = $.parseJSON(data);
			$("#area").html("");
			var html="";
			html+="<option value='' >Select Area</option>";
			for(var i=0;i<parsedata.length;i++)
			{
				html+="	<option value="+parsedata[i][0]+"  >"+parsedata[i][1]+"</option>";
			}
			$("#area").append(html);
		});
	}
	function subCatog(id)
	{
		var path=$("#conpath").val();
		var subid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkSubcatog",
			subid:subid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			$("#Subcateg").html("");
			var html="";
			html+="<option value='' >Select Subcategory</option>";
			for(var i=0;i<parsedata.length;i++)
			{
				html+="	<option value="+parsedata[i].pkId+"  >"+parsedata[i].statename+"</option>";
			}
			$("#Subcateg").append(html);
		});
	}
	
	function subCategory(id)
	{
		var path=$("#categorypath").val();
		var cid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkSubCategory",
			cid:cid
		},function(data)
		{
			var html="";
		var parsedata = $.parseJSON(data);
		$(".subcateg").text("");
		html="<div class='subcateg'><ul class='subcatoglist'>";
		$.each(parsedata,function(key,value){
		html+="<li onclick='obj.showProductDetails(this.id);' id="+key+">"+value+"</li>";	
		})
		html+="</ul></div>"
		$("#categ").append(html);
		});
	}
	function showCategory()
	{
		var path=$("#headpath").val();
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkShowCategory",
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			html="";
			var id=0;
			for(var i=0;i<parsedata.length;i++)
			{
				
				if(parsedata[i].isparent=='Y' && !(id == parsedata[i].catogId))
				{
					if(!(id==parsedata[i].catogId) && id !=0)
					{
						html+="</ul></div>";
					}
					html+="<div class='subcateg'><ul class='subcatoglist'>";
					html+="<li id='"+parsedata[i].catogId+"' class='maincateg'  onclick='obj.showProduct(this.id)'><a href='#'>"+parsedata[i].catogName+"</a></li>";
					html+="<li id='"+parsedata[i].subcatogId+"' onclick='obj.showProduct(this.id)''><a href='#'>"+parsedata[i].subcatogName+"</a></li>";
					id= parsedata[i].catogId;
				}
				else
				{
					
					html+="<li id='"+parsedata[i].subcatogId+"' onclick='obj.showProduct(this.id)'''><a href='#'>"+parsedata[i].subcatogName+"</a></li>";
					id= parsedata[i].catogId;
					
				}
			}
			html+="<div class='cleargrid'></div>"
			$(".categories").append(html);
		});
		
	}
	function showProduct(id)
	{
		var path=$("#headpath").val();
		var pid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkProduct",
			pid:pid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			window.location=path+"/jsp/product.jsp";
		});
	}
	
	function showManyInOne()
	{
		var path=$("#headpath").val();
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkProducts",
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			var html="";
			for(var i=0;i<parsedata.length;i++)
		{
			html+="<div class='proddisplay' id='"+parsedata[i].adid+"' onclick='obj.showAllProduct(this.id);'><div class='image'><img src='"+path+"/images/"+parsedata[i].imagename+"'></div>"+
			"<div class='title'>"+parsedata[i].title+"</div>"+
			"<div class='description'>"+parsedata[i].description+"</div>"+
			"<div class='price'><img src='"+path+"/images/rupeesymbol.png'>"+parsedata[i].price+"</div>"+
			"<div class='subcatogary'>"+parsedata[i].subcategory+"</div>"+
			"<div class='area'>"+
			"<span>"+parsedata[i].area+"</span>"+
			"<span>"+parsedata[i].city+"</span>"+
			"<span>"+parsedata[i].state+"</span>"+
			"</div></div>";
		}
			html+="<div class='cleargrid'></div>";
			$(".proddiv").append(html);
		});
	}
	function showAllProduct(id)
	{
		var path=$("#conpath").val();
		var pid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkAllProduct",
			pid:pid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			window.location=path+"/jsp/categorydetails.jsp";
		});
	}
	function unverify(id)
	{
		var path=$("#conpath").val();
		var uid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkUnverify",
			uid:uid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			window.location=path+"/jsp/verify.jsp";
		});
	}
	function verify(id)
	{
		var path=$("#conpath").val();
		var vid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkVerify",
			vid:vid
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			window.location=path+"/jsp/unverified.jsp";
		});
	}
	function clear(id)
	{
		var name=$("#"+id).val();
		$("#searchbar").val(name);
		$("#autosearch").html("");
		$("#autosearch").css('display','none');
	}
	function searchCategory()
	{
		var path=$("#headpath").val();
		var id=$("#searchbar").val();
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkSearchCategory",
			id:id
		},function(data)
		{
			var parsedata = $.parseJSON(data);
			$("#autosearch").html("");
			$("#autosearch").css('display','block');
			$("#overlay").css('display','block');
			var html="";
			html+="<ul>";
			for(var i=0;i<parsedata.length;i++)
			{
				html+="<li id='"+parsedata[i].id+"'  onclick='obj.showProduct(this.id);obj.clear(this.id);'><a href='#'>"+parsedata[i].name+"</a></li>";
			}
			html+="</ul>";
			$("#autosearch").append(html);
		});
	}
	
	function searchBar()
	{
		var path=$("#categorypath").val();
		//var cid=id;
		$.post(path+"/ajaxhandler/ajaxhandler.jsp",
		{
			action:"checkSearch",
		},function(data)
		{
		var parsedata = $.parseJSON(data);
		$("#productname").autocomplete({
			source:parsedata
		});
		});
	}
	function cityValidate()
	{
		var selectcity=$("#city option:selected").val();
		if(selectcity!="")
		{
		$("#displaycity").text("");
		return true;
		}
		else
		{
		$("#displaycity").text("**Required !");
		$("#displaycity").css("color","red");
		return false;
		}
	}
	function stateValidate()
	{
		var selectstate=$("#state option:selected").val();
		if(selectstate!="")
		{
		$("#displaystate").text("");
		return true;
		}
		else
		{
		$("#displaystate").text("**Required !");
		$("#displaystate").css("color","red");
		return false;
		}
	}
	this.showpopup = showpopup;
	function showpopup()
	{
		document.getElementById("loginsection").style.display='none';
		document.getElementById("loginsection1").style.display='none';
		document.getElementById("mlayer").style.display='block';
		document.getElementById("signupSection1").style.display = 'block';
		document.getElementById("loginsection2").style.display = 'none';
		document.getElementById("autosearch").style.display = 'none';
		$("#email").val("");
		$("#firstname").val("");
		$("#contact").val("");
		$("#password").val("");
		$("#confirmpass").val("");
		$("#confirmerror").text("");
		$("#address").val("");
		obj.resetData();
	}
	this.showloginpopup = showloginpopup;
	function showloginpopup()
	{	
		document.getElementById("signupSection1").style.display = 'none';
		document.getElementById("mlayer").style.display='block';
		document.getElementById("loginsection").style.display = 'block';
		document.getElementById("loginsection1").style.display = 'none';
		document.getElementById("loginsection2").style.display = 'none';
		document.getElementById("autosearch").style.display = 'none';
		$("#firstname_log").val("");
		$("#password_log").val("");
		$("#fnameerror_log").text("");
		$("#passworderror_log").text("");
	}
	function showloginpopup1()
	{	
		document.getElementById("signupSection1").style.display = 'none';
		document.getElementById("mlayer").style.display='block';
		document.getElementById("loginsection1").style.display = 'block';
		document.getElementById("loginsection2").style.display = 'none';
		document.getElementById("loginsection").style.display = 'none';
		document.getElementById("autosearch").style.display = 'none';
		$("#firstname_log1").val("");
		$("#password_log1").val("");
		$("#fnameerror_log1").text("");
		$("#passworderror_log1").text("");
	}
	function showloginpopup2()
	{	
		document.getElementById("signupSection1").style.display = 'none';
		document.getElementById("mlayer").style.display='block';
		document.getElementById("loginsection1").style.display = 'none';
		document.getElementById("loginsection").style.display = 'none';
		document.getElementById("loginsection2").style.display = 'block';
		document.getElementById("autosearch").style.display = 'none';
		$("#firstname_log2").val("");
		$("#password_log2").val("");
		$("#fnameerror_log2").text("");
		$("#passworderror_log2").text("");
	}
	//this.hide=hide;
	//javascript function for hide show popup
	function hide() 
	{
		document.getElementById("signupSection1").style.display = 'none';
		document.getElementById("mlayer").style.display = 'none';
		$("#overlay").css('display','none');
		document.getElementById("autosearch").style.display = 'none';
		document.getElementById("loginsection").style.display = 'none';
		document.getElementById("loginsection1").style.display = 'none';
		document.getElementById("loginsection2").style.display = 'none';
	}
	

	this.showForm=showForm;
	function showForm()
	{
	obj.showloginpopup();
	}

}
/*object function end here*/
	/*document loaded*/
$(document).ready(function()
{		obj.showResult();
});
	/*document unloaded*/



