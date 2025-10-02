package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Service {
	
	void saveInfoFile(String name,double weight,String pw) {
		try (
				FileOutputStream fos = new FileOutputStream("src/cal/"+name+".txt");
				Writer wri = new OutputStreamWriter(fos);
				
				){
			
			String combine = weight+":"+pw;
			wri.write(combine);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void loadInfoFile(String name ) {
		try (
				Reader fis = new InputStreamReader(new FileInputStream("src/cal/"+name+".txt"));
				BufferedReader reader = new BufferedReader(fis);	
				){
			System.out.println();
			String line = reader.readLine();
			String[] data = line.split(":");
			System.out.println(name+"님 몸무게는"+data[0]+"kg 이고 비번은"+data[1]+" 입니다.");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(name+"회원의 정보가 없습니다 다시 입력해주세요");
		}
		
	}
	

}
