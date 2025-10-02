package ex0814;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BufferedFileCopyExam {

	public BufferedFileCopyExam(String readFile, String writeFile) {
		long startTime = System.nanoTime();
		BufferedInputStream fis = null;
		BufferedOutputStream fos = null;
		try {

			fis = new BufferedInputStream(new FileInputStream(readFile));
			fos = new BufferedOutputStream(new FileOutputStream(writeFile));

			int i = 0;
			while ((i = fis.read()) != -1) {
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
		new BufferedFileCopyExam(readFile, writeFile);

	}

}
