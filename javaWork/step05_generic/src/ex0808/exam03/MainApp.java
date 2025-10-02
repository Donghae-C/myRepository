package ex0808.exam03;

public class MainApp {

	public static void main(String[] args) {
		Rentable<Home> agency1 = new HomeAgency<>();
		Home home = agency1.rent();
		home.room();
	}

}
