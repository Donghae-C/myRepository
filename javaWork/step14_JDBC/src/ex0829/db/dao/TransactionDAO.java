package ex0829.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex0829.db.util.DbManager;

public class TransactionDAO {
	/**
	 * 계좌이체 기능 구현
	 */
	public void transfer(String inputAccount, String outputAccount, int money) {
		Connection con = null;
		try {
			con = DbManager.getConnection();
			// autocommit을 해지한다.
			con.setAutoCommit(false);

			int result = withdraw(con, outputAccount, money);
			if (result == 0) {
				throw new SQLException("출금계좌 오류로 이체 실패");
			}

			result = deposit(con, inputAccount, money);
			if (result == 0) {
				throw new SQLException("입금계좌 오류로 이제 실패");
			}

			if (balanceCheck(con, inputAccount)) {
				throw new SQLException("잔액 초과로 이체 불가");
			}
			con.commit();
			System.out.println("계좌이체 성공");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DbManager.releaseConnection(con, null);
		}

	}

	/**
	 * 출금하기 update bank set balance=balane-인출금액 where account = 출금계좌번호
	 */
	public int withdraw(Connection con, String outputAccount, int money) throws SQLException{
		PreparedStatement ps = null;
		String sql = "update bank set balance=balance-? where account = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, outputAccount);
			result = ps.executeUpdate();
		} finally {
			DbManager.releaseConnection(null, ps);
		}
		return result;
	}

	/**
	 * 입금하기 update bank set balance=balance+인출금액 where account =입금계좌번호;
	 */
	public int deposit(Connection con, String inputAccount, int money) throws SQLException{
		String sql = "update bank set balance=balance+? where account =?";
		int result = 0;
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, money);
			ps.setString(2, inputAccount);
			result = ps.executeUpdate();
		}
		
		return result;
	}

	/**
	 * 잔액확인 리턴값이 true 초과 / false 초과 아님. select balance from bank where account='A02'
	 */
	public boolean balanceCheck(Connection con, String inputAccount) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select balance from bank where account=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inputAccount);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int balance = rs.getInt("balance");
				if(balance > 1000) {
					result = true;
				}
			}
			
		} finally {
			DbManager.releaseConnection(null, ps, rs);
		} 
		
		
		
		return result;
	}

	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		System.out.println("--1. 출금계좌 오류----");
		//dao.transfer("A02", "A05",200);//입금, 출금, 금액

		System.out.println("--2. 입금계좌 오류----");
		dao.transfer("A04", "A01",200);//입금, 출금, 금액

		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		//dao.transfer("A02", "A01",700);//입금, 출금, 금액

		System.out.println("--4. 성공----------");
		//dao.transfer("A02", "A01", 100);// 입금, 출금, 금액
	}
}
