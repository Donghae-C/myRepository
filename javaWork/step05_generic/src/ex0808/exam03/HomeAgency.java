package ex0808.exam03;

public class HomeAgency<T> implements Rentable<T>{
	T content;
	@Override
	public T rent() {
		return null;
	}
	
	public T rent(T a) {
		this.content = a;
		return this.content;
	}
	
}
