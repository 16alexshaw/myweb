package com.myweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.model.UserModel;

@Controller
public class test {

	@Autowired
	com.myweb.database.dao.UserDao myUser;
	@RequestMapping("/test")
	public ModelAndView ontest() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("test");
		List<UserModel> getUsers=myUser.getAllUser();
		mv.addObject("alluser", getUsers);
		mv.addObject("pwd", myUser.getUserpwd("sjz"));
		return mv;
	}
}
