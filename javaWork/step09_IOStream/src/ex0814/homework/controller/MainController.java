package ex0814.homework.controller;

import ex0814.homework.dto.DataDto;
import ex0814.homework.exception.DuplicateNameException;
import ex0814.homework.exception.IncorrectPasswordException;
import ex0814.homework.exception.MyException;
import ex0814.homework.exception.SearchNotFoundException;
import ex0814.homework.service.WeightService;
import ex0814.homework.service.WeightServiceImpl;
import ex0814.homework.view.FailView;
import ex0814.homework.view.SuccessView;

public class MainController {
	WeightService service = WeightServiceImpl.getInstance();
	
	public boolean searchByName(DataDto data, int style) {
		try {
			DataDto searchByName = service.searchByName(data);
			if(style == 0){
				SuccessView.printSearchByName(searchByName);
			}else {
				SuccessView.printChangePwd(searchByName);
			}

		} catch (SearchNotFoundException | MyException e) {
			FailView.errorMessage(e.getMessage());
		} catch (IncorrectPasswordException e) {
			FailView.errorMessage(e.getMessage());
			return false;
		}
		return true;
	}
	
	public void insert(DataDto data) {
		try {
			service.insert(data);
			SuccessView.printMessage(data.getName() + "저장 성공");
		} catch (DuplicateNameException e) {
			FailView.errorMessage(e.getMessage());
		} catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

	public void updateWeight(DataDto data) {
        try {
            service.updateWeight(data);
			SuccessView.printMessage(data.getName() + "몸무게 변경 성공");
        } catch (SearchNotFoundException | IncorrectPasswordException | MyException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

	public void updatePwd(DataDto data) {
		try {
            service.updatePwd(data);
			SuccessView.printMessage(data.getName() + "비밀번호 변경 성공");
        } catch (SearchNotFoundException | IncorrectPasswordException | MyException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
