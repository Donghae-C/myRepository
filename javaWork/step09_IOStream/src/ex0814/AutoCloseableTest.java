package ex0814;

class Test implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("close() 호출 됨");
	}
	
}

public class AutoCloseableTest {
	public static void main(String[] args) {
		System.out.println("--시작--");
		
		try(Test t = new Test();) {
			System.out.println("테스트중");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--끝--");

	}

}
