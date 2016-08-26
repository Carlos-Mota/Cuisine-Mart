package com.cuisine_mart.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
