package ex0819.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 클라이언트와 멀티채팅을 위한 server
 */
public class ServerGUIChatExam {
	Socket sk;
	List<ClientSocketThread> list = new ArrayList<>();
	public ServerGUIChatExam() {
		try (ServerSocket server = new ServerSocket(8000)) {
			while (true) {
				System.out.println("client 접속 대기중");
				sk = server.accept();
				System.out.println(sk.getInetAddress() + "님 접속");
				
				ClientSocketThread th = new ClientSocketThread();
				list.add(th);
				th.start();
				
				System.out.println("현재 접속 인원 (" + list.size() + ")\n" );
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	/**
	 * 접속된 모든 클라이언트에게 데이터를 전송하는 메서드
	 */
	private void sendMessage(String msg){
		for(ClientSocketThread c : list) {
			c.pw.println(msg);
		}
	}
	
	

	class ClientSocketThread extends Thread {
		PrintWriter pw;
		BufferedReader br;
		String nickName;

		public ClientSocketThread() {
			try {
				pw = new PrintWriter(sk.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				nickName = br.readLine();
				//접속되어 있는 모든 client에게 알림
				sendMessage(nickName + "님 입장");
				while(true) {
					String msg = br.readLine();
					sendMessage(nickName + ":\t" + msg);
				}
			} catch (IOException e) {
				//현재 Thread를 list에서 제거
				list.remove(this);
				//남아있는 모든 클라이언트에게 알림
				sendMessage(nickName + "님 퇴장");
				System.out.println(nickName + "님 퇴장 ||" + "현재 접속 인원 (" + list.size() + ")\n" );
			}
		}

	}

	public static void main(String[] args) {
		new ServerGUIChatExam();

	}

}
