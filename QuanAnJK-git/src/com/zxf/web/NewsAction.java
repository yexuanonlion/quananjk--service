package com.zxf.web;

import java.util.List;

import com.zxf.dao.NewsDao;
import com.zxf.po.News;

public class NewsAction {
	private int id;
	private String title;
	private String publisher;
	private String profile;
	private String content;
	private News news;
	private List<News> newsList;
	
	NewsDao newsDao = new NewsDao();
	
	public NewsAction(){}
	
	public String showNews() throws Exception{
		news = newsDao.findNewsById(id);
		return "success";
	}
	
	public String newsList() throws Exception{
		newsList = newsDao.findAllNews();
		return "success";
	}
	
	public String changeNews() throws Exception{
		News changeNews = new News();
		changeNews.setTitle(title);
		changeNews.setPublisher(publisher);
		changeNews.setProfile(profile);
		changeNews.setContent(changeSign(content));
		newsDao.updateNews(changeNews, id);
		return "success";
	}
	
	public String deleteNews() throws Exception{
		newsDao.deleteNews(id);
		return "success";
	}
	
	public String addNews() throws Exception{
		News addNews = new News();
		addNews.setTitle(title);
		addNews.setPublisher(publisher);
		addNews.setProfile(profile);
		addNews.setContent(changeSign(content));
		newsDao.saveNews(addNews);
		return "success";
		
	}
	
	public String changeSign(String oldString){
		String newString = oldString.replaceAll("\"","\'");
		return newString;
	}
	
	public String addNewsJump(){
		return "success";
		
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
