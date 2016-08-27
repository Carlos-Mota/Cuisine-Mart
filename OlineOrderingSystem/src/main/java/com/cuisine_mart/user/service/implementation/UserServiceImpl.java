package com.cuisine_mart.user.service.implementation;

import java.util.List;

import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.service.IServiceContract.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public boolean authenticateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> searchUserByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
