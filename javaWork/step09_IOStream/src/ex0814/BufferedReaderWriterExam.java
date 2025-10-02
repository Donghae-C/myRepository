package ex0814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderWriterExam {

	public BufferedReaderWriterExam() {
		try (// 문자 단위로 파일 읽기 -> Buffered 적용
				BufferedReader br = new BufferedReader(new FileReader("src/ex0814/test4.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0814/test5.txt"));
		) {
//			int i = br.read();
//			System.out.println(i + " = " + (char)i);
			
			while(true) {
				String line = br.readLine();
				if(line==null) break;
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
			
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new BufferedReaderWriterExam();
	}
}
