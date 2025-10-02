package ex0806.overriding.goods;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Goods [code=").append(code).append(", name=").append(name)
		.append(", price=").append(price).append(", explain=").append(explain).append("]");
		return sb.toString();
	}
	
	
}