package com.myweb.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class WebMsg {

	Jedis js;

	public WebMsg() {
		js=new Jedis("localhost",6379);
				
	}
	public Long getMsgLength(String userName)
	{
		if(this.hasMsg(userName))
		{
			return js.llen("msg_"+userName);
		}
		return (long) 0;
	}
	public List<String> loadMsg(String userName,int page,int pagesize){
	
		SortingParams sp=new SortingParams();
		sp.limit((page-1)*pagesize, pagesize);
		sp.desc();
		return	js.sort("msg_"+userName, sp);
	}
	public Boolean hasMsg(String userName) {
		return js.exists("msg_"+userName);
	}
	public void sendMsg(String sendUser,String recUser,String msgConent)
	{
		Date cDate=new Date();
		DateFormat cf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		String time=cf.format(cDate);//时间日期 字符串
		//拼接第一个key   info_b_from_a
				//String key1="info_"+recUser+"_"+"from"+"_"+sendUser;
				//js.hset("webmsg", key1, time);
				//System.out.println(key1);
				//拼接第二个key  msg_b
				String key2="msg_"+recUser;
				String key2_body=time+"_"+sendUser+"_"+msgConent;
				System.out.println(key2);

				js.rpush(key2, key2_body);

}
	public void delMsg(String keyName)
	{
		js.hdel("webmsg", keyName);//删除消息提醒
	}

}
