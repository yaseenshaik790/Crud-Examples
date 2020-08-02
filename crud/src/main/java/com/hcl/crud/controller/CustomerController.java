package com.hcl.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.crud.dto.CustomerRequest;
import com.hcl.crud.response.CustomerListResponse;
import com.hcl.crud.response.CustomerResponse;
import com.hcl.crud.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * 
	 * @param emailId
	 * @param password
	 * @return login successful message
	 */
	@PutMapping("/login")
	public ResponseEntity<CustomerResponse> customerLogin(@RequestParam String emailId,
			@RequestParam String password) {

		logger.info("user login");

		return new ResponseEntity<>(customerService.customerLogin(emailId.trim(), password.trim()), HttpStatus.OK);
	}

	/**
	 * 
	 * @param customerRequest
	 * @return registration success message with status code
	 */
	@PostMapping
	public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody CustomerRequest customerRequest) {

		logger.info("Customer registration");

		CustomerResponse customerResponse = customerService.saveCustomer(customerRequest);

		return new ResponseEntity<>(customerResponse, HttpStatus.OK);
	}

	/**
	 * 
	 * @param customerId
	 * @param customerRequest
	 * @return successfully updates message with status code
	 */
	@PostMapping("/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomers(@PathVariable("customerId") Long customerId,
			@RequestBody CustomerRequest customerRequest) {

		logger.info("update customer details");

		CustomerResponse CustomerResponse = customerService.updateCustomers(customerId, customerRequest);

		return new ResponseEntity<>(CustomerResponse, HttpStatus.OK);
	}

	/**
	 * 
	 * @param customerAddress
	 * @return customer details of specific address
	 */

	@GetMapping("/{customerAddress}")
	public ResponseEntity<CustomerListResponse> getCustomerByCustomerAddress(
			@PathVariable("customerAddress") String customerAddress) {

		logger.info("Customer registration");

		CustomerListResponse customerListResponse = customerService
				.getCustomerByCustomerAddress(customerAddress.trim());

		return new ResponseEntity<>(customerListResponse, HttpStatus.OK);
	}

	/**
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @return get customer details
	 */
	@GetMapping("")
	public ResponseEntity<CustomerListResponse> getCustomers(@RequestParam Integer pageSize,
			@RequestParam Integer pageNumber) {

		logger.info("Fetching customer details");

		CustomerListResponse customerListResponse = customerService.getCustomers(pageSize, pageNumber);

		return new ResponseEntity<>(customerListResponse, HttpStatus.OK);
	}

}
