package ex0729;

public class HelloTest {
	public static void main(String[] args){
		int[] arr = new int[5];
		arr[0] = 3;
		arr[2] = 5;
		
		for(int arrs : arr) {
			System.out.println(arrs);
		}
		System.out.println(arr);
	}
}

class TestHello{
	public static int i;
	public static void staticTest() {
		
	}
	
	public void staticTest2() {
		
	}
}
