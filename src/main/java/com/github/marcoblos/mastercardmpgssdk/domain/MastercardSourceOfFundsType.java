package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardSourceOfFundsType {

	ACH("Automated Clearing House"),
	CARD("Credit or Debit card"),
	GIFT_CARD("Gift card");

	private String code;
	private String messageKey;

	MastercardSourceOfFundsType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
