package ex0819;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExam {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(9000);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Socket sc = serverSocket.accept();
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			String data = dis.readUTF();
			System.out.println(data);
			DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
			dos.writeUTF(br.readLine());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
