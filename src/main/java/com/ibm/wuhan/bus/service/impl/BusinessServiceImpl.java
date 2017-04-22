package com.ibm.wuhan.bus.service.impl;

import com.ibm.wuhan.bus.dao.UserDao;
import com.ibm.wuhan.bus.dao.impl.UserDaoImpl;
import com.ibm.wuhan.bus.domain.User;
import com.ibm.wuhan.bus.exception.UserExistExcepiton;
import com.ibm.wuhan.bus.utils.ServiceUtils;

//对web层提供所有业务服务
public class BusinessServiceImpl {

	private UserDao dao = new UserDaoImpl(); // 工厂模式 或者 spring 来解耦

	// 对web层提供注册服务
	public void register(User user) throws UserExistExcepiton {

		// 先判断当前要注册的用户是否存在
		boolean b = dao.find(user.getUsername());
		if (b) {
			throw new UserExistExcepiton();// 发现要注册的用户存在 则给web层抛出一个编译时异常
											// 提醒web层处理异常 给用户友好提示
		} else {
			System.out.println("user.getPassword() = " +user.getPassword());
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			System.out.println("user.getPassword() after set md5= " +user.getPassword());

			dao.add(user);

		}
	}

	// 对web层提供登陆服务
	public User login(String username, String password) {
		System.out.println(" login input (password) = " + password);

		password = ServiceUtils.md5(password);
		System.out.println(" ServiceUtils.md5(password) = " + password);

		return dao.find(username, password);
	}

}
