package ex0808.shopingmall;

public class ShopMain {
	public static void main(String[] args) {
		ShopingMall sm = new ShopingMall();
		
		for(int i=0;i<10;i++) {
			int age = (int)(Math.random()*55)+1;
			try {
				sm.ageChk(age);
			} catch (UnderAgeException e) {
				System.out.println(e.getMessage());
			}	
		}
		
		
		System.out.println(UnderAgeException.count);
	}

}
