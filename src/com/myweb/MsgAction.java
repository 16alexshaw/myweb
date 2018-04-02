package com.myweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.UserDao;
import com.myweb.database.model.MyMsg;
import com.myweb.tool.WebMsg;

@Controller
public class MsgAction {

	@Autowired
	HttpServletRequest myRequest;
	
	@Autowired
	UserDao myUser;
	
	public String getLoginUserName() {
		Cookie[] getCookies=myRequest.getCookies();
		for(Cookie c:getCookies) {
			if(c.getName().equals("logUserName")) {
				System.out.println(c.getValue());

			return c.getValue();
			}
		}
		return "";
	}
	@RequestMapping("/msgtest")
	public String msgtest(HttpServletRequest req,HttpServletResponse response) {
		WebMsg msg=new WebMsg();
		msg.sendMsg("a", "b", "hello");
		return "test";
	}
	@RequestMapping("/msglist2")
	public ModelAndView msglist2(HttpServletRequest req,HttpServletResponse response) throws IOException {
	ModelAndView mv=new ModelAndView("msglist_read");
	mv.addObject("msglist", myUser.getMyMsg(this.getLoginUserName()));
	return mv;
	}
	@RequestMapping("/msglist")
	public ModelAndView getMsgList(HttpServletRequest req,HttpServletResponse response) throws IOException {
	ModelAndView mv=new ModelAndView("msglist");
	WebMsg msg=new WebMsg();
	String username=this.getLoginUserName();
	mv.addObject("CurrentUserName", username);
	mv.addObject("sum", msg.getMsgLength(username));
	int page=1;
	if(req.getParameter("page")!=null) {
		page=Integer.parseInt(req.getParameter("page"));
		if(page<=0) page=1;
	}
	
	List<String> msgList=msg.loadMsg(username, page, 10);
	if(msgList!=null) {
		mv.addObject("msglist", msgList);
	
	}
	mv.addObject("page", page);
	return mv;
	}
	@RequestMapping("/addmsg")
	public void addmsg(HttpServletRequest req,HttpServletResponse response) throws IOException {
	String sender=req.getParameter("sender");
	String msgcnt=req.getParameter("msgcnt");
	String sendtime=req.getParameter("sendtime");
	String receiver=this.getLoginUserName();
	MyMsg msg=new MyMsg();
	msg.sender=sender;
	msg.msgcnt=msgcnt;
	msg.receiver=receiver;
	msg.sendtime=sendtime;
	
	myUser.addMyMsg(msg);
	try {
		response.getWriter().write("1");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	}
	@RequestMapping("/sendmsg")
	public void sendmsg(HttpServletRequest req,HttpServletResponse response) throws IOException {
		String userName=req.getParameter("UserName");
		String msgContent=req.getParameter("MsgContent");
		String send=this.getLoginUserName();
		
		if(send=="")response.getWriter().write("0");
		WebMsg msg=new WebMsg();
		msg.sendMsg(send, userName, msgContent);
		response.getWriter().write("1");
	}
	@RequestMapping("/send")
	public String msg(HttpServletRequest req,HttpServletResponse response) {
		
		return "msg";
	}

	@RequestMapping("/getmsg")
	public void getmsg(HttpServletRequest req,HttpServletResponse response) {
		try {
			String getUser=this.getLoginUserName();
			if(getUser=="") {
				response.getWriter().write("-1");
			}
			WebMsg msg=new WebMsg();
			if(msg.hasMsg(getUser)) {
				response.getWriter().write("1");
			}
			else
			{
				response.getWriter().write("0");
			}
			//response.getWriter().write("hello");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
