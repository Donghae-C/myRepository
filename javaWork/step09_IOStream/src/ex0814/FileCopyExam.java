package ex0814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyExam {
	
	public FileCopyExam(String readFile, String writeFile) {
		long startTime = System.nanoTime();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(writeFile);
			
			int i = 0;
			while((i = fis.read()) != -1) {
				fos.write(i);
			}
			fos.flush();
			System.out.println("완료");
		} catch (Exception e) {
			
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
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime);
	}

	public static void main(String[] args) {
		String readFile = JOptionPane.showInputDialog("읽을 파일명?");
		String writeFile = JOptionPane.showInputDialog("저장할 파일명?");
		new FileCopyExam(readFile, writeFile);

	}

}
