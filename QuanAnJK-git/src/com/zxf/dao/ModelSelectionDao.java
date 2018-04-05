package com.zxf.dao;

import java.util.HashMap;
import java.util.Map;

public class ModelSelectionDao {
	//带螺母的防松锁，编号1
	Map<String,Double> lmMap;
	//带喇叭嘴的防松锁，编号2
	Map<String,Double> lbMap;

	//带压线板的防松锁，编号3
	Map<String,Double> yxMap;
	
	public ModelSelectionDao(){
		lmMap = new HashMap<String, Double>();
		lmMap.put("FSS-26",29.0);
		lmMap.put("FSS-32",35.0);
		lmMap.put("FSS-36",39.0);
		lmMap.put("FSS-42",45.0);
		lmMap.put("FSS-46",49.0);
		lmMap.put("FSS-50",53.0);
		
		lbMap = new HashMap<String, Double>();
		lbMap.put("FSS-36C", 39.0);
		lbMap.put("FSS-42C", 45.0);
		lbMap.put("FSS-46C", 49.0);
		lbMap.put("FSS-50C", 53.0);
		
		yxMap = new HashMap<String, Double>();
		yxMap.put("FSS-50C01", 53.0);
	}
	
	//查找合适的防松锁型号
	public String findSize(int flag, Double baseSize){
		String resultStr = "";
		switch (flag) {
		case 1:
			//带螺母防松锁
			resultStr = compareSize(baseSize, lmMap);
			break;
		case 2:
			//带喇叭嘴防松锁
			resultStr = compareSize(baseSize, lbMap);
			break;
		case 3:
			//带压线板防松锁
			resultStr = compareSize(baseSize, yxMap);
			break;
		default:
			break;
		}
		
		return resultStr;
	}
	
	public String compareSize(Double baseSize, Map<String,Double> map){
		String rst = "";
		Double size;
		for(String s : map.keySet()){
			size = map.get(s);
			if (baseSize<= size &&  size <= baseSize + 5.0) {
		        rst = rst + s + "  ";
		      }
		}
		if(rst.length()==0){
			rst = "暂无您需要的防松锁型号";
		}else{
			rst = "您查找的防松锁型号为："+rst;
		}
		return rst;
	}

}
