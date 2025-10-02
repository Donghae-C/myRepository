package ex0814.homework.service;

import ex0814.homework.dto.DataDto;
import ex0814.homework.exception.DuplicateNameException;
import ex0814.homework.exception.IncorrectPasswordException;
import ex0814.homework.exception.MyException;
import ex0814.homework.exception.SearchNotFoundException;

public interface WeightService {
	
	
	public void insert(DataDto data) throws DuplicateNameException, MyException;
	
	public DataDto searchByName(DataDto data) throws SearchNotFoundException, IncorrectPasswordException, MyException;
	
	public void updateWeight(DataDto data) throws SearchNotFoundException, IncorrectPasswordException, MyException;
	
	public void updatePwd(DataDto data) throws SearchNotFoundException, IncorrectPasswordException, MyException;
}	
