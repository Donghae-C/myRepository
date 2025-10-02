package ex0818;

public class InterruptedExam02 {

	public static void main(String[] args) {
		System.out.println("****메인 시작****");

		Thread th1 = new Thread(() -> {

			while (true) {
				if(Thread.interrupted()) {
					break;
				}
				System.out.println("곧 집에감");
			}
		});

		th1.start();
		try {
			th1.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th1.interrupt(); // Exception이 발생하려면 잠시라도 일시정지 상태가 되어야 한다.

		System.out.println("****메인 끝****");
	}

}
