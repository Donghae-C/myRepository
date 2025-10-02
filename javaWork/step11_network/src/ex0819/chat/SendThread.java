package ex0819.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대측에 데이터를 전송하는 스레드
 */
public class SendThread extends Thread {
	private Socket sk;
	private String name;

	public SendThread() {

	}

	public SendThread(Socket sk, String name) {
		super(name);
		this.sk = sk;
		this.name = name;
	}

	@Override
	public void run() {
		// 키보드 입력 받기
		Scanner sc = new Scanner(System.in);
		try (// 상대측에 전송
				PrintWriter pw = new PrintWriter(sk.getOutputStream(), true)) {
			while(true) {
				String msg = sc.nextLine();
				if(msg.equals("exit")) {// 내가 exit를 입력하면 while문 나감
					pw.println(msg);
					break;
				}
				pw.println(name+" 보낸 내용 : "+msg);
				System.out.println(name + " : " + msg);	
			}
			
			System.out.println(name + "의 보내는 스레드 종료");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(name + "의 sendThread에서 예외 발생");
		} finally {
			System.out.println("모든 프로그램 종료");
			System.exit(0);
		}
	}

}
