package ex0814.homework.exception;

/**
 * 모델 번호 중복되었을때 나갈 예외
 */
public class DuplicateNameException extends Exception {
	
	public DuplicateNameException() {
		
	}
	public DuplicateNameException(String message) {
		super(message);
	}
}
