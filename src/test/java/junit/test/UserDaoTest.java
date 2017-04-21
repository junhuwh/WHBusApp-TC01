//package junit.test;
//
//import java.util.Date;
//
//import org.junit.Test;
//
//import com.ibm.wuhan.bus.dao.UserDao;
//import com.ibm.wuhan.bus.dao.impl.UserDaoImpl;
//import com.ibm.wuhan.bus.domain.User;
//
//public class UserDaoTest {
//
//	@Test
//	public void testAdd() {
//		User user = new User();
//
//		user.setBirthday(new Date());
//		user.setEmail("test@cc.com");
//		user.setId("12343214");
//		user.setNickname("吃饭");
//		user.setPassword("123");
//		user.setUsername("ccc");
//		
//		UserDao dao = new UserDaoImpl();
//		dao.add(user);
//		
//	}
//	
//	@Test
//	public void testFind(){
//		UserDao  dao = new UserDaoImpl();
//		dao.find("aaa","123");
//	}
//	
//	@Test
//	public void testFindByUsername(){
//		UserDao dao = new UserDaoImpl();
//		System.out.println(dao.find("test"));
//	}
//}
