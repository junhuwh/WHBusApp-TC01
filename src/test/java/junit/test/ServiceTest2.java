package junit.test;

import java.util.Date;

import org.junit.Test;

import com.ibm.wuhan.bus.dao.UserDao;
import com.ibm.wuhan.bus.dao.impl.UserDaoImpl;
import com.ibm.wuhan.bus.domain.User;
import com.ibm.wuhan.bus.exception.UserExistExcepiton;
import com.ibm.wuhan.bus.service.impl.BusinessServiceImpl;

public class ServiceTest2 {

	@Test
	public void testRegister() {

		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("test@cc.com");
		user.setId("121221212");
		user.setNickname("111吃饭");
		user.setPassword("123");
		user.setUsername("qq1aq1");

		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("注册成功");
		} catch (UserExistExcepiton e) {
			// TODO Auto-generated catch block

			System.out.println("用户存在");
		}

	}

	@Test
	public void testLogin() {
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login("123", "123");
		System.out.println(user);
	}

}
