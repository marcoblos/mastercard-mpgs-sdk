package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-03-22
 *
 */
@Getter
public enum MastercardURLParametersType {

	ORDER_REFERENCE("Order reference/Order id"),
	SESSION_ID("Session id"),
	TRANSACTION_REFERENCE("Transaction reference");

	private String code;
	private String messageKey;

	MastercardURLParametersType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
