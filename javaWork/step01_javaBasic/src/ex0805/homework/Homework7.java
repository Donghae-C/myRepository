package ex0805.homework;

import java.util.Scanner;

/**
 * 08/05
 * 최동해
 * 6장 확인문제 19번
 * 계좌관리 프로그램
 */
class Account2{
	private String account;
	private String name;
	private int balance;
	
	public Account2() {
		
	}
	public Account2(String account, String name, int balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
	}
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}


public class Homework7 {
	public static void main(String[] args) {
		Account2[] accArr = new Account2[100];
		int accCount = 0;
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while(menu != 5) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택>");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				System.out.println("------");
				System.out.println("계좌생성");
				System.out.println("------");
				System.out.print("계좌번호: ");
				String account = sc.nextLine();
				System.out.print("계좌주: ");
				String name = sc.nextLine();
				System.out.println("초기입금액: ");
				int deposit = Integer.parseInt(sc.nextLine());
				accArr[accCount++] = new Account2(account, name, deposit);
				System.out.println("결과: 계좌가 생성되었습니다.");
			}else if(menu == 2) {
				System.out.println("------");
				System.out.println("계좌목록");
				System.out.println("------");
				for(int i=0;i<accCount;i++) {
					System.out.println(accArr[i].getAccount() + "\t" + accArr[i].getName() + "\t" + accArr[i].getBalance());
				}
			}else if(menu == 3) {
				System.out.println("------");
				System.out.println("예금");
				System.out.println("------");
				System.out.println("계좌번호:");
				String account = sc.nextLine();
				boolean result = false;
				for(int i=0;i<accCount;i++) {
					if(accArr[i].getAccount().equals(account)) {
						System.out.println("예금액: ");
						int deposit = Integer.parseInt(sc.nextLine());
						int temp = accArr[i].getBalance();
						accArr[i].setBalance(deposit+temp);
						result = true;
					}
				}
				if(!result) {
					System.out.println("계좌번호가 없습니다.");
				}
			}else if(menu == 4) {
				System.out.println("------");
				System.out.println("출금");
				System.out.println("------");
				System.out.println("계좌번호:");
				String account = sc.nextLine();
				boolean result = false;
				for(int i=0;i<accCount;i++) {
					if(accArr[i].getAccount().equals(account)) {
						System.out.println("출금액: ");
						int deposit = Integer.parseInt(sc.nextLine());
						int temp = accArr[i].getBalance();
						accArr[i].setBalance(temp-deposit);
						result = true;
					}
				}
				if(!result) {
					System.out.println("계좌번호가 없습니다.");
				}
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
}
