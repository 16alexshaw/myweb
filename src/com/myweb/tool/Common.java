package com.myweb.tool;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Common
{
	
	public static String getUserIp()
	{
	
			HttpServletRequest request =( (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String ip = request.getHeader("x-forwarded-for");
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
		    {
		         ip = request.getHeader("Proxy-Client-IP");
		             }
		           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("WL-Proxy-Client-IP");
		           }
		           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		           ip = request.getRemoteAddr();
		              }
		           return ip;

		}
	
	
	 public static String getUserName()  //获取当前用户名
	 {
		 HttpServletRequest myRequest =( (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		 Cookie[] getCookies=myRequest.getCookies();
		 for(Cookie c :getCookies)
		 { 
			 if(c.getName().equals("logUserName"))
			 {
				 //代表用户已经登录了
				 return c.getValue();
			 }
		 } 
		 return null;
	 }
}
