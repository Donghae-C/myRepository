package ex0801.homework;
/**
 * 08/01
 * 최동해
 * 5장 확인문제 7번
 */

public class Homework07 {

	public static void main(String[] args) {
		int[] array = {1,5,3,8,2};
		int len = array.length;
		int tem = 0;
		for(int i=0;i<len-1;i++) {
			for(int j=0;j<len-1-i;j++) {
				if(array[j]>array[j+1]) {
					tem = array[j];
					array[j] = array[j+1];
					array[j+1] = tem;
				}
			}
		}
		System.out.println(array[array.length-1]);
	}

}
