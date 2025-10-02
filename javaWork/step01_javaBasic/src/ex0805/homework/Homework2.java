package ex0805.homework;
/**
 * 08/05
 * 최동해
 * 6장 확인문제 15번
 * Service 클래스 메소드 선언
 */
class MemberService{
	public boolean login(String id, String password) {
		if("hong".equals(id) && "12345".equals(password)) {
			return true;
		}
		return false;
	}
	public void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다.");
	}
}
public class Homework2 {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
