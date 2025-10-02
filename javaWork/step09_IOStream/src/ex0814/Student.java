package ex0814;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int age;
	private transient String addr;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		builder.append(name).append(" | ").append(age).append(" | ").append(addr);
		return builder.toString();
	}
	
	
}
