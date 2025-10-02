package web.mvc.service;

import java.sql.SQLException;

import web.mvc.dao.UserDAO;
import web.mvc.dao.UserDAOImpl;
import web.mvc.dto.UserDTO;
import web.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
	UserDAO userDao = new UserDAOImpl();
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		UserDTO loginCheck = userDao.loginCheck(userDTO);
		if(loginCheck == null) {
			throw new AuthenticationException("해당하는 유저가 없음");
		}
		
		return loginCheck;
	}

}
