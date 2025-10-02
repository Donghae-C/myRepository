package ex0808.exam05;

/**
 * 신청 - 누가 신청을 하느냐?
 */
public class Applicant<T> {
	private T kind;

	public Applicant(T kind) {
		this.kind = kind;
	}

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}
}	
