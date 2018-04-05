package com.zxf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.User;
import com.zxf.util.DBUtil;

public class UserDao {
	public void saveUser(User user) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into user(username,password,colname,phonenum) values(?,?,?,?)");
			prep.setString(1, user.getUsername());
			prep.setString(2, user.getPassword());
			prep.setString(3, user.getCollierieName());
			prep.setString(4, user.getPhoneNumber());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void deleteUser(int id) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("delete from user where id=?");
			prep.setInt(1,id);
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void updateUser(User user) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update user set password=?,colname=?,phonenum=? where username=?");
			prep.setString(1, user.getPassword());
			prep.setString(2,user.getCollierieName());
			prep.setString(3,user.getPhoneNumber());
			prep.setString(4, user.getUsername());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public User findUserByUsername(String username) throws Exception{
		User user = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from user where username=?");
			prep.setString(1, username);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				user = new User();
				user.setId(rst.getInt("id"));
				user.setUsername(username);
				user.setPassword(rst.getString("password"));
				user.setCollierieName(rst.getString("colname"));
				user.setPhoneNumber(rst.getString("phonenum"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return user;
	}
	
	public List<User> findAllUser() throws Exception{
		List<User> userList = new ArrayList<User>();
		User user = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from user");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				user = new User();
				user.setId(rst.getInt("id"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				user.setCollierieName(rst.getString("colname"));
				user.setPhoneNumber(rst.getString("phonenum"));
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return userList;
	}
	
	public User findUserById(int id) throws Exception{
		User user = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from user where id=?");
			prep.setInt(1, id);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				user = new User();
				user.setId(rst.getInt("id"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				user.setCollierieName(rst.getString("colname"));
				user.setPhoneNumber(rst.getString("phonenum"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return user;
	}
	
	public String findTableNameAndColnameByUsername(String username) throws Exception{
		Connection conn = null;
		String tag = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select colname from user where username=?");
			prep.setString(1, username);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				String colname = rst.getString("colname");
				PreparedStatement prep2 = (PreparedStatement) conn.prepareStatement("select stablename from collierie where colname=?");
				prep2.setString(1,colname);
				ResultSet rst2 = prep2.executeQuery();
				if(rst2.next()){
					tag = rst2.getString("stablename")+"|"+colname;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return tag;
	}
	
	public String changePassword(String username,String password){
		String flag = "";
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update user set password=? where username=?");
			prep.setString(1,password);
			prep.setString(2,username);
			prep.executeUpdate();
			flag = "1";//修改成功
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = "2";//修改失败
			
		}finally{
			DBUtil.close(conn);
		}
		
		return flag;
	}
}
