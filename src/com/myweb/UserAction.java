package com.myweb;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.UserDao;
import com.myweb.database.model.UserModel;
import com.myweb.user.User;

@Controller
public class UserAction {

	@Autowired
	UserDao myUser;
	@RequestMapping("/unlog")
	public void unlog(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Cookie logUser=new Cookie("logUserName", null);
		logUser.setMaxAge(0);
		logUser.setPath("/");
		response.addCookie(logUser);
		response.sendRedirect("login");
	}
	
	@RequestMapping("/reg")
	public ModelAndView reg(UserModel User, HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView mv=new ModelAndView("reg2");
		if(User.getUsername()!=null) {
		int getUserID=myUser.addUser(User);
		if(getUserID>0) {
			mv.addObject("result", "注册成功");
		}else {
			if(getUserID==-1) {
				mv.addObject("result", "用户已存在");
	
			}else
			mv.addObject("result", "注册失败");

		}
		}
		
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("loginfrm") User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("info", "请输入用户名 密码");
		if(user.getUsername()!=null && user.getUserpsw()!=null) {
			String getPwd=myUser.getUserpwd(user.getUsername());
			if(getPwd != null && getPwd.equals(user.getUserpsw())) {
				mv.addObject("result","登录ok");
				Cookie logUser=new Cookie("logUserName", user.getUsername());
				logUser.setMaxAge(3600);
				logUser.setPath("/");
				response.addCookie(logUser);
				 mv.addObject("user", user.getUsername());

			//mv.setViewName("index");
			//	mv.setViewName("newslist");
				response.sendRedirect("newslist");
				return mv;

				}else {
					mv.addObject("result","登录失败");

				}
			}
		Cookie[] getCookies=request.getCookies();
		for(Cookie c:getCookies) {
			if(c.getName().equals("logUserName")) {
				response.sendRedirect("newslist");


			}
		}
		return mv;

	}
	@RequestMapping("/onlogin")
	public ModelAndView onlogin(@ModelAttribute("loginfrm") User user,
			HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("login");
		
		//mv.addObject("info", "你输入的用户名是"+user.getUsername());
		//mv.addObject("info2", "你输入的密码是"+user.username);
//System.out.println(user.getUsername());
//System.out.println(user.getUserpsw());

		if(user.getUsername().equals("sjz") && user.getUserpsw().equals("123")) {
			Cookie logUser=new Cookie("userName", user.getUsername());
			logUser.setMaxAge(3600);
			logUser.setPath("/");
			response.addCookie(logUser);
			mv.addObject("result","登录成功");
		}else {
			mv.addObject("result","登录失败");

		}
		
		return mv;

	}
}
