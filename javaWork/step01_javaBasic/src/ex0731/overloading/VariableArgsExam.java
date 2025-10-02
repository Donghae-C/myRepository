package ex0731.overloading;

public class VariableArgsExam {
	
	public void test(Object ... i) {
		/*
		 * for(int a = 0; a < i.length; a++) { System.out.print(i[a]+", "); }
		 */
		for(Object num : i) {
			System.out.print(num+", ");
		}
		System.out.println();
		System.out.println("---------------");
	}

	public static void main(String[] args) {
		VariableArgsExam va = new VariableArgsExam();
		va.test(10);
		va.test(20, 30);
		va.test("sa", 10, 2.5, 'a');
	}

}
