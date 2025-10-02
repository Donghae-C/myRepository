package ex0814;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileInputOutputExam {
	public FileInputOutputExam() {
		//byte단위로 파일 읽기
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("src/ex0814/test.txt");
			
			//바이트 단위로 파일 저장(쓰기)
			fos = new FileOutputStream("src/ex0814/test2.txt");//덮어쓰기
//			int i = 0;
//			while((i=fis.read()) != -1 ) {
//				System.out.print((char)i);
//			}
			
			//byte[] 이용하기
			//읽을 수 있는 byte의 수를 가져오기
			int length = fis.available();
			System.out.println(length);
			byte[] data = new byte[length]; 
			int re = fis.read(data);
			System.out.println(re);
			String convertStr = new String(data);
			System.out.println(convertStr);
			///////////////////////////////////////////////////
			fos.write(65);
			fos.write(10);
			fos.write(65);
			fos.write(13);
			fos.write(65);
			fos.write(65);
			
			String message = "ㅇㅇㅇㅇ";
			byte[] bytes = message.getBytes();
			fos.write(bytes);
			
			fos.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args){
		new FileInputOutputExam();

	}

}
