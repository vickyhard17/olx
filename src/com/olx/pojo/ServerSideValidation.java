package com.olx.pojo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerSideValidation
{
	public boolean firstNamevalidate(String name)
	{
		Pattern p = Pattern.compile("^[a-zA-Z]{2,12}$");//. represents single character  
		Matcher m = p.matcher(name);  
		boolean b = m.matches();  
		if(b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean password(String name)
	{
		Pattern p = Pattern.compile("^[A-Z]{1}[a-z]{4,}[./@_]{1}[0-9]{2,}$");//. represents single character  
		Matcher m = p.matcher(name);  
		boolean b = m.matches();  
		if(b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean email(String name)
	{
		Pattern p = Pattern.compile("^([^.])([a-z0-9]+[\\.]{0,1})*[\\_]{0,1}[a-zA-Z0-9]+@[a-z0-9]{4,}\\.([com]{3}|[gov]{3}\\.[in]{2}|[co]{2}\\.[in]{2})");//. represents single character  
		Matcher m = p.matcher(name);  
		boolean b = m.matches();  
		if(b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean address(String name)
	{
		Pattern p = Pattern.compile("^[a-zA-Z]{2,12}$");//. represents single character  
		Matcher m = p.matcher(name);  
		boolean b = m.matches();  
		if(b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean contact(String name)
	{
		Pattern p = Pattern.compile("^[789]{1}[0-9]{9}$");//. represents single character  
		Matcher m = p.matcher(name);  
		boolean b = m.matches();  
		if(b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
