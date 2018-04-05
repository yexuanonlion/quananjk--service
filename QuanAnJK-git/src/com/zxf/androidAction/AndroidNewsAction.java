 package com.zxf.androidAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zxf.dao.NewsDao;
import com.zxf.po.News;
import com.zxf.web.BaseAction;


public class AndroidNewsAction extends BaseAction{
	private int id;
	private String pageNum;
	
	NewsDao newsDao = new NewsDao();
	
	//传一系列对象
	public void showNewsList(){
		try{
			this.httpResponse.setContentType("text/json;charset=utf-8");
			this.httpResponse.setCharacterEncoding("UTF-8");
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			List<News> newsList = newsDao.showNewsByPageNum(Integer.parseInt(pageNum));
			
			for(int i=0;i<newsList.size();i++){
				Map<String,Object> newsMap = new HashMap<String, Object>();
				newsMap.put("id",newsList.get(i).getId() );
				newsMap.put("title", newsList.get(i).getTitle());
				newsMap.put("publisher", newsList.get(i).getPublisher());
				newsMap.put("time", newsList.get(i).getTime());
				newsMap.put("profile", newsList.get(i).getProfile());
				newsMap.put("content", newsList.get(i).getContent());
				jsonArray.put(newsMap);
			}
			jsonObject.put("newsList", jsonArray);	
			System.out.println(jsonObject.toString());
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//传单个对象
	public void showNews(){
		try{
			this.httpResponse.setContentType("text/json;charset=utf-8");
			this.httpResponse.setCharacterEncoding("UTF-8");
			JSONObject jsonObject = new JSONObject();
			News news = newsDao.findNewsById(id);
			Map<String,Object> newsMap = new HashMap<String, Object>();
			newsMap.put("id",news.getId() );
			newsMap.put("title", news.getTitle());
			newsMap.put("publisher", news.getPublisher());
			newsMap.put("time", news.getTime());
			newsMap.put("profile", news.getProfile());
			newsMap.put("content", news.getContent());
			jsonObject.put("news", newsMap);
			System.out.println(jsonObject.toString());
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
}
