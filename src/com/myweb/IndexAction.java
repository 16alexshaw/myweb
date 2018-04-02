package com.myweb;



import com.myweb.tool.BottomBar;
import com.myweb.tool.TopBar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class IndexAction {
	@RequestMapping("/")
	public ModelAndView ShowNews() {
		ModelAndView mv=new ModelAndView("index");
		TopBar topBar=new TopBar();
		mv.addObject("top_nav",topBar.getBarContent());
		
		BottomBar bottomBar=new BottomBar();
		mv.addObject("bottom_bar", bottomBar.getBarContent());
return mv;
	}

	/*public String view;
	
	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView(view);
		mv.addObject("hello", "nihao");
		TopBar topBar=new TopBar();
		mv.addObject("top_nav",topBar.getBarContent());
		
		BottomBar bottomBar=new BottomBar();
		mv.addObject("bottom_bar", bottomBar.getBarContent());
		
		int a=3;
		Integer b=3;
		System.out.println("int的最大值："+String.valueOf(Integer.MAX_VALUE));
		mv.addObject("result","int的最大值："+String.valueOf(Integer.MAX_VALUE));
		
		
		return mv;
	}
*/
}
