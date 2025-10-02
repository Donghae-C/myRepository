package ex0811.set;

import java.util.TreeSet;

public class LottoSetTest extends TreeSet<Integer>{
	
	public LottoSetTest() {
		super((o1, o2) -> o1 - o2);
		System.out.println(this.size());
		while(this.size() < 6) {
			int number = (int)(Math.random()*45)+1;
			System.out.println(number);
			boolean b = this.add(number);
			System.out.println(b);
		}
		System.out.println(this);
	}
	
	public static void main(String[] args) {
		new LottoSetTest();

	}

}
