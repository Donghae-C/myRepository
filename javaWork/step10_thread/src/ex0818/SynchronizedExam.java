package ex0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("**메인 시작**");
		Bank bank = new Bank();
		CustomerThread st1 = new CustomerThread(bank, "생산자", true);
		CustomerThread st2 = new CustomerThread(bank, "소비자", false);
		st1.start();
		st2.start();

		System.out.println("**메인 끝**");

	}

}

/**
 * 여러 스레드가 공유할 객체
 */
class Bank {
	int balance; // 잔액

	/**
	 * 
	 * @param name  = name은 생산자, or 소비자
	 * @param state = true : 생산, false : 소비
	 * 
	 * 
	 *              제한자 synchronized 는 특정 스레드 synchronized 블럭 안에서 일을 다 마무리 할 때 까지 다른
	 *              스레드가 제어권을 뺏어가지 못하도록 하는 것. synchronized 블럭 안에 있는 스레드가 lock을 가지고
	 *              있다고 하고, 블럭을 빠져 나가면 잠금이 풀린다.
	 */
	public synchronized void balanceChange(String name, boolean state) {
		if (state) {
			if(balance <= 0) {
				System.out.print(name + "==> 현재 잔액 확인 : " + balance);
				balance++;
				System.out.println(name + "==> 증가 후 잔액 확인 : " + balance);	
			}else {
				System.out.println(name + " 스레드 wait()중");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			if(balance > 0) {
				System.out.print(name + "==> 현재 잔액 확인 : " + balance);
				balance--;
				System.out.println(name + "==> 감소 후 잔액 확인 : " + balance);	
			}else {
				System.out.println(name + " 스레드가 wait()함");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		notify();
	}
}

/**
 * 생산 or 소비를 하게 될 스레드
 */
class CustomerThread extends Thread {
	private Bank bank;
	private String name;
	private boolean state;

	public CustomerThread(Bank bank, String name, boolean state) {
		super(name);
		this.bank = bank;
		this.name = name;
		this.state = state;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			bank.balanceChange(name, state);
		}
		System.out.println(super.getName() + " 스레드 종료");
	}

}
