package ex0829.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ex0829.db.dto.Emp;
import ex0829.db.util.DbManager;

public class EmpDAO {
	/**
	 * 사원의 이름 검색하기
	 */
	
	public void getSelectName() {
		//로드 연결 실행 닫기
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select ename from emp";
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String str = rs.getString("ename");
				System.out.println(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.releaseConnection(con, st, rs);
		}
		
	}
	
	public void getNameNumberHiredate() {
		//로드 연결 실행 닫기
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select ename, empno, hiredate from emp";
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String ename = rs.getString("ename");
				int empno = rs.getInt("empno");
				String hiredate = rs.getString("hiredate");
				System.out.println(ename + "\t" + empno + "\t" + hiredate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.releaseConnection(con, st, rs);
		}
	}
	
	/**
	 * 사원 등록하기
	 */
	public void insert(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into emp(empno, ename, job, hiredate) values(?,?,?,now())";
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.releaseConnection(con, ps);
		}
	}
}
