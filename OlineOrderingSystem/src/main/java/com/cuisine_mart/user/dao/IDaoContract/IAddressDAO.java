package com.cuisine_mart.user.dao.IDaoContract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.user.domain.Address;
/**
 * @author Sadiksha
 *
 */
@Repository
public interface IAddressDAO extends JpaRepository<Address, Long>{

}
