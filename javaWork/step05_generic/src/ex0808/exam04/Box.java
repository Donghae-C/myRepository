package ex0808.exam04;

/**
 * 
 * <T>는 제네릭 타입으로 아직 결정되지 않은 타입을 선언하고
 * 실제로 사용할 때 구체적인 타입으로 변환한다.
 */
public class Box<T> {
	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
	public <A,B> T test01(A a, B b) {
		
		return null;
	}
	
}
