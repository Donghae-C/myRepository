package ex0801.array;
/**
 * 객체의 속성을 관리하는 클래스
 * VO(Value Object)
 * Dto(Data transfer Object)
 * Domain
 */
public class Student {
	/**
	 * 멤버필드를 외부로부터 보호하기 위해 은닉(private)
	 * 반드시 외부에서 데이터를 사용할 수 있도록
	 * setXxx, getXxx를 제공한다.
	 */
	private String name;
	private int age;
	private String address;
	public Student() {
	}
	
	public Student(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	/**
	 * setXxx() 메소드 작성법
	 *   -데이터 변경
	 *   :제한자 - public
	 *   :리턴타입 - void
	 *   :메소드이름 - set필드이름() - 필드 이름의 첫글자는 대문자(setName())
	 *   :매개변수 - 변경할 변수의 타입
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		if(age>18) {
			this.age = age;	
		}
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * getXxx() 메소드 작성법
	 *   -데이터 조회
	 *   :제한자 - public
	 *   :리턴타입 - 있음. get할 변수의 타입
	 *   :메소드이름 - get필드이름() - 필드 이름의 첫글자는 대문자(getName())
	 *   :매개변수 - 없음
	 */
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getAddress() {
		return address;
	}
	
}
