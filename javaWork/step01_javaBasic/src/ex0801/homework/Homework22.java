package ex0801.homework;

import java.util.Arrays;

/**
 * 08/01
 * 최동해
 * 실습예제 22슬라이드 로또번호 추출
 */
public class Homework22 {
	int[] lotto = new int[6];
	int len = lotto.length;
	int cnt;
	
	public boolean isDuplication(int temp) {
		boolean result = true;
		for(int j=0; j<len; j++){
            if(lotto[j]==temp){
                result = false;
            }
        }
		return result;
	}
	
    public static void main(String[] args) {
        Homework22 h22 = new Homework22();
        for (int i=0; i<h22.cnt; i++){
            while(true){
                int temp = (int)(Math.random()*45)+1;
                if(h22.isDuplication(temp)){
                    h22.lotto[i] = temp;
                    break;
                }
            }
        }

        for (int i=0; i<h22.len-1; i++){
            for(int j=0; j<h22.len-1-i; j++){
                if(h22.lotto[j] < h22.lotto[j+1]){
                    int temp = h22.lotto[j];
                    h22.lotto[j] = h22.lotto[j+1];
                    h22.lotto[j+1] = temp;
                }
            }
        }

        for (int i=0; i<h22.len; i++){
            System.out.print(h22.lotto[i] + " ");
        }
    }
}
