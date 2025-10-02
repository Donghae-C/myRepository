package ex0807.abstract_final;

//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{
 final int i = -999999; 
}


abstract class AbstractClassExam{
    abstract String abstractMethodExam(int i,String s);    

	/* final */int finalMethodExam(int i, int j){ 
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	int finalMethodExam(int i, int j){ // final 메서드 재정의 불가
		return i*j;
	}
	
}

class Sample02/* extends FinalClassExam */{  } //fianl 클래스 상속 불가


 
 class Sample03 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){ //일단 이름 중복.
		return s+i;
	 }
		/* abstract String abstractMethodExam(int i,String s); */    //abstract가 아닌 class에 abstract가 정의되어있음

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		AbstractClassExam ace = new Sample01();/* new AbstractClassExam();*/ //abstract 클래스 생성불가
		FinalClassExam fce = new FinalClassExam();
		/* fce.i=100000; */ //final 변수 재할당 불가.
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
