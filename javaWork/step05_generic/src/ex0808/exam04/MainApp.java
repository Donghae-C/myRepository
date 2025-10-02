package ex0808.exam04;

public class MainApp {

	public static void main(String[] args) {
		MainApp m = new MainApp();
		m.test01("안녕", 10);
		
		m.test01(new Box<String>(), "hi");
		
		Box<String> box = m.test02("String");
	}
	
	// 제네릭 메소드 작성
	public <A,B> void test01(A a, B b){
		System.out.println(a);
		System.out.println(b);
	}
	
	public <A,T> T test02(A a) {
		Box<String> box = new Box<>();
		return (T) box;
	}

}
