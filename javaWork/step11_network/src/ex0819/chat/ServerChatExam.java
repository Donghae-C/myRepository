package ex0819.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
	Socket sc;
	public ServerChatExam() {
		try (ServerSocket server = new ServerSocket(9000)) {
			System.out.println("클라이언트 접속 대기중");
			sc = server.accept();
			System.out.println(sc.getInetAddress() + " 입장");
			//읽기 스레드
			ServerReceiveThread receiveThread = new ServerReceiveThread();
			receiveThread.start();
			//전송 스레드
			Thread sendThread = new SendThread(sc, "서버");
			sendThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ServerReceiveThread extends Thread{

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				while(true) {
					String msg = br.readLine();
					if(msg.equals("exit")) {
						break;
					}
					System.out.println(msg);
					
				}
				System.out.println("서버 받는 스레드 종료");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("ServerReceiveThread에서 예외 발생");
			} finally {
				System.out.println("Server 종료");
				System.exit(0);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new ServerChatExam();
	}
}
