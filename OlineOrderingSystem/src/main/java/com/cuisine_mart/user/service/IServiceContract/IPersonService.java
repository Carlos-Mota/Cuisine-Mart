package com.cuisine_mart.user.service.IServiceContract;

import org.springframework.stereotype.Service;

import com.cuisine_mart.user.domain.Person;
/**
 * @author Sadiksha
 *
 */
@Service
public interface IPersonService {
	public Person create(Person person);
	public void update(Person person);
	public void delete(int personId);
}
