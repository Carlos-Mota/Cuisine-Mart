package com.cuisine_mart.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.user.domain.Person;

@Repository
public interface IPersonDAO extends JpaRepository<Person, Long>{

}
