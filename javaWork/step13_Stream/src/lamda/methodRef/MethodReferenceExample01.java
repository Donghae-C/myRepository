package lamda.methodRef; 
import java.util.function.BiFunction;
import java.util.function.Function; 
 
class Utils { 
    public static int square(int x) { 
        return x * x; 
    } 
    
    public static int square(int x, int y) {
    	return x * y;
    }
} 
 ///////////////////////////////////////////////////

 
public class MethodReferenceExample01 { 
    public static void main(String[] args) { 
    	//기존방식
    	Function<Integer, Integer> beforeSquare = new Function<Integer, Integer>() {		
			@Override
			public Integer apply(Integer t) {
				return Utils.square(t);
			}
		};
		
		BiFunction<Integer, Integer, Integer> beforeSquare2 = new BiFunction<Integer, Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return Utils.square(t, u);
			}
		};
		
		//1. 람다식으로 변경해보자
		Function<Integer, Integer> lambdaSquare = x -> Utils.square(x);
		BiFunction<Integer, Integer, Integer> lambdaSquare2 = (x, y) -> Utils.square(x, y);
		Function<Integer, Integer> lambdaSquare3 = x -> Utils.square(x, 5);
    	
    	//2. static 메소드 참조 문법  : 람다식을 더욱 간결
		Function<Integer, Integer> methodSquare = Utils::square;
		BiFunction<Integer, Integer, Integer> methodSquare2 = Utils::square;
   
        //3.호출해보자
		System.out.println(beforeSquare.apply(5));
		System.out.println(beforeSquare2.apply(3, 5));
		System.out.println(lambdaSquare.apply(5));
		System.out.println(methodSquare.apply(5));
		System.out.println(methodSquare2.apply(3, 5));
		
    } 
} 





