package ex0805.final_field;

public class FinalFieldExam {
	private int i;
	private final int j;
	static final int k;
	
	static {
		k=200;
	}
	
	public FinalFieldExam() {
		this.j=0;
	}
	
	public FinalFieldExam(int a) {
		this.j = a;
	}
	
	
	
	public static void main(String[] args) {
		FinalFieldExam f1 = new FinalFieldExam(100);
		FinalFieldExam f2 = new FinalFieldExam(50);
		
		System.out.println(f1.j);
		System.out.println(f2.j);
		
		f1.i = 40;
		//f1.j = 50; final이라 재할당 불가능. 에러
		
		System.out.println("------------------------");
		System.out.println(FinalFieldExam.k);
		System.out.println(FinalFieldExam.k);
		
	}

}
