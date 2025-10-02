package ex0811.lamda;

public class LamdaExam {

	public static void main(String[] args) {
		// 기존방식
		/**
		 * aa인터페이스 구현한 Test객체 부름
		 */
		/*
		 * Test test = new Test(); test.aa();
		 */
		
		
		
		// AnonymousInnerType 으로 작성
		/*
		 * AInterface test2 = new AInterface() {
		 * 
		 * @Override public void aa() { System.out.println("익명클래스 생성"); } }; test2.aa();
		 */
		
		
		
		// 람다식
		AInterface a = () -> System.out.println("aafsef");
		a.aa();
		
		
		BInterface b = (x) -> System.out.println("인수는 " + x);
		b.bb(5);
		
		/*
		 * CInterface c = (x, y) -> x + y;
		 * 
		 * int cc = c.cc(5, 10); System.out.println(cc);
		 */
		
		int[] array = new int[]{1,2,3,4,5};
		CInterface c = (s)->{
			int result = 0;
			for(int re : s) {
				result += re;
			}
			return result;
		};
		
		System.out.println(c.cc(1,2,3,4));
		
		
	}

}

class Test implements AInterface{

	@Override
	public void aa() {
		System.out.println("aa()임");	
	}
	
}
