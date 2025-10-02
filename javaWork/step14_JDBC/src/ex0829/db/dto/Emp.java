package ex0829.db.dto;

public class Emp {
	private int empNo;
	private String ename;
	private String job;
	private int sal;
	private String hireDate;
	
	

	public Emp() {
		
	}

	public Emp(int empNo, String ename, String job, int sal, String hireDate) {
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.hireDate = hireDate;
	}
	

	public Emp(int empNo, String ename, String job, String hireDate) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.hireDate = hireDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	
}
