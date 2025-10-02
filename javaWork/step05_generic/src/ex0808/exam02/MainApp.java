package ex0808.exam02;

import java.util.HashMap;
import java.util.Map;

public class MainApp {
	public static void main(String[] args) {
		Product<Tv, String> p1 = new Product<>();
		p1.setKind(new Tv());
		p1.setModel("medel1");
		
		Tv tv1 = p1.getKind();
		
		Product<Audio, Integer> p2 = new Product<>();
		p2.setKind(new Audio());
		p2.setModel(1234);
		
		Audio ad1 = p2.getKind();
		Integer ad1mo = p2.getModel();
		
	}

}
