package com.ws03.service;
/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

import java.util.ArrayList;
import java.util.List;

import com.ws03.dto.AccountDto;
import com.ws03.dto.InstallAccountDto;
import com.ws03.dto.LoanAccountDto;
import com.ws03.dto.SavingAccountDto;
import com.ws03.dto.UserDto;

public class BankService {
	//final은 고정값= 값변경불가 (반드시 초기화 필수)
	final int ACCOUNT_SIZE = 10; /**계좌 최대개수*/
	final int USER_SIZE = 5;/**고객 최대개수 */
	
	int ACCOUNT_CURRENT_SIZE; //0 /** 현재계좌의 개수 */
	int USER_CURRENT_SIZE; //0 /**현재 고객의 개수 */
	
	List<UserDto> userList;//null-> 주소값
	List<AccountDto> accountList; //null
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankService() {
		userList = new ArrayList<UserDto>();
		accountList = new ArrayList<AccountDto>();

		userList.add(new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false));
		userList.add(new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true));
		userList.add(new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false));

		accountList.add(new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000));

		accountList.add(new SavingAccountDto(10, "00100101001001", 500, 111, 100));

		accountList.add(new LoanAccountDto(60, "00600606006006", 500, 333, "House"));
		accountList.add(new LoanAccountDto(30, "00300303003003", 0, 111, "Building"));

		accountList.add(new SavingAccountDto(70, "00700707007007", 500, 333, 200));

		accountList.add(new LoanAccountDto(50, "00500505005005", 200, 222, "Car"));
		accountList.add(new SavingAccountDto(40, "00400404004004", 1000, 222, 50));
	}
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public List<AccountDto> getAccountList(int userSeq) { // 100 200  ... 
		//위에서 찾은 정보를 바탕으로  AccountDto배열에서 계좌정보를 찾아서  리턴해준다.
		//찾은 고객의 계좌의 수만큼 배열을 생성해서 그 배열을 리턴
		
		List<AccountDto> searchAccountDtoList = new ArrayList<>();
		
		for(AccountDto a : accountList) {
			if(a.getUserSeq() == userSeq) {
				searchAccountDtoList.add(a);
			}
		}
		return searchAccountDtoList;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq) {
		for(UserDto u :userList) {
			if(u.getUserSeq() == userSeq) {
				//찾았다.
				return u;
			}
		}
		return null;
	}
	
	
	/**
	 * 모든 계좌 목록 리턴
	 * @return
	 */
	public List<AccountDto> getAccountList(){
		return accountList;
	}
	
	
	/**
	 * 잔고 기준으로 계좌목록 리턴
	 * @return
	 */
	public List<AccountDto> getAccountListSortByBalance(){
		List<AccountDto> resultList = new ArrayList<>(accountList);
		resultList.sort((o1, o2) -> o1.getBalance() - o2.getBalance());
		return resultList;
	}
	
	public List<AccountDto> getAccountListSortByUserSeq(){
		List<AccountDto> resultList = new ArrayList<>(accountList);
		resultList.sort((o1, o2) -> o1.getUserSeq() - o2.getUserSeq());
		return resultList;
	}

}










