package com.cuisine_mart.user.service.IServiceContract;

import org.springframework.stereotype.Service;

import com.cuisine_mart.user.domain.Person;

@Service
public interface IPersonService {
	void create(Person person);
}