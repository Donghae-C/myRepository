package com.ws03.service;
import java.util.List;

import com.exception.BalanceLackException;
import com.exception.UserAccountNotFoundException;
import com.ws03.dto.AccountDto;
import com.ws03.dto.UserDto;

public interface BankService {
	/**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	public List<AccountDto> getAccountList(int userSeq);
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	public UserDto getUserDetail(int userSeq);
	
	/**
	 * 모든 계좌 목록 리턴
	 * @return
	 */
	public List<AccountDto> getAccountList();
	
	
	/**
	 * 잔고 기준으로 계좌목록 리턴
	 * @return
	 */
	public List<AccountDto> getAccountListSortByBalance();
	
	/**
	 * 유저번호 기준으로 계좌목록 리턴
	 * @return
	 */
	public List<AccountDto> getAccountListSortByUserSeq();
	
	AccountDto getUserAccount(int userSeq, int accountSeq) 
             throws UserAccountNotFoundException;
	
	int withdraw(int userSeq, int accountSeq, int amount) 
            throws BalanceLackException,  UserAccountNotFoundException;

}
