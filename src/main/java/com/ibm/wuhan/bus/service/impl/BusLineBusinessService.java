package com.ibm.wuhan.bus.service.impl;

import java.util.Map;

import com.ibm.wuhan.bus.dao.BusDao;
import com.ibm.wuhan.bus.domain.BusLineInfo;

public class BusLineBusinessService {


	private BusDao dao = new BusDao();

	public Map getAllBus() {

		return dao.getAll();
	}

	public BusLineInfo findBus(String id) {
		return dao.find(id);

	}

 
	
}
