package com.zxf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.Collierie;
import com.zxf.util.DBUtil;

public class CollierieDao {
	public void saveCollierie(Collierie collierie) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into collierie(colname,colposition,linkman,phonenumber,stablename) values(?,?,?,?,?)");
			prep.setString(1, collierie.getCollierieName());
			prep.setString(2, collierie.getPosition());
			prep.setString(3, collierie.getLinkman());
			prep.setString(4, collierie.getPhoneNumber());
			prep.setString(5,collierie.getTableName());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void deleteCollierie(int id) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql1 = "delete from collierie where id="+id;
			String sql2 = "DROP TABLE IF EXISTS "+findCollierieById(id).getTableName();
			PreparedStatement prep1 = (PreparedStatement) conn.prepareStatement(sql1);
			PreparedStatement prep2 = (PreparedStatement) conn.prepareStatement(sql2);
			prep1.executeUpdate();
			prep2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void updateCollierie(Collierie collierie) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update collierie set colposition=?,linkman=?,phonenumber=? where colname=?");
			prep.setString(1, collierie.getPosition());
			prep.setString(2,collierie.getLinkman());
			prep.setString(3,collierie.getPhoneNumber());
			prep.setString(4, collierie.getCollierieName());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public Collierie findCollierieByColname(String colname) throws Exception{
		Collierie collierie = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from collierie where colname=?");
			prep.setString(1, colname);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				collierie = new Collierie();
				collierie.setCollierieId(rst.getInt("id"));
				collierie.setCollierieName(rst.getString("colname"));
				collierie.setPosition(rst.getString("colposition"));
				collierie.setLinkman(rst.getString("linkman"));
				collierie.setPhoneNumber(rst.getString("phonenumber"));
				collierie.setTableName(rst.getString("stablename"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return collierie;
	}
	
	public List<Collierie> findAllCollierie() throws Exception{
		List<Collierie> collierieList = new ArrayList<Collierie>();
		Collierie collierie = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from collierie");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				collierie = new Collierie();
				collierie.setCollierieId(rst.getInt("id"));
				collierie.setCollierieName(rst.getString("colname"));
				collierie.setPosition(rst.getString("colposition"));
				collierie.setLinkman(rst.getString("linkman"));
				collierie.setPhoneNumber(rst.getString("phonenumber"));
				collierie.setTableName(rst.getString("stablename"));
				collierieList.add(collierie);
				System.out.println(collierieList.size());
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return collierieList;
	}
	
	public Collierie findCollierieById(int id) throws Exception{
		Collierie collierie = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from collierie where id=?");
			prep.setInt(1, id);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				collierie = new Collierie();
				collierie.setCollierieId(rst.getInt("id"));
				collierie.setCollierieName(rst.getString("colname"));
				collierie.setPosition(rst.getString("colposition"));
				collierie.setLinkman(rst.getString("linkman"));
				collierie.setPhoneNumber(rst.getString("phonenumber"));
				collierie.setTableName(rst.getString("stablename"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return collierie;
	}

	public Collierie findCollierieByTableName(String tableName) throws Exception{
		Collierie collierie = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from collierie where stablename=?");
			prep.setString(1, tableName);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				collierie = new Collierie();
				collierie.setCollierieId(rst.getInt("id"));
				collierie.setCollierieName(rst.getString("colname"));
				collierie.setPosition(rst.getString("colposition"));
				collierie.setLinkman(rst.getString("linkman"));
				collierie.setPhoneNumber(rst.getString("phonenumber"));
				collierie.setTableName(rst.getString("stablename"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return collierie;
	}
	
	public void creatTableForCol(String colname) throws Exception{
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			String sql1 = "DROP TABLE IF EXISTS "+colname;
			String sql2 = "CREATE TABLE "+colname
					+"(id INT(12) NOT NULL AUTO_INCREMENT,"
					+"sennumber VARCHAR(45) NOT NULL,"
					+"senposition VARCHAR(45) NOT NULL,"
					+"senworking VARCHAR(45) NOT NULL,"
					+"sentime DATETIME NULL,"
					+"powertime DATETIME NULL,"
					+"senofcol VARCHAR(45) NULL,"
					+"PRIMARY KEY (id),"
					+"UNIQUE INDEX id_UNIQUE (id ASC));";
			PreparedStatement prep1 = (PreparedStatement) conn.prepareStatement(sql1);
			PreparedStatement prep2 = (PreparedStatement) conn.prepareStatement(sql2);
			prep1.executeUpdate();
			prep2.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public List<String> findAllColnam() throws Exception{
		Connection conn = null;
		List<String> colnameList = new ArrayList<String>();
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select colname from collierie");
			ResultSet rst = prep.executeQuery();
			
			while(rst.next()){
				colnameList.add(rst.getString("colname"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return colnameList;
	}
	

}
