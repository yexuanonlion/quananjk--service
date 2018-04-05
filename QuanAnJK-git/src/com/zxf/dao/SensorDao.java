package com.zxf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.Sensor;
import com.zxf.util.DBUtil;

public class SensorDao {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
	public void saveSensor(Sensor sensor) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into sensor(sennumber,senposition,senworking,sentime) values(?,?,?,now())");
			prep.setString(1, sensor.getSensorNumber());
			prep.setString(2, sensor.getSensorPosition());
			prep.setString(3, sensor.getSensorWorkingCondition());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void deleteSensor(String sennumber) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("delete from sensor where sennumber=?");
			prep.setString(1, sennumber);
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void updateSensor(Sensor sensor) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update sensor set senposition=?,senworking=?,sentime=now() where sennumber=?");
			prep.setString(1, sensor.getSensorPosition());
			prep.setString(2,sensor.getSensorWorkingCondition());
			prep.setString(4, sensor.getSensorNumber());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public List<Sensor> findSensorByColname(String scolname) throws Exception{
		List<Sensor> sensors = new ArrayList<Sensor>();
		Sensor sensor = null;
		Connection conn = null;
		CollierieDao dao = new CollierieDao();
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from "+ dao.findCollierieByColname(scolname).getTableName();
			System.out.println(sql);
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				sensor = new Sensor();
				sensor.setSensorId(rst.getInt("id"));
				sensor.setSensorNumber(rst.getString("sennumber"));
				sensor.setSensorPosition(rst.getString("senposition"));
				sensor.setSensorWorkingCondition(rst.getString("senworking"));
				sensor.setSensorTime(df.format(rst.getTimestamp("sentime")));
				if(rst.getString("senworking").equals("开盖")){
					sensor.setPowerTime("报警");
				}else if(rst.getString("senworking").equals("断电|有电")){
					sensor.setPowerTime("报警");
				}else if(rst.getString("senworking").equals("异常")){
					sensor.setPowerTime("报警");
				}else{
					sensor.setPowerTime("未报警");
				}
				sensors.add(sensor);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return sensors;
	}
	
	public List<Sensor> findAllSensor() throws Exception{
		
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = null;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from sensor");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				sensor = new Sensor();
				sensor.setSensorId(rst.getInt("id"));
				sensor.setSensorNumber(rst.getString("sennumber"));
				sensor.setSensorPosition(rst.getString("senposition"));
				sensor.setSensorWorkingCondition(rst.getString("senworking"));
				sensor.setSensorTime(df.format(rst.getTimestamp("sentime")));
				if(rst.getString("senworking").equals("开盖")){
					sensor.setPowerTime("报警");
				}else if(rst.getString("senworking").equals("断电|有电")){
					sensor.setPowerTime("报警");
				}else if(rst.getString("senworking").equals("异常")){
					sensor.setPowerTime("报警");
				}else{
					sensor.setPowerTime("未报警");
				}
				sensorList.add(sensor);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return sensorList;
	}
	
	public boolean vaildColname(String scolname) throws Exception{
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from sensor where senofcol=?");
			prep.setString(1, scolname);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
}
