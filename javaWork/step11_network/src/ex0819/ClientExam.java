package ex0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
	public ClientExam() {
		try (Socket sc = new Socket("localhost", 9000)) {
			//서버에게 데이터 전송하기
			PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
			pw.println("ㅎㅇ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String msg = br.readLine();
			System.out.println(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ClientExam();
	}

}
