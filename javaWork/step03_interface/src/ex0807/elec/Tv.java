package ex0807.elec;

public class Tv extends Elec implements ElecFunction{
	private int chnnel;
	
	public Tv() {
	}
	
	public Tv(int chnnel) {
		this.chnnel = chnnel;
	}
	

	public Tv(String code, int cost, int chnnel) {
		super(code, cost);
		this.chnnel = chnnel;
	}

	@Override
	public void start() {
		
		System.out.println(getCode() + "제품 TV를 " + chnnel + " 을 본다." );
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tv [chnnel=").append(chnnel).append("]").append(super.toString());
		return builder.toString();
	}

	

	
	
}
