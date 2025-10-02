package ex0814;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {
	public ObjectLoadExam() {
		//객체가 저장된 파일을 복원
		try (
		 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ex0814/test20.txt"))) {
			List<Student> list = (List<Student>)ois.readObject();
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectLoadExam();

	}

}
