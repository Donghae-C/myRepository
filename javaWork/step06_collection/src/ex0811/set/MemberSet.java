package ex0811.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSet {
	/**
	 * set은 저장전에 hashCode 호출하고 결과가 다르면 저장.
	 * 만약 같으면 equals() 호출해서 false면 저장
	 * 만약 true면 같다고 판단, 저장하지 않음
	 */
	
	Set<Member> set = new HashSet<>();

	public MemberSet() {
		set.add(new Member("test1", 20, "testaddr1"));
		set.add(new Member("test2", 22, "testaddr2"));
		
		set.add(new Member("test2", 23, "testaddr3"));
		System.out.println("저장된 개수 = " + set.size());
	}



	public static void main(String[] args) {
		new MemberSet();
	}
}
