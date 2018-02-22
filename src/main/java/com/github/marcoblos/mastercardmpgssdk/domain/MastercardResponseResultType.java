package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardResponseResultType {

	FAILURE("The operation was declined or rejected by the gateway, acquirer or issuer"),
	PENDING("The operation is currently in progress or pending processing"),
	SUCCESS("The operation was successfully processed"),
	UNKNOWN("The result of the operation is unknown"),
	ERROR("The operation resulted in an error and hence cannot be processed");

	private String code;
	private String messageKey;

	MastercardResponseResultType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
