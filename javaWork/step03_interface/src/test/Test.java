package test;

class Tire {
	public void run() {
		System.out.println("test");
	}

}

class SnowTire extends Tire {

	@Override
	public void run() {
		System.out.println("test3");
	}

}

public class Test {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		String a;

		System.out.println(snowTire);
		System.out.println(tire);
		snowTire.run();
		tire.run();
	}

}
