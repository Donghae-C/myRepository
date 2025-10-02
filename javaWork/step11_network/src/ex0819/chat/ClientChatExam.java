package ex0819.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	public ClientChatExam() {
		try  {
			// 읽기 스레드
			Socket sk = new Socket("localhost", 9000);
			Thread receiveThread = new Thread(() -> {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
					while (true) {
						String msg = br.readLine();
						if (msg.equals("exit")) {
							break;
						}
						System.out.println(msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			receiveThread.start();

			// 전송 스레드
			SendThread sendThread = new SendThread(sk, "Client");
			sendThread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientChatExam();

	}

}
