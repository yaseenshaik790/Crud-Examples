package com.hcl.crud.service;

import com.hcl.crud.dto.CustomerRequest;
import com.hcl.crud.response.CustomerListResponse;
import com.hcl.crud.response.CustomerResponse;


public interface CustomerService {

	CustomerResponse customerLogin(String emailId, String password);

	CustomerResponse saveCustomer(CustomerRequest customerRequest);

	CustomerListResponse getCustomers(Integer pageSize, Integer pageNumber);

	CustomerListResponse getCustomerByCustomerAddress(String customerAddress);

	CustomerResponse updateCustomers(Long customerId, CustomerRequest customerRequest);

}
