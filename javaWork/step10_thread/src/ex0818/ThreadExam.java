package ex0818;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("***메인 시작******");
		NumberThread nt1 = new NumberThread("첫번째 thread");
		NumberThread nt2 = new NumberThread("두번째 thread");
		Thread nt3 = new Thread(new CharThread(), "세번째 thread");
		Thread nt4 = new Thread(()->{
			Thread th = Thread.currentThread();
			for(int i=0;i<100;i++) {
				System.out.println(i + th.getName());
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Thread.yield();
			}
			System.out.println(th.getName() + "종료");
		}, "네번째 thread");
//		nt1.run();
//		nt2.run();
//		nt3.run();
		
		nt1.start();
		//nt2.start();
		//nt3.start();
		nt4.start();
		
//		try {
//			nt1.join(); //메인메소드가 join()메소드를 호출
//		} catch (InterruptedException e) { 
//			e.printStackTrace();
//		}
		
		Thread.yield();
		
		System.out.println("총합 = " + nt1.sum);
		System.out.println("***메인 끝*******");
		
		
	}

}

///////////////////////////////////////////////////////
/**
 * 1 ~ 100까지 출력하는 thread(상속)
 */
class NumberThread extends Thread{
	int sum=0;
	public NumberThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NumberThread(String name) {
		super(name);
		// TODO Auto-generated constructor s tub
	}

	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println(i + super.getName());
			sum+=i;
//			try {
//				Thread.sleep((long)(Math.random()*200));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			Thread.yield();
		}
		
		System.out.println(super.getName() + " 스레드 종료");
	}
}

/**
 * A ~ Z까지 출력하는 thread(구현)
 */
class CharThread implements Runnable{

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch + th.getName());
//			try {
//				Thread.sleep((long)(Math.random()*400));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(th.getName() + " 스레드 종료");
	}
	
}

