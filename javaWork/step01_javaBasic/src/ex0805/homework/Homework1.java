package ex0805.homework;
/**
 * 08/05
 * 최동해
 * 5장 확인문제 8번
 * 배열 합, 평균
 */
public class Homework1 {

	public static void main(String[] args) {
		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum = 0;
		int count = 0;
		int rowLen = array.length;
		for(int i=0;i<rowLen;i++) {
			int colLen = array[i].length;
			for(int j=0;j<colLen;j++) {
				sum += array[i][j];
				count++;
			}
		}
		
		System.out.println("합 : " + sum);
		System.out.println("평균 : " + sum/(double)count);
	}
}
