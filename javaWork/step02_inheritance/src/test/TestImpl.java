package test;

public class TestImpl implements Test {

	@Override
	public void testMethod() {
		System.out.println("테스트메서드");
		testMethod2();
	}
	
	private void testMethod2() {
		System.out.println("자식객체에서 새로 만든 프라이빗 메서드");
	}
}
