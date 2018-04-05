package com.zxf.po;

public class Collierie implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int collierieId;
	private String collierieName;
	private String position;
	private String linkman;
	private String phoneNumber;
	private String tableName;
	
	public Collierie(){}

	public int getCollierieId() {
		return collierieId;
	}
	public void setCollierieId(int collierieId) {
		this.collierieId = collierieId;
	}

	public String getCollierieName() {
		return collierieName;
	}
	public void setCollierieName(String collierieName) {
		this.collierieName = collierieName;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}



	
	
	
}
