package com.zxf.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zxf.po.AccidentCase;
import com.zxf.util.DBUtil;

public class AccidentCaseDao {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public AccidentCaseDao(){}
	
	//存储事故案例
	public void saveAccidentCase(AccidentCase accidentCase) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("insert into accident_case_set(time,content) values(?,?)");
			Date time = (Date) df.parse(accidentCase.getTime());
			prep.setDate(1, time);
			prep.setString(2, accidentCase.getContent());
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	//事故案例删除
	public void deleteAccidentCase(int id) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("delete from accident_case_set where id=?");
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
	
	//事故案例内容修改
	public void upDateAccidentCase(AccidentCase accidentCase) throws Exception{
		Connection conn = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("update accident_case_set set time=?,content=? where id=?");
			Date time = (Date) df.parse(accidentCase.getTime());
			prep.setDate(1, time);
			prep.setString(2,accidentCase.getContent());
			prep.setInt(3, accidentCase.getId());
			prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	//按日期查询事故案例
	public AccidentCase findAccidentCaseByTime(String time) throws Exception{
		Connection conn = null;
		AccidentCase accidentCase = null;
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select * from accident_case_set where time=?");
			prep.setString(1, time);
			ResultSet rst = prep.executeQuery();
			if(rst.next()){
				accidentCase = new AccidentCase();
				accidentCase.setId(rst.getInt("id"));
				accidentCase.setTime(df.format(rst.getDate("time")));
				accidentCase.setContent(rst.getString("content"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		return accidentCase;
	}
	
	//获得表中存在的所有年份
	public List<Integer> findAllYear() throws Exception{
		Connection conn = null;
		Calendar cl = Calendar.getInstance();
		List<Integer> rstList = new ArrayList<Integer>();
		List<Integer> yearList = new ArrayList<Integer>();
		Set<Integer> yearSet = new TreeSet<Integer>();
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select time from accident_case_set order by time desc");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				Date time = rst.getDate("time");
				cl.setTime(time);
				rstList.add(cl.get(Calendar.YEAR));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		yearSet.addAll(rstList);
		yearList.addAll(yearSet);
		Collections.sort(yearList);
		Collections.reverse(yearList);
		return yearList;
		
	}
	//获得某年对应的所有的月份
	public List<Integer> findAllMonthByYear(String year) throws Exception{
		Connection conn = null;
		Calendar cl = Calendar.getInstance();
		List<Integer> rstList = new ArrayList<Integer>();
		List<Integer> monthList = new ArrayList<Integer>();
		Set<Integer> monthSet = new TreeSet<Integer>();
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select time from accident_case_set where year(time)=? order by time asc");
			prep.setString(1, year);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				Date time = rst.getDate("time");
				cl.setTime(time);
				rstList.add(cl.get(Calendar.MONTH)+1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		monthSet.addAll(rstList);
		monthList.addAll(monthSet);
		Collections.sort(monthList);
		return monthList;
		
		
	}
	//获得某年月对应的多有日期
	public List<Integer> findAllDayByYearAndMonth(String year, String month) throws Exception{
		Connection conn = null;
		Calendar cl = Calendar.getInstance();
		List<Integer> dayList = new ArrayList<Integer>();
		try {
			conn = (Connection) DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select time from accident_case_set where year(time)=? and month(time)=? order by time asc");
			prep.setString(1, year);
			prep.setString(2, month);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				Date time = rst.getDate("time");
				cl.setTime(time);
				dayList.add(cl.get(Calendar.DAY_OF_MONTH));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		Collections.sort(dayList);
		return dayList;
	}
}
