package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
public class MastercardAPIRequest implements Serializable {

	private static final long serialVersionUID = -1745215030863649715L;

	private MastercardAPIOperationType apiOperation;

	private MastercardOrder order;

	private MastercardSourceOfFunds sourceOfFunds;

	private MastercardCustomer customer;

	private String userId;

	private MastercardTransaction transaction;

	public MastercardAPIRequest() {
		this.order = new MastercardOrder();
		this.sourceOfFunds = new MastercardSourceOfFunds();
		this.customer = new MastercardCustomer();
		this.transaction = new MastercardTransaction();
	}

}
