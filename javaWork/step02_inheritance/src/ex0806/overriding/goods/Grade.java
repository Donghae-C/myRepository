package ex0806.overriding.goods;

public enum Grade {
	BASIC(100, "초급"),
	SILVER(200, "중급"),
	GOLD(300, "고급");
	
	private final int code;
	private final String name;
	
	Grade(int code, String name){
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}
