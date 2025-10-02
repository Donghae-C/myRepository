package ex0829.db.view;

import ex0829.db.dao.EmpDAO;
import ex0829.db.dto.Emp;

public class MainView {

	public static void main(String[] args) {
		System.out.println("--1 사원 이름 검색--");
		EmpDAO dao = new EmpDAO();
		dao.getSelectName();
		
		dao.getNameNumberHiredate();
		Emp test1 = new Emp(9020, "test", "testjob", null);
		dao.insert(test1);
	}

}
