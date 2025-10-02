package ex0806.overriding;

class ObjectExam{
	String str;
	public ObjectExam(){   }
	public ObjectExam(String str){
		this.str = str;
	}
	@Override
	public String toString() {
		if(this.str != null) {
			return str + super.toString();
		}
		return "졸립다" + super.toString();
	}
	
}
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam();
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//
			System.out.println(s01);//
			System.out.println(s02);//
			System.out.println(s03);//
			System.out.println(oe1.toString());//
			System.out.println(oe2);//
			"".equals(oe2);
			oe1.equals(oe2);
			
	}
}
