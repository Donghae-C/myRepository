package ex0819;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public ServerExam() {
		try (ServerSocket server = new ServerSocket(9000)) {
			while(true) {
				System.out.println("클라이언트 접속 대기중");
				//접속한 클라이언트로부터 전송된 데이터 읽기;
				Socket sc = server.accept();
				//접속자//
				System.out.println(sc.getInetAddress());
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String msg = br.readLine();
				System.out.println(msg);
				//접속한 클라이언트에게 데이터 전송(출력)
				PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);
				pw.println("테스트중");
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerExam();

	}

}
