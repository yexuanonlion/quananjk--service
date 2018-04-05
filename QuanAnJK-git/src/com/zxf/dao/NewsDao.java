package com.zxf.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.News;
import com.zxf.util.DBUtil;

public class NewsDao {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
	
	public NewsDao(){}
	
	public void saveNews(News news) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into news_tables(title,releasetime,publisher,profile,content) values(?,now(),?,?,?)");
			prep.setString(1, news.getTitle());
			prep.setString(2, news.getPublisher());
			prep.setString(3, news.getProfile());
			prep.setString(4, news.getContent());
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	public void updateNews(News news,int id) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update news_tables set title=?,releasetime=now(),publisher=?,profile=?,content=? where id=?");
			prep.setString(1, news.getTitle());
			prep.setString(2, news.getPublisher());
			prep.setString(3, news.getProfile());
			prep.setString(4, news.getContent());
			prep.setInt(5, id);
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	public void deleteNews(int id) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("delete from news_tables where id=?");
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	public News findNewsById(int id) throws Exception{
		Connection conn = null;
		News news = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from news_tables where id=?");
			prep.setInt(1, id);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				news = new News();
				news.setId(rst.getInt("id"));
				news.setTitle(rst.getString("title"));
				news.setPublisher(rst.getString("publisher"));
				news.setTime(df.format(rst.getTimestamp("releasetime")));
				news.setProfile(rst.getString("profile"));
				news.setContent(rst.getString("content"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		return news;
	}
	public List<News> findAllNews() throws Exception{
		Connection conn = null;
		List<News> newsList = new ArrayList<News>();
		News news = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from news_tables order by id desc");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				news = new News();
				news.setId(rst.getInt("id"));
				news.setTitle(rst.getString("title"));
				news.setPublisher(rst.getString("publisher"));
				news.setTime(df.format(rst.getTimestamp("releasetime")));
				news.setProfile(rst.getString("profile"));
				news.setContent(rst.getString("content"));
				newsList.add(news);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		return newsList;
	}
	

	
	public List<News> showNewsByPageNum(int pageNum) throws Exception{
		int minNum = (pageNum-1)*20;
		int maxNum = pageNum*20-1;
		Connection conn = null;
		List<News> newsList = new ArrayList<News>();
		News news = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from news_tables order by id desc limit ?,?");
			prep.setInt(1, minNum);
			prep.setInt(2, maxNum);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				news = new News();
				news.setId(rst.getInt("id"));
				news.setTitle(rst.getString("title"));
				news.setPublisher(rst.getString("publisher"));
				news.setTime(df.format(rst.getTimestamp("releasetime")));
				news.setProfile(rst.getString("profile"));
				news.setContent(rst.getString("content"));
				newsList.add(news);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		return newsList;
	}
}
