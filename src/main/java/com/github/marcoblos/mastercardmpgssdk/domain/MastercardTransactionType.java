package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardTransactionType {

	AUTHORIZATION("Authorization"),
	AUTHORIZATION_UPDATE("Authorization Update"),
	CAPTURE("Capture"),
	PAYMENT("Payment (Purchase)"),
	REFUND("Refund"),
	REFUND_REQUEST("Refund Request"),
	VERIFICATION("Verification"),
	VOID_AUTHORIZATION("Void Authorization"),
	VOID_CAPTURE("Void Capture"),
	VOID_PAYMENT("Void Payment"),
	VOID_REFUND("Void Refund");

	private String code;
	private String messageKey;

	MastercardTransactionType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
