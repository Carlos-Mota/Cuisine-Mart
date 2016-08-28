package com.cuisine_mart.user.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisine_mart.user.dao.IDaoContract.IUserDAO;
import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.service.IServiceContract.IUserService;
/**
 * @author Sadiksha
 *
 */
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserDAO userDAO;

	@Override
	public boolean authenticateUser(User user) {
		
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userDAO.findAll();
	}

	@Override
	public User findUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return userDAO.findOne((long) userId);
	}

	@Override
	public void deleteUser(int userId) {
		userDAO.delete((long)userId);
		
	}

	@Override
	public List<User> searchUserByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return userDAO.findAllUserByKeyword(keyword);
	}

	@Override
	public void signup(User user) {
		userDAO.save(user);
		
	}

}
