package ex0814.homework.service;

import java.io.*;

import ex0814.homework.dto.DataDto;
import ex0814.homework.exception.DuplicateNameException;
import ex0814.homework.exception.IncorrectPasswordException;
import ex0814.homework.exception.MyException;
import ex0814.homework.exception.SearchNotFoundException;

public class WeightServiceImpl implements WeightService {
	private static final WeightService instance = new WeightServiceImpl();
	private static final String SAVE_PATH = "src/ex0814/homework/data/";
	
	private WeightServiceImpl() {
		
	};
	
	public static WeightService getInstance() {
		return instance;
	}
	
	@Override
	public void insert(DataDto data) throws DuplicateNameException, MyException{
		makeDir();
		File save = new File(SAVE_PATH + data.getName() + ".txt");
        try {
            loadFile(data);
			throw new DuplicateNameException("이미 등록된 이름입니다.");
        } catch (SearchNotFoundException e) {
			saveFile(data, save);
        }

    }

	@Override
	public DataDto searchByName(DataDto data) throws SearchNotFoundException, IncorrectPasswordException, MyException{
		DataDto loaded = loadFile(data);
		if(!isCorrectPassword(data, loaded)){
			throw new IncorrectPasswordException("비밀번호가 틀림");
		}
		return loaded;
	}

	@Override
	public void updateWeight(DataDto data) throws SearchNotFoundException, IncorrectPasswordException, MyException {
        DataDto loaded = loadFile(data);
		loaded.setWeight(data.getWeight());
		File save = new File(SAVE_PATH + loaded.getName() + ".txt");
		saveFile(loaded, save);
    }

	@Override
	public void updatePwd(DataDto data) throws SearchNotFoundException, IncorrectPasswordException, MyException {
        DataDto loaded = loadFile(data);
		loaded.setPwd(data.getPwd());
		File save = new File(SAVE_PATH + loaded.getName() + ".txt");
		saveFile(loaded, save);
    }
	
	private void saveFile(DataDto data, File save) throws MyException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(save))){
			oos.writeObject(data);
		}catch (IOException e1){
			throw new MyException("데이터를 읽는 중 오류 발생");
		}
	}
	
	private DataDto loadFile(DataDto data) throws SearchNotFoundException, MyException {
		DataDto loaded;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH + data.getName() + ".txt"))) {
			 loaded = (DataDto)ois.readObject();
		} catch (FileNotFoundException e) {
			throw new SearchNotFoundException("찾는 사람 이름이 없음");
		} catch (IOException | ClassNotFoundException e) {
			throw new MyException("파일을 읽는 중 오류 발생");
		}
		return loaded;
	}

	private boolean isCorrectPassword(DataDto data, DataDto loaded) throws IncorrectPasswordException {
		return data.getPwd().equals(loaded.getPwd());
	}

	private void makeDir(){
		File file = new File(SAVE_PATH);
		if(!file.exists()){
			file.mkdirs();
		}
	}
}
