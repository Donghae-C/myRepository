package ex0801.array;


public class StudentService {
	//학생 5명을 관리하는 배열
	Student [] stArr = new Student[10];
	
	//실제 배열에 저장된 객체의 개수를 체크
	public static int currentCount;
	
	/**
	 * 학생의 정보를 초기화 하는 메소드
	 */
	public void init() {
		/*
		 * System.out.println("stArr = "+stArr); for(int i=0;i<stArr.length;i++) {
		 * System.out.print("생성전 : " + stArr[i] + "\t"); stArr[i] = new Student();
		 * System.out.print("생성후 : " + stArr[i] + "\t");
		 * stArr[i].setAge((int)(Math.random()*30)+1); System.out.println("이름 : " +
		 * stArr[i].getName() + "\t나이 : " + stArr[i].getAge()); }
		 */
		stArr[currentCount++]  = create("ㅇㅇ", 20, "여기");
		stArr[currentCount++]  = create("ㄱㄱ", 25, "저기");
		stArr[currentCount++]  = create("ㅁㅁ", 20, "거기");
		stArr[currentCount++]  = create("ㅂㅂ", 20, "고기");
		stArr[currentCount++]  = create("ㅈㅈ", 20, "ㅁㅁ");
	}
	
	private Student create(String name, int age, String addr) {
		Student st = new Student();
		st.setName(name);
		st.setAge(age);
		st.setAddress(addr);
		return st;
	}
	
	/**
	 * 모든 학생의 정보를 조회하는 메소드
	 */
	
	public Student[] getSelectAll() {
		return stArr;
	}
	
	/**
	 * 학생 이름으로 한명 조회하는 메소드
	 */
	public Student getSelectOne(String str) {
		return null;
	}
	
	public int getCurrentCont() {
		return this.currentCount;
	}
}
