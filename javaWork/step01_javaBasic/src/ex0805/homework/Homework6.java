package ex0805.homework;
/**
 * 08/05
 * 최동해
 * 6장 확인문제 19번
 * Account 클래스 작성
 */
class Account{
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance < MIN_BALANCE || balance > MAX_BALANCE) {
			return;
		}
		this.balance = balance;
	}
	
}
public class Homework6 {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance());
	}
}
