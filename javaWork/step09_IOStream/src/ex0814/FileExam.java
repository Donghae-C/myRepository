package ex0814;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class FileExam {
	public FileExam() throws IOException{
		String path = JOptionPane.showInputDialog("파일 경로는?");
		System.out.println(path);
		File file = new File(path);
		if(file.exists()) {
			System.out.println(path + "는 있다.");
			if(file.isDirectory()) {
				System.out.println("폴더안의 정보를 확인");
				String[] list = file.list();
				for(String s : list) {
					System.out.println(s);
				}
			}else {
				System.out.println("파일의 정보를 확인");
				System.out.println(file.canRead());
				System.out.println(file.length());
				System.out.println(file.getName());
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getAbsoluteFile());
				
			}
		}else {
			System.out.println("없으니 생성하겠다.");
			file.createNewFile();
		}
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		
	}
	
	public static void main(String[] args) throws IOException {
		new FileExam();
	}

}
