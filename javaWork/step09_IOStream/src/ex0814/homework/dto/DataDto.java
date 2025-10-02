package ex0814.homework.dto;

import java.io.Serializable;

public class DataDto implements Serializable {
	private String name;
	private int weight;
	private String pwd;
	public DataDto() {

	}
	public DataDto(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public DataDto(String name, int weight, String pwd) {
		super();
		this.name = name;
		this.weight = weight;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(" | ").append(weight).append(" | ").append(pwd);
		return builder.toString();
	}
	
	
	
}
