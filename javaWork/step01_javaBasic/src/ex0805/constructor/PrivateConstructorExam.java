package ex0805.constructor;

import java.time.LocalDateTime;

class Test{
	private static Test t = new Test();
	
	private Test(){
		
	}
	
	public static Test getInstance() {
		return t;
	}
	
	
}


public class PrivateConstructorExam {

	public static void main(String[] args) {
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		System.out.println("t1 : " + t1 + "\nt2 : " + t2);
		
		LocalDateTime ldt1 = LocalDateTime.now();
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println("ldt1 : " + ldt1.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(ldt1)));
		System.out.println("ldt2 : " + ldt2.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(ldt2)));
	}

}
