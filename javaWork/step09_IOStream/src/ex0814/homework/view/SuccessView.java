package ex0814.homework.view;

import java.util.List;

import ex0814.homework.dto.DataDto;

/**
 * 사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스 
 */

public class SuccessView {

    /**
     * 전달된 data 출력
     *
     */


    public static void printSearchByName(DataDto data) {
        System.out.println("*******************************************************");
        System.out.println("현재 " + data.getName() + "의 몸무게는 " + data.getWeight() + "Kg 입니다.");
        System.out.println("*******************************************************");
    }

    public static void printChangePwd(DataDto data) {
        System.out.println("*******************************************************");
        System.out.println("현재 " + data.getName() + "의 비밀번호는 " + data.getPwd() + "입니다.");
        System.out.println("*******************************************************");
    }

    /**
     * 성공에 관련된 메세지 출력 
     * @param message
     */
    public static void printMessage(String message) {
         System.out.println(message+"\n");
    }
}
