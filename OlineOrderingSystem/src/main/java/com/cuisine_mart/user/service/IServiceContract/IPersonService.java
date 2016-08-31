package com.cuisine_mart.user.service.IServiceContract;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.user.domain.Address;
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
	public Person findPersonById(int personId);
}
