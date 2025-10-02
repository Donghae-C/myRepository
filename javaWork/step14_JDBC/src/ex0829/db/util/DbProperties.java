package ex0829.db.util;

/**
 * DB의 설정 정보를 상수로 관리
 */
public interface DbProperties {
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/mytest";
	String USER_ID = "dh";
	String USER_PASS = "0000";
}
