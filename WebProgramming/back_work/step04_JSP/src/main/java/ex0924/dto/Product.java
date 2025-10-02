package ex0924.dto;

public class Product {
	private String code;
	private String name;
	private int qty;
	private int price;
	public Product() {
		code = "A01";
		name = "새우깡";
		qty = 5;
		price = 2500;
		System.out.println("Product constructor call...");
	}
	public Product(String code, String name, int qty, int price) {
		super();
		this.code = code;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public String getCode() {
		System.out.println("getCode() call...");
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		System.out.println("getName() call...");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		System.out.println("getQty() call...");
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		System.out.println("getPrice() call...");
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
