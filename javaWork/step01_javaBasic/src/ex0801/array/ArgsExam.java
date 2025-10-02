package ex0801.array;

public class ArgsExam {
	public static void main(String[] args) {
		System.out.println("--메인 시작--");
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);
		if(args.length > 0) {
			for(int i=0;i<args.length;i++) {
				System.out.println("args["+"i"+"]"+args[i]);
			}
			
			for(String str : args) {
				System.out.println(str);
			}
		}
		System.out.println("-------------------------------");
		
		//인수로 두수를 전달 받는다는 가정하에 두 수의 합을 구한다.
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));

	}

}
