package com.myweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.NewsDao;
import com.myweb.database.dao.ReviewDao;
import com.myweb.database.model.NewsModel;
import com.myweb.database.model.ReviewModel;
import com.myweb.news.NewsEntity;
import com.myweb.tool.BottomBar;
import com.myweb.tool.Common;
import com.myweb.tool.NewsClick;
import com.myweb.tool.TopBar;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

@Controller
public class NewsAction {

	@Autowired
	JdbcTemplate jb;
	@Autowired
	NewsDao newsService;
	@Autowired
	ReviewDao reviewService;
	@RequestMapping("/newsdetail")
	public ModelAndView loadNewsdetail(int newsid) throws IOException {
		ModelAndView mv=new ModelAndView("newsdetail");
		
		MemcachedClient mc=new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
		mc.set("test", 20, "hello");
		//System.out.println(mc.get("test"));
		NewsModel news=(NewsModel) mc.get("news_model_key"+String.valueOf(newsid));
		if(news==null) {
			news=newsService.loadNewsDetail(newsid);
			mc.set("news_model_key", 3600, news);
		}
		else
		{
			System.out.println("use cache...");
		}
		//int newsClickNum=newsService.getClickNum(newsid);
		int newsClickNum=new NewsClick(newsService).getNewsClickNum(newsid);
		System.out.println(newsClickNum);
		mv.addObject("newsid", newsid);

		mv.addObject("NewsDetail", news);
		mv.addObject("newsClickNum", newsClickNum);
		return mv;
	}
	
	@RequestMapping("/addreview")
	public void addreview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int newsid=Integer.parseInt(request.getParameter("newsid"));
		String rcnt=request.getParameter("rcnt");
		String userName=Common.getUserName();
		int newstype=1;
		if(userName==""|| userName==null) {
			response.getWriter().write("unknown user");
		}
		else
		{
			//String ip=Common.getUserIp();
			ReviewModel rm=new ReviewModel();
	    	rm.setNewsid(newsid);
	    	rm.setNewstype(1);
	    	rm.setRcnt(rcnt);
	    	rm.setUserip(com.myweb.tool.Common.getUserIp());
	    	rm.setUsername(userName);
	    	reviewService.addReview(rm);
	    	response.getWriter().write("1");

		}
	}
	
	@RequestMapping("/newslist")
	public ModelAndView loadNews(HttpServletRequest req,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("newslist");
		int size=1;
		
		mv.addObject("size", size);
		int page=1;
		if(req.getParameter("page")!=null) {
			page=Integer.parseInt(req.getParameter("page"));
			if(page<=0) page=1;
		}
		mv.addObject("newslist", newsService.loadNews(page,size));
		mv.addObject("sum", newsService.getNewsCount());
		mv.addObject("page", page);
		return mv;
		
	}
	
	@RequestMapping("/news")
	public ModelAndView ShowNews() {

		ModelAndView mv=new ModelAndView("news");
		mv.addObject("content", "这是新闻页");
		TopBar topBar=new TopBar();
		mv.addObject("top_nav",topBar.getBarContent());
		
		BottomBar bottomBar=new BottomBar();
		mv.addObject("bottom_bar", bottomBar.getBarContent());
	
		return mv;
	}
	@RequestMapping("/news2")
	public ModelAndView ShowNewsDetail(@RequestParam(value="id",required=false) String id) {

		ModelAndView mv=new ModelAndView("news");
		if(id==null) {
			mv.addObject("content", "这是新闻页列表");

		}else {
			mv.addObject("content", "这是新闻页id:"+id);

		}
		TopBar topBar=new TopBar();
		mv.addObject("top_nav",topBar.getBarContent());
		
		BottomBar bottomBar=new BottomBar();
		mv.addObject("bottom_bar", bottomBar.getBarContent());
	
		List the_news=new ArrayList<>();
		the_news.add("第一条新闻");
		the_news.add("第二条新闻");
		the_news.add("第三条新闻");
		
		
		List the_news2=new ArrayList<>();

		mv.addObject("the_news", the_news);
		Map four_news=new HashMap();
		four_news.put("newstitle", "第四条新闻");
		Map five_news=new HashMap();
		five_news.put("newstitle", "第五条新闻");
		the_news2.add(four_news);
		the_news2.add(five_news);

		mv.addObject("the_news2", the_news2);

	
		StringBuffer sb=new StringBuffer();
		sb.append("<a href=''>首页</a> | ");
		sb.append("<a href=''>第一页</a> | ");
		sb.append("<a href=''>第二页</a> | ");
		sb.append("<a href=''>末页</a>");
	
		mv.addObject("pagebar",sb.toString());
		//com.myweb.news.NewsEntity newsEntity=new NewsEntity();
		//mv.addObject("newsEntity", newsEntity.getNews());

		List<NewsEntity> newsList=new ArrayList<NewsEntity>();
		newsList.add(new NewsEntity("新闻1",1));
		newsList.add(new NewsEntity("新闻2",2));
		newsList.add(new NewsEntity("新闻3",3));
		mv.addObject("newsList", newsList);
	List userlist=	jb.queryForList("select * from users");
	mv.addObject("userlist", userlist);
	
	return mv;
	}
	@RequestMapping("/news/{id}/")
	public ModelAndView ShowNewsDetail2(@PathVariable String id) {

		ModelAndView mv=new ModelAndView("news");
		if(id==null) {
			mv.addObject("content", "这是新闻页列表");

		}else {
			mv.addObject("content", "这是新闻页id:用PathVariable页"+id);

		}
		TopBar topBar=new TopBar();
		mv.addObject("top_nav",topBar.getBarContent());
		
		BottomBar bottomBar=new BottomBar();
		mv.addObject("bottom_bar", bottomBar.getBarContent());
	
		return mv;
	}
}
