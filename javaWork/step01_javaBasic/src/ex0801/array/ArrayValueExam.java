package ex0801.array;


class ArrayValue{
	//정수형 10개 저장하는 배열선언(선언과 동시에 임의값 지정)
	int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};

   /*printArrayvalue 메소드작성
       => 메소드 안에서 위에 선언된 배열방의 값을 출력한다.
	*/			
	public void printArrayvalue() {
		int len = arr.length;
		for(int i=0;i<len;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

/////////////////////////////////////////////////
class ArrayValueExam{
	public static void main(String args []){
        ArrayValue arrValue = new ArrayValue();
        arrValue.printArrayvalue();

	}
}