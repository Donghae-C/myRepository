package lamda.methodRef;

import java.util.function.Function;

class StringUtils { 
    public int getLength(String str) { //생성해서 접근하는 메소드
        return str.length(); 
    } 
} 
 ////////////////////////////
public class InstanceMethodReference02 { 
    public static void main(String[] args) { 
        StringUtils utils = new StringUtils(); 
         
        //기존방식
        Function<String, Integer> beforeLength = new Function<String, Integer>() {
			@Override
			public Integer apply(String str) {
				return utils.getLength(str);
			}
		};
		
		//1. 람다식으로 변경해보자
		Function<String, Integer> lambdaLength = x -> utils.getLength(x);
		
		//2.인스턴스 메소드 참조로 변경해보자.
		Function<String, Integer> methodLength = utils::getLength;
      
 
        //3. 호출해보자
    } 
} 





