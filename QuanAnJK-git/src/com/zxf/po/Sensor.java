package com.zxf.po;

public class Sensor implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sensorId;
	private String sensorNumber;
	private String sensorPosition;
	private String sensorWorkingCondition;
	private String sensorTime;
	private String powerTime;
		
	public Sensor(){}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorNumber() {
		return sensorNumber;
	}

	public void setSensorNumber(String sensorNumber) {
		this.sensorNumber = sensorNumber;
	}

	public String getSensorPosition() {
		return sensorPosition;
	}

	public void setSensorPosition(String sensorPosition) {
		this.sensorPosition = sensorPosition;
	}

	public String getSensorWorkingCondition() {
		return sensorWorkingCondition;
	}

	public void setSensorWorkingCondition(String sensorWorkingCondition) {
		this.sensorWorkingCondition = sensorWorkingCondition;
	}

	public String getSensorTime() {
		return sensorTime;
	}

	public void setSensorTime(String sensorTime) {
		this.sensorTime = sensorTime;
	}

	public String getPowerTime() {
		return powerTime;
	}

	public void setPowerTime(String powerTime) {
		this.powerTime = powerTime;
	}

	

	
	
	
}
