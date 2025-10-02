package ex0806.inheritance;

class CarCenter{
	public void engineer(Car cd){
		System.out.println("cd주소 = " + cd);
		
		if(cd instanceof EfSonata) {
			EfSonata ef2 = (EfSonata)cd;
			System.out.println(ef2.a);
		}
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		System.out.println("----------------------------");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		
		Car c= new Car();
		
		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
		
		System.out.println("ef주소 = " + ef);
		System.out.println("ef.a = " + ef.a);
		
		cc.engineer(ef);
		
		
	
	}
}
