package ex0814;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
	public ObjectSaveExam() {
		//객체를 파일에 저장.
		
		Student st1 = new Student("test1", 20, "ㅇㅇ");
		Student st2 = new Student("test2", 23, "ㄹㄹ");
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex0814/test20.txt"))) {
			List<Student> list = List.of(st1,st2);
			oos.writeObject(list);
				
//			oos.writeObject(st1);
//			oos.writeObject(st2);
		} catch (IOException e) {
			
		}
		System.out.println("--저장 완료--");
	}
	public static void main(String[] args) {
		new ObjectSaveExam();
	}

}
