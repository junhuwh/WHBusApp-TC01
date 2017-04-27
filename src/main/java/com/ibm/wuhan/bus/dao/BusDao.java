package com.ibm.wuhan.bus.dao;

import java.util.Map;

import com.ibm.wuhan.bus.DB.BUSDB;
import com.ibm.wuhan.bus.domain.BusLineInfo;
import com.ibm.wuhan.bus.domain.BusStopInfo;

public class BusDao {

	public Map getAll(){
		
		return BUSDB.getAll();
		
	}
	
	public BusLineInfo find(String id){
		
		return (BusLineInfo) BUSDB.getAll().get(id);
		
	}
	
	
//	public Map findstop(String id){
//		
//		BusLineInfo theline = find(id);
//		return  theline.getBusstopinfo();
//		
//	}
	
}
