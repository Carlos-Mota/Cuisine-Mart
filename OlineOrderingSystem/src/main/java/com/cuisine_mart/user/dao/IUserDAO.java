package com.cuisine_mart.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.user.domain.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Long> {
	@Query("from User u where u.username like CONCAT('%',:keyword,'%') ")
	List<User> findAllUserByKeyword(@Param("keyword") String keyword);
}
