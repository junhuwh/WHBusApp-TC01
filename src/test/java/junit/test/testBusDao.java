package junit.test;

import org.junit.Test;

import com.ibm.wuhan.bus.dao.BusDao;

public class testBusDao {

	
	
	@Test
	public void testFind(){
		BusDao  dao = new BusDao();
		System.out.println(dao.find("1").getBusstopinfo().get("1").getStoptime());
		System.out.println(dao.find("1").toString());
		
	}
	
	
//	@Test
//	public void testFindstops(){
//		BusDao  dao = new BusDao();
//		System.out.println(dao.findstops("1").toString());
//	}
}
