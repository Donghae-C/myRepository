package ex0804.array;

public class MultiArrayExam {
	
	int[][] arr = new int [][] {
		{1,2,3,4},
		{1,2,3},
		{1,2,3,4,5,6,7}
	};
	
	public void arrayTest() {
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		int[] arr2 = arr[0];
		System.out.println(arr2);
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[1].length);
		System.out.println(arr[2].length);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		for(int[] test1 : arr) {
			for(int test : test1) {
				System.out.print(test + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new MultiArrayExam().arrayTest();
	}

}
