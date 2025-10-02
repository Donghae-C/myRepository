package ex0808.shopingmall;

public class UnderAgeException extends Exception{
	/**
	 * 자꾸 노란줄 띄워서 만들었음
	 */
	private static final long serialVersionUID = 1L;
	
	static int count;
	
	public UnderAgeException() {
		super("애들은 가라");
		count++;
	}
	public UnderAgeException(String s) {
		super(s);
		count++;
	}
}
