package mvc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    private static final String SAVE_PATH = "src/step10_SaveElec.txt";
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	File saved = new File(SAVE_PATH);
    	if(saved.exists()) {
    		loadFile(saved);
    	}else {
    		System.out.println("파일 없음");
    		ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//dbInfo.properties
            for(String key : rb.keySet()) {
         	  String value =  rb.getString(key);
         	   String data[] = value.split(",");
         	   //System.out.println(key +" = " + value);
         	  
         	     list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
         	    		 Integer.parseInt( data[2]), data[3]) );
         	  
            }
    	}
    	
    	
        
        //System.out.println(list);
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException, DuplicateModelNoException {
		if(list.size() >= MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("최대 크기를 벗어남");
		}
		try {
			searchByModelNo(electronics.getModelNo());
			throw new DuplicateModelNoException("중복된 모델 번호가 있음");
		} catch (SearchNotFoundException e) {
			list.add(electronics);
			saveFile(list);
		}
		
		
	}

	@Override
	public List<Electronics> selectAll() {
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics e : list) {
			if(e.getModelNo() == modelNo) {
				return e;
			}
		}
		throw new SearchNotFoundException("모델 번호가 없음");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics elec = searchByModelNo(electronics.getModelNo());
		if(elec != null) {
			elec.setModelDetail(electronics.getModelDetail());
			saveFile(list);
		}
		
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		Electronics elec = searchByModelNo(modelNo);
		if(elec != null) {
			list.remove(elec);
			saveFile(list);
		}
	}

	@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> sortedList = new ArrayList<>(list);
		sortedList.sort((o1, o2) -> {
			if(o1.getModelPrice() == o2.getModelPrice()) {
				return o1.getModelNo() - o2.getModelNo();
			}else {
				return o1.getModelPrice() - o2.getModelPrice();
			}
		});
		return sortedList;
	}

	@Override
	public List<Electronics> selectSortByName() {
		List<Electronics> sortedList = new ArrayList<>(list);
		sortedList.sort((o1, o2) -> {
			if(o1.getModelName().equals(o2.getModelName())) {
				return o1.getModelPrice() - o2.getModelPrice();
			}else {
				return o1.getModelName().compareTo(o2.getModelName());
			}
		});
		return sortedList;
	}

	@Override
	public List<Electronics> selectUnderPrice(int price) throws SearchNotFoundException{
		List<Electronics> searchedList = new ArrayList<>();
		for(Electronics e : list) {
			if(e.getModelPrice() <= price) {
				searchedList.add(e);
			}
		}
		if(searchedList.isEmpty()) {
			throw new SearchNotFoundException("조건에 맞는 물건이 없습니다.");
		}
		return searchedList;
	}
	
	private void loadFile(File saved) {
		System.out.println("파일 있음");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saved))) {
			list = (List<Electronics>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveFile(List<Electronics> list) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH))) {
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
    
} // 클래스 끝 