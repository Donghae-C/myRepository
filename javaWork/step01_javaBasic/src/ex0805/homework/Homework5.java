package ex0805.homework;
/**
 * 08/05
 * 최동해
 * 6장 확인문제 18번
 * 싱글톤 객체 생성
 */

class ShopService{
	private static ShopService shopService = new ShopService();
	private ShopService() {
		
	}
	public static ShopService getInstance() {
		return shopService;
	}
}
public class Homework5 {
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if(obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		}else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}
	
}
