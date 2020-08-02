package com.hcl.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.crud.model.Customer;

@Repository	
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerEmailId(String customerEmailId);

	Optional<Customer> findByCustomerEmailIdAndPassword(String emailId, String password);

	List<Customer> findByCustomerAddress(String customerAddress, Pageable pageRequest);

}
