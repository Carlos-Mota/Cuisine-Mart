package com.cuisine_mart.user.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisine_mart.user.dao.IDaoContract.IPersonDAO;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;
/**
 * @author Sadiksha
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements IPersonService {

	@Autowired
	IPersonDAO personDAO;
	
	
	@Override
	public Person create(Person person) {
		
		return personDAO.save(person);
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IPersonService#update(com.cuisine_mart.user.domain.Person)
	 */
	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cuisine_mart.user.service.IServiceContract.IPersonService#delete(int)
	 */
	@Override
	public void delete(Long personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findPersonById(Long personId) {
		 return personDAO.findPersonById(personId);
	}

	@Override
	public Person findPersonByEmail(String email) {
		return personDAO.findPersonByEmail(email);
	}




}
