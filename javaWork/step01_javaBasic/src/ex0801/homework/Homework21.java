package ex0801.homework;

/**
 * 08/01
 * 최동해
 * 실습예제 21슬라이드 배열 정렬(선택, 버블, 삽입)
 */

public class Homework21 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,1,2,4,3,8,9,6,10};
        selectionSort(arr);
        insertionSort(arr);
        bubbleSort(arr);
    }
    //선택정렬
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j]<arr[minIndex]) {
                    minIndex=j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        for(int i=0;i<len;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //삽입 정렬
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i=1; i<len; i++){
            int temp = arr[i];
            int location = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    arr[j+1]=arr[j];
                }else {
                    location = j+1;
                    break;
                }
            }
            arr[location]=temp;
        }
        for(int i=0;i<len;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //버블 정렬
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<len;i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
