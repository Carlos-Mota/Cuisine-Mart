package com.cuisine_mart.user.service.IServiceContract;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.user.domain.User;
/**
 * @author Sadiksha
 *
 */
@Service
public interface IUserService {
	public void saveNewUser(User user);
	public void signup(User user); 
	boolean authenticateUser(User user);
	List<User> getAllUsers();
	User findUserByUserId(int userId);
	void deleteUser(int userId);
	List<User> searchUserByKeyword(String keyword);
	public User getUserByUsername(String username);
	public String verifyUserByEmail(Long userId);
}
