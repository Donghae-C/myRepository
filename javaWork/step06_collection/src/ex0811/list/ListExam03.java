package ex0811.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListExam03 {
	private List<Emp> list = new ArrayList<>();
	/**
	 *생성자를 이용해서 사원 5명 데이터 초기화
	 */
	public ListExam03() {
		list.add(new Emp(10, "test1", 20, "서울"));
		list.add(new Emp(12, "test2", 25, "수원"));
		list.add(new Emp(25, "test3", 23, "성남"));
		list.add(new Emp(14, "test4", 30, "성남"));
		list.add(new Emp(13, "test5", 45, "서울"));
	}
	
	
	
	/**
	 * 저장된 모든 사원정보 확인
	 */
	public List<Emp> selectAll() {
		//System.out.println(list);
		return list;
	}
	
	/**
	 * 사원번호에 해당하는 사원정보 리턴
	 */
	public Emp selectByEmpNo(int empNo) throws NoSearchException{
		Emp emp = null;
		for(Emp selected : list) {
			if(selected.getEmpno() == empNo) {
				emp = selected;
			}
		}
		if(emp == null) {
			throw new NoSearchException("사람이 없음");
		}
		return emp;
	}
	
	
	/**
	 * 주소를 인수로 전달받아 동일한 주소인 모든 사원의 정보
	 */
	public List<Emp> selectByAddr(String addr) throws NoSearchException{
		List<Emp> resultList = new ArrayList<>();
		for(Emp selected : list) {
			if(selected.getAddr().equals(addr)) {
				resultList.add(selected);
			}
		}
		if(resultList.isEmpty()) {
			throw new NoSearchException("사람이 없음");
		}
		return resultList;
	}
	
	
	/**
	 * 사원번호를 기준으로 정렬하기
	 */
	public List<Emp> sortByEmpno(List<Emp> list){
		List<Emp> resultList = new ArrayList<>(list);
		//resultList.sort((s1, s2) -> s2.getEmpno() - s1.getEmpno());
		resultList.sort(Comparator.comparing(Emp::getEname));
		resultList.sort((s1,s2) ->{
			int result = s1.getAge() - s2.getAge();
			return result;
		}); 
		
		return resultList;
	}
	
	
	/**
	 * 나이를 시준으로 정렬하기
	 */
	public List<Emp> sortByAge(List<Emp> list){
		List<Emp> resultList = new ArrayList<>(list);
		/*
		 * Collections.sort(resultList, new Comparator<Emp>() {
		 * 
		 * @Override public int compare(Emp o1, Emp o2) {
		 * 
		 * return o1.getAge() - o2.getAge(); } });
		 */
		//Collections.sort(resultList, (s1, s2) -> s1.getAge() - s2.getAge());
		
		Collections.sort(resultList, (s1, s2) -> s1.getAge() - s2.getAge());
		return resultList;
	}
	
	public static void main(String[] args) {
		ListExam03 le3 = new ListExam03();
		System.out.println("1.전체조회");
		List<Emp> selectAll = le3.selectAll();
		print(selectAll);
		System.out.println("2.사원번호에 해당하는 검색");
		try {
			Emp selectByEmpNo = le3.selectByEmpNo(2);
			System.out.println(selectByEmpNo);
		} catch (NoSearchException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("3.주소로 검색");
		try {
			List<Emp> selectByAddr = le3.selectByAddr("성남");
			print(selectByAddr);
		} catch (NoSearchException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("4.사원번호 기준으로 정렬");
		for(Emp e : le3.sortByEmpno(selectAll)) {
			System.out.println(e);
		}
		System.out.println("5.나이를 기준으로 정렬");
		for(Emp e : le3.sortByAge(selectAll)) {
			System.out.println(e);
		}
		Emp e1 = new Emp(13, "test5", 45, "서울");
		Emp e2 = new Emp(13, "test5", 45, "서울");
		System.out.println(e1.equals(e2));
	}
	
	public static void print(List<Emp> list) {
		System.out.println("****사원정보 (" + list.size() + "명)****" );
		for(Emp e : list) {
			System.out.println(e);
		}
	}

}

/*
 * class SortTest implements Comparator<Emp>{
 * 
 * @Override public int compare(Emp o1, Emp o2) { return o1.getAge() -
 * o2.getAge(); }
 * 
 * }
 */
