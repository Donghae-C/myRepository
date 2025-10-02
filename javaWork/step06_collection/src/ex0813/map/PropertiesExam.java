package ex0813.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class PropertiesExam {
	Properties pro = new Properties();

	public PropertiesExam() {
		pro.setProperty("name", "test1");
		pro.setProperty("age", "33");
		pro.setProperty("addr", "testAddr");

		System.out.println(pro);

		for (String key : pro.stringPropertyNames()) {
			String value = pro.getProperty(key);
			System.out.println(key + " = " + value);
		}
	}

	/**
	 * 외부의 *.properties파일을 로딩하는 방법 2가지 1) IO를 이용한 방법 2) ResourceBundle 이용하는 방법
	 */
	public void test01() {
		pro.clear();
		try {
			// 1. 파일의 위치의 기준 프로젝트가 기준!-경로설정할때 src기준...
			InputStream inputStream = new FileInputStream("bin/dbInfo.properties");
			//pro.load(inputStream);
			
			
			// 2. 클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
			inputStream = PropertiesExam.class.getResourceAsStream("../../dbInfo.properties");
			pro.load(inputStream);

			// 3.클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
			//InputStream inpupStream = this.getClass().getResourceAsStream("dbInfo.properties");
			//pro.load(inpupStream);

			// 4.ClassLoader의 모든 경로에서 파일 읽음. 보통 resources 폴더의 파일 읽을때 사용.
			//inpupStream =
					// this.getClass().getClassLoader().getResourceAsStream("a.properties");
					//this.getClass().getClassLoader().getResourceAsStream("ex0729/map/dbInfo.properties");
			//pro.load(inpupStream);

			// 5. ClassLoader의 Class내에 파일존재하는 경우
			/*
			 * InputStream inpupStream =
			 * this.getClass().getClassLoader().getResourceAsStream(
			 * "ex0726/list/b.properties"); // 경로에 '/' 붙지않음. ClassLoader의 모든 경로에서 파일 읽음.
			 * pro.load(inpupStream);
			 */

			//pro.load(new FileInputStream("/ex0813/map/a.properties"));

			
			 for (String key : pro.stringPropertyNames()) { 
				 String value =	pro.getProperty(key); System.out.println(key + " = " + value);
				 }
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test02() {
		System.out.println("---------test02입니다.--------");
		ResourceBundle rb = ResourceBundle.getBundle("dbInfo");
		/*
		 * Enumeration<String> keys = rb.getKeys(); while(keys.hasMoreElements()) {
		 * String key = keys.nextElement(); System.out.println(key); }
		 */
		
		Set<String> keySet = rb.keySet();
		Set<String> keys = new TreeSet<>(keySet);
		for(String key : keys) {
			System.out.println(key + " = " + rb.getString(key));
		}
		
	}

	public static void main(String[] args) {
		PropertiesExam pe = new PropertiesExam();
		System.out.println("----------------------------");
		pe.test01();
		//pe.test02();
	}
}
