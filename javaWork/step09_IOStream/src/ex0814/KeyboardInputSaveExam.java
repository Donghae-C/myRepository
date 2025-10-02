package ex0814;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class KeyboardInputSaveExam {
	public KeyboardInputSaveExam() {
		//키보드 입력을 exit를 만날때 까지 받는다.
		//입력된 내용을 파일에 저장한다.
		try (
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				FileOutputStream fos = new FileOutputStream("src/ex0814/test11.txt");) {
			while(true) {
				String line = br.readLine();
				if(line.equals("exit")) {
					break;
				}
				byte[] bytes = line.getBytes();
				fos.write(bytes);
				fos.write(13);
			}
			fos.flush();
		} catch (IOException e) {
			
			
		}
		
	}
	public static void main(String[] args) {
		new KeyboardInputSaveExam();

	}

}
