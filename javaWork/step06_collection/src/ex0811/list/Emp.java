package ex0811.list;

public class Emp{
	private int empno; // 사원번호
	private String ename; // 사원이름
	private int age; // 나이
	private String addr; // 주소
	public Emp() {

	}
	public Emp(int empno, String ename, int age, String addr) {
		this.empno = empno;
		this.ename = ename;
		this.age = age;
		this.addr = addr;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(empno).append(" | ").append(ename).append(" | ").append(age).append(" | ").append(addr);
		return builder.toString();
	}
}
