package com.zxf.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.Information;
import com.zxf.util.DBUtil;

public class InformationDao {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
	
	public InformationDao(){}
	
	public void updateInformation(String content,int id) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update information_table set updatetime=now(),content=? where id=?");
			prep.setString(1, content);
			prep.setInt(2, id);
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	public List<Information> showCompanyInformation() throws Exception{
		Connection conn = null;
		List<Information> companyInformationList = new ArrayList<Information>();
		Information companyInformation = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from information_table where id<4");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				companyInformation = new Information();
				companyInformation.setId(rst.getInt("id"));
				companyInformation.setTitleName(rst.getString("titlename"));
				companyInformation.setUpdateTime(df.format(rst.getTimestamp("updatetime")));
				companyInformation.setContent(rst.getString("content"));
				companyInformationList.add(companyInformation);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		
		return companyInformationList;
	}
	
	public List<Information> showProductInformation() throws Exception{
		Connection conn = null;
		List<Information> productInformationList = new ArrayList<Information>();
		Information productInformation = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from information_table where id>3");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				productInformation = new Information();
				productInformation.setId(rst.getInt("id"));
				productInformation.setTitleName(rst.getString("titlename"));
				productInformation.setUpdateTime(df.format(rst.getTimestamp("updatetime")));
				productInformation.setContent(rst.getString("content"));
				productInformationList.add(productInformation);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		
		return productInformationList;
	}
	
	public Information findInformationById(int id) throws Exception{
		Connection conn = null;
		Information information = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from information_table where id=?");
			prep.setInt(1, id);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				information = new Information();
				information.setId(rst.getInt("id"));
				information.setTitleName(rst.getString("titlename"));
				information.setUpdateTime(df.format(rst.getTimestamp("updatetime")));
				information.setContent(rst.getString("content"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		
		return information;
	}

}
