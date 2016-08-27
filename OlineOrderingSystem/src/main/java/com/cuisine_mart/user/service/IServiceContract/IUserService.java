package com.cuisine_mart.user.service.IServiceContract;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.user.domain.User;

@Service
public interface IUserService {
	
	boolean authenticateUser(User user);
	List<User> getAllUsers();
	User findUserByUserId(int userId);
	void deleteUser(int userId);
	List<User> searchUserByKeyword(String keyword);
	
}
