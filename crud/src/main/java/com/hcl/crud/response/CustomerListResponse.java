package com.hcl.crud.response;

import java.util.List;

import com.hcl.crud.model.Customer;

public class CustomerListResponse {

	private Integer sizeOfCustomersList;

	private List<Customer> costomers;

	private Integer STATUS_CODE;

	public CustomerListResponse(Integer sizeOfCustomersList, List<Customer> costomers, Integer sTATUS_CODE) {
		super();
		this.sizeOfCustomersList = sizeOfCustomersList;
		this.costomers = costomers;
		STATUS_CODE = sTATUS_CODE;
	}

	public Integer getSTATUS_CODE() {
		return STATUS_CODE;
	}

	public void setSTATUS_CODE(Integer sTATUS_CODE) {
		STATUS_CODE = sTATUS_CODE;
	}

	public Integer getSizeOfCustomersList() {
		return sizeOfCustomersList;
	}

	public void setSizeOfCustomersList(Integer sizeOfCustomersList) {
		this.sizeOfCustomersList = sizeOfCustomersList;
	}

	public List<Customer> getCostomers() {
		return costomers;
	}

	public void setCostomers(List<Customer> costomers) {
		this.costomers = costomers;
	}

}
