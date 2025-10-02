package ex0818;

public class DaemonThreadExam03 {

	public static void main(String[] args) {
		System.out.println("****메인 시작****");

		Thread th1 = new Thread(() -> {

			while (true) {
				System.out.println("곧 집에감");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		th1.setDaemon(true); //메인 스레드가 종료될때 th1 스레드도 함께 종료됨.
		
		th1.start();
		try {
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("****메인 끝****");
	}

}
