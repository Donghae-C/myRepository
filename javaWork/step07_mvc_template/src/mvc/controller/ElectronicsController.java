package mvc.controller;

import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;



/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
	 private ElectronicsService service = ElectronicsServiceImpl.getInstance();

    /**
     * 전체검색
     */
    public void selectAll() {
		List<Electronics> list = service.selectAll();
		for(Electronics e : list) {
			System.out.println(e);
		}
    }
 

	 /**
     * 전자제품 등록 
     */
   
    public void insert(Electronics electronics) {
       try {
		service.insert(electronics);
		SuccessView.printMessage(electronics.getModelNo() + "등록 완료");
	   } catch (ElectronicsArrayBoundsException e) {
		FailView.errorMessage(e.getMessage());
		
	   } catch (DuplicateModelNoException e) {
		FailView.errorMessage(e.getMessage());
		
	   }
       
    }
    
    

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
    	try {
			Electronics electronics = service.searchByModelNo(modelNo);
			//SuccessView.printMessage(electronics.toString());
			SuccessView.printSearchByModelNo(electronics);
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
			
		}
    	
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
    	try {
			service.update(electronics);
			SuccessView.printMessage(electronics.getModelNo() + "수정완료");
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
			
		}
    }
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기 
     * @param electronics
     */
	public void deleteModelNo(int modelNo) {
		try {
			service.delete(modelNo);
			SuccessView.printMessage(modelNo + "삭제완료");
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public void selectSortByPrice() {
    	List<Electronics> selectSortByPrice = service.selectSortByPrice();
    	SuccessView.printAll(selectSortByPrice);
    }
    
    /**
     * 이름을 기준으로 정렬하기
     * 이름이 같다면 가격으로 정렬한다.
     */
    public void selectSortByName() {
    	List<Electronics> selectSortByName = service.selectSortByName();
    	SuccessView.printAll(selectSortByName);
    }
    
    public void selectUnderPrice(int price){
    	try {
			SuccessView.printAll(service.selectUnderPrice(price));
		} catch (SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
    } 
}











