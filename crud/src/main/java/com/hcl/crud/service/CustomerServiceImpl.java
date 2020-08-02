package com.hcl.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hcl.crud.dto.CustomerRequest;
import com.hcl.crud.exception.CustomerNotFoundException;
import com.hcl.crud.model.Customer;
import com.hcl.crud.repository.CustomerRepository;
import com.hcl.crud.response.CustomerListResponse;
import com.hcl.crud.response.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();

		BeanUtils.copyProperties(customerRequest, customer);

		customerRepository.save(customer);

		return new CustomerResponse("Customer Successfully Registered ", 787);
	}

	public CustomerResponse customerLogin(String emailId, String password) {

		Optional<Customer> customer = customerRepository.findByCustomerEmailIdAndPassword(emailId, password);
		/*
		 * if (!customer.isPresent()) { throw new CustomerNotFoundException(2l); }
		 */
		CustomerResponse customerResponse = new CustomerResponse(
				"login successful,welcome  " + customer.get().getCustomerName(), 7997);

		return customerResponse;
	}

	public CustomerListResponse getCustomers(Integer pageSize, Integer pageNumber) {

		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Direction.ASC, "customerId");

		List<Customer> customers = customerRepository.findAll(pageRequest).getContent();

		return new CustomerListResponse(customers.size(), customers, 887);
	}

	public CustomerListResponse getCustomerByCustomerAddress(String customerAddress) {

		PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.ASC, "customerId");

		List<Customer> customers = customerRepository.findByCustomerAddress(customerAddress, pageRequest);

		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(8l);
		}

		return new CustomerListResponse(customers.size(), customers, 876);
	}

	public CustomerResponse updateCustomers(Long customerId, CustomerRequest customerRequest) {

		Optional<Customer> cu = customerRepository.findById(customerId).map(cust -> {

			String address = customerRequest.getCustomerAddress();

			/*
			 * if (StringUtils.isEmpty(address)) { throw new CustomerNotFoundException(8l);
			 * }
			 */

			cust.setCustomerAddress(customerRequest.getCustomerAddress());
			return customerRepository.save(cust);
		});

		return new CustomerResponse("asd", 8);
	}

}
