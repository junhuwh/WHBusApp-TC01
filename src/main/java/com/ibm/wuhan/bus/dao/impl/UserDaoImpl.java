package com.ibm.wuhan.bus.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.ibm.wuhan.bus.dao.UserDao;
import com.ibm.wuhan.bus.domain.User;
import com.ibm.wuhan.bus.utils.XmlUtils;

public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.ibm.wuhan.bus.dao.impl.UserDao#add(com.ibm.wuhan.bus.domain.User)
	 */
	public void add(User user) {

		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();

			Element user_tag = root.addElement("user");

			user_tag.addAttribute("id", user.getId());
			user_tag.addAttribute("username", user.getUsername());
			user_tag.addAttribute("password", user.getPassword());
			user_tag.addAttribute("email", user.getEmail());
			user_tag.addAttribute("birthday", user.getBirthday() == null ? "" : user.getBirthday().toLocaleString());
			user_tag.addAttribute("nickname", user.getNickname());

			XmlUtils.write2Xml(document);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	//查找用户名密码是否匹配
	/* (non-Javadoc)
	 * @see com.ibm.wuhan.bus.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	public User find(String username, String password) {

		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document
					.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']");

			if (e == null) {
				return null;
			}
			User user = new User();
			String date = e.attributeValue("birthday");
			if (date == null || date.equals("")) {
				user.setBirthday(null);
			} else {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(date));
			}

			user.setEmail(e.attributeValue("email"));
			user.setId(e.attributeValue("id"));
			user.setNickname(e.attributeValue("nickname"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			return user;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	// 查找要注册用户是否已经存在
	/* (non-Javadoc)
	 * @see com.ibm.wuhan.bus.dao.impl.UserDao#find(java.lang.String)
	 */
	public boolean find(String username) {
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='" + username + "']");
			if (e == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
