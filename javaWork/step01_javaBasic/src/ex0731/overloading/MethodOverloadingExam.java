package ex0731.overloading;

//MethodOverloadingExam.java
class OverloadedMethod{
	private int i;
       
	public void setOverload(int i){
		this.i = i;
	}
	
	public int getOverload(){
		return i;
	}
	
	//setOverload를 Overloading하세요. 리턴도 하세요.
	public OverloadedMethod setOverload(double i){
		this.i = (int)i;
		return this;
	}
	
	//setOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public OverloadedMethod setOverload(long i){
		this.i = (int)i;
		return this;
	}
	
	//setOverload를 또 또Overloading 하세요. 리턴 안해요
	public OverloadedMethod setOverload(int i, String str){
		this.i = i;
		System.out.println(str);
		return this;
	}


	//getOverload를 Overloading하세요. 리턴도 하세요.
	public int getOverload(int i){
		System.out.println("?:"+i);
		return this.i;
	}
	//getOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public String getOverload(String str){
		System.out.println("2?:"+str);
		return str;
	}
	//getOverload를 또 또Overloading 하세요. 리턴 안해요
	public Object getOverload(Object obj){
		System.out.println("3?:"+obj);
		return obj;
	}	
	
}

class  MethodOverloadingExam{
       
  public static void main(String [] agr){
     //OverloadedMethod객체에서 호출가능한  메소드들을 한번씩 호출하세요.
	  OverloadedMethod om1 = new OverloadedMethod();
	  om1.setOverload(5.5).setOverload(8l).setOverload(1,"ㅇㅇ").setOverload(20);
	  System.out.println(om1.getOverload());
	  OverloadedMethod om2 = new OverloadedMethod();
	  System.out.println(om2);
	  System.out.println(om2.getOverload());
	  System.out.println(om2.getOverload(new OverloadedMethod()));
	  System.out.println(om2.getOverload("str"));
	  System.out.println(om2.getOverload(10));
	}   


}

