package reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyReader {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Scanner sc = new Scanner(System.in);

	public BufferedReader getBr() {
		return br;
	}

	public Scanner getSc() {
		return sc;
	}
}
