package ex0811.set;

public class Member {
	private String name;
	private int age;
	private String addr;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String name, int age, String addr) {
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
	
	
	
	@Override
	public int hashCode() {
		System.out.println("hash");
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if(obj instanceof Member m) {
			if(this.name.equals(m.getName()) && age == m.getAge()){
				System.out.println(age);
				System.out.println(m.getAge());
				return true;	
			}
			
		}
		
		return false;
	}
	
	
	
	
	
	
}
