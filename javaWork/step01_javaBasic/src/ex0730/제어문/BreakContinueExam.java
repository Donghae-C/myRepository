package ex0730.제어문;

public class BreakContinueExam {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				//if(j==3) break;
				//if(j==3) continue;
				
				if(j==3) break;
				System.out.print(j+"\t");
			}
			System.out.println();
		}

	}

}
