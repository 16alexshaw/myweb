package com.myweb.tool;

import com.myweb.database.dao.NewsDao;

import redis.clients.jedis.Jedis;

public class NewsClick {

	NewsDao newsService;
	Jedis js;
	int max=5;
	public NewsClick(NewsDao ns) {
		js=new Jedis("localhost",6379);
		newsService=ns;
	}
	public int getNewsClickNum(int newsid) {
		if(js.exists("news"+newsid)) {
			String getValue=js.get("news"+newsid);
			int oldCount=Integer.parseInt(getValue.split(",")[0]);
			int refCount=Integer.parseInt(getValue.split(",")[1]);
			refCount=refCount+1;
			if(refCount>=max) {
				newsService.updateClickNum(newsid, oldCount+refCount);
				System.out.println("write to mysql");
				js.set("news"+newsid, String.valueOf(oldCount+refCount)+","+"1");
			}else {
				js.set("news"+newsid, String.valueOf(oldCount)+","+refCount);//lei jia
	
			}
			return oldCount+refCount;

		}else {
			int oldCount=newsService.getClickNum(newsid);
			js.set("news"+newsid, String.valueOf(oldCount)+","+"0");
			return oldCount+1;
		}
		
		
	}
}
