package com.cuisine_mart.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.user.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
