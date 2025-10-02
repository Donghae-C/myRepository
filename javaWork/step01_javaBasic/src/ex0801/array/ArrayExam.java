package ex0801.array;

class ArrayExam{
	
	//각int,double,char,boolean ,String type별로 총 5개씩 저장하는  배열을 생성하세요
	int[] arrInt = new int[5];
	double[] arrDouble = new double[5];
	char[] arrChar = new char[5];
	boolean[] arrBoolean = new boolean[5];
	String[] arrString = new String[5];

	//메소드 : printArrayValue01	
	//위의 배열들에 자동으로 초기화 된값을 출력하세요
	public void printArrayValue01() {
		System.out.println(arrInt);
		for(int i=0;i<5;i++) {
			System.out.print(arrInt[i]+" ");
		}
		System.out.println();
		System.out.println(arrDouble);
		for(int i=0;i<5;i++) {
			System.out.print(arrDouble[i]+" ");
		}
		System.out.println();
		System.out.println(arrChar.toString());
		for(int i=0;i<5;i++) {
			System.out.print(arrChar[i]+" ");
		}
		System.out.println();
		System.out.println(arrBoolean);
		for(int i=0;i<5;i++) {
			System.out.print(arrBoolean[i]+" ");
		}
		System.out.println();
		System.out.println(arrString);
		for(int i=0;i<5;i++) {
			System.out.print(arrString[i]+" ");
		}
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println(arrString);
	}
	

	//메소드 : printArrayValue02	
	//위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.
	public void printArrayValue02() {
		for(int i=0;i<5;i++) {
			arrInt[i] = i;
		}
		for(int i=0;i<5;i++) {
			arrDouble[i] = Math.random()*10;
		}
		for(int i=0;i<5;i++) {
			arrChar[i] = (char)(i+67);
			
		}
		for(int i=0;i<5;i++) {
			if(i%2 == 0) {
				arrBoolean[i] = false;
			}else {
				arrBoolean[i] = true;
			}
			
		}
		for(int i=0;i<5;i++) {
			arrString[i] = i + "s";
		}
	}
	
	//메소드 : printArrayValue03	
	//새롭게 할당된값을 출력하세요
	public void printArrayValue03() {
		printArrayValue01();
	}
	//메인메소드에서
	//ArrayExam의 메소드들을 순서대로 호출하세요.
	public static void main(String[] args) {
		ArrayExam ae = new ArrayExam();
		ae.printArrayValue01();
		ae.printArrayValue02();
		ae.printArrayValue03();
	}
	
}