package ex0808.shopingmall;

public class ShopingMall {
	public void ageChk(int age) throws UnderAgeException{
		if(age<18) {
			System.out.println("18세 미만");
			throw new UnderAgeException();
		}else {
			System.out.println("18세 이상");
		}
	}
}
