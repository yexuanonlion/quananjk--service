package com.zxf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.UpLoadFile;
import com.zxf.util.DBUtil;

public class UpLoadDao {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
	public void saveFileInformation(String fileName,String fileVersion) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into apkversion(apkname,version,uploadtime) values(?,?,now())");
			prep.setString(1, fileName);
			prep.setString(2, fileVersion);
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public List<UpLoadFile> showFiles() throws Exception{
		Connection conn = null;
		UpLoadFile uploadFile = null;
		List<UpLoadFile> fileList = new ArrayList<UpLoadFile>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from apkversion");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				uploadFile = new UpLoadFile();
				uploadFile.setId(rst.getInt("id"));
				uploadFile.setFileName(rst.getString("apkname"));
				uploadFile.setFileVersion(rst.getString("version"));
				uploadFile.setUpLoadTime(df.format(rst.getTimestamp("uploadtime")));
				fileList.add(uploadFile);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return fileList;
	}
	
	public UpLoadFile findLastFile() throws Exception{
		Connection conn = null;
		UpLoadFile uploadFile = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from apkversion order by id desc limit 1");
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				uploadFile = new UpLoadFile();
				uploadFile.setId(rst.getInt("id"));
				uploadFile.setFileName(rst.getString("apkname"));
				uploadFile.setFileVersion(rst.getString("version"));
				uploadFile.setUpLoadTime(df.format(rst.getTimestamp("uploadtime")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return uploadFile;
	}
}
