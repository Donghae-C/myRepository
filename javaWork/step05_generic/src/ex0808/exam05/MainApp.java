package ex0808.exam05;

public class MainApp {

	public static void main(String[] args) {
		Course c = new Course();
		c.register01(new Applicant<Person>(new Person()));
		c.register01(new Applicant<Worker>(new Worker()));
		c.register01(new Applicant<Student>(new Student()));
		c.register01(new Applicant<MiddleStudent>(new MiddleStudent()));
		c.register01(new Applicant<HighStudent>(new HighStudent()));
		
		System.out.println("--------------------------------");
		
		c.register02(new Applicant<Person>(new Person()));
		c.register02(new Applicant<Worker>(new Worker()));
		//c.register02(new Applicant<Student>(new Student()));
		//c.register02(new Applicant<MiddleStudent>(new MiddleStudent()));
		//c.register02(new Applicant<HighStudent>(new HighStudent()));
		
		System.out.println("--------------------------------");
		
		//c.register03(new Applicant<Person>(new Person()));
		//c.register03(new Applicant<Worker>(new Worker()));
		c.register03(new Applicant<Student>(new Student()));
		c.register03(new Applicant<MiddleStudent>(new MiddleStudent()));
		c.register03(new Applicant<HighStudent>(new HighStudent()));
	}

}
