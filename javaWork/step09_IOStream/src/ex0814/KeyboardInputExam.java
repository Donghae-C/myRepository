package ex0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardInputExam {
	public KeyboardInputExam() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		) {
			String line = br.readLine();
			System.out.println(line);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new KeyboardInputExam();

	}

}
