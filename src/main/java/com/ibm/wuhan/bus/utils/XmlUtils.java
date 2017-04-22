package com.ibm.wuhan.bus.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	// 通过类装载器得到文件位置 然后通过读写文件方式操作

	private static String filepath;
	private static String filepath2;

	static {

		try {

			// filepath = System.getProperty("/WEB-INF/users.xml");
			filepath2 = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
			// filepath= filepath.replaceAll("%20", " ");
			filepath = XmlUtils.class.getClassLoader().getResource("/").getPath();
			filepath = filepath + "users.xml";
			filepath= filepath.replaceAll("%20", " ");

			//filepath = ".\\users.xml";
			 System.out.println(filepath);
			 System.out.println(filepath2);

			// System.out.println(System.getProperty("user.dir"));

			// System.out.println(application.getRealPath("/WEB-INF/users.xml"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static Document getDocument() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));

		return document;

	}

	public static void write2Xml(Document document) throws IOException {

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format);
		writer.write(document);
		writer.close();

	}
}
