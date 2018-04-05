package com.zxf.dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.AlarmRecord;
import com.zxf.util.DBUtil;

public class AlarmRecordDao {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
	
	public AlarmRecordDao(){}
	
	public void saveAlarmRecord(AlarmRecord alarmRecord) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into alarm_record(tag,time,content) values(?,?,?)");
			Timestamp time = new Timestamp(df.parse(alarmRecord.getTime()).getTime());
			prep.setString(1, alarmRecord.getTag());
			prep.setTimestamp(2, time);
			prep.setString(3, alarmRecord.getContent());
			prep.executeUpdate();
			System.out.println("报警历史记录添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
		
	public List<AlarmRecord> getAlarmRecordByTag(String tag, int pageNum) throws Exception{
		int minNum = (pageNum-1)*20;
		int maxNum = pageNum*20-1;
		List<AlarmRecord> alarmRecords = new ArrayList<AlarmRecord>();
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from alarm_record where tag=? order by id desc limit ?,?");
			prep.setString(1, tag);
			prep.setInt(2, minNum);
			prep.setInt(3, maxNum);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				AlarmRecord alarmRecord = new AlarmRecord();
				alarmRecord.setId(rst.getInt("id"));
				alarmRecord.setTag(rst.getString("tag"));
				alarmRecord.setTime(df.format(rst.getTimestamp("time")));
				alarmRecord.setContent(rst.getString("content"));
				alarmRecords.add(alarmRecord);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		
		return alarmRecords;
	}
	
	public List<AlarmRecord> getAlarmRecordByTagAndTime(String tag, String time, int pageNum) throws Exception{
		int minNum = (pageNum-1)*20;
		int maxNum = pageNum*20-1;
		List<AlarmRecord> alarmRecords = new ArrayList<AlarmRecord>();
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from alarm_record where tag=? and date(time)=? order by id desc limit ?,?");
			prep.setString(1, tag);
			prep.setString(2, time);
			prep.setInt(3, minNum);
			prep.setInt(4, maxNum);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				AlarmRecord alarmRecord = new AlarmRecord();
				alarmRecord.setId(rst.getInt("id"));
				alarmRecord.setTag(rst.getString("tag"));
				alarmRecord.setTime(df.format(rst.getTimestamp("time")));
				alarmRecord.setContent(rst.getString("content"));
				alarmRecords.add(alarmRecord);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		
		return alarmRecords;
	}
}
