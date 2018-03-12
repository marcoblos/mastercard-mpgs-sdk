package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardUpdateStatusType {

	FAILURE("The last attempt to place data into the session was unsuccessful. The session may contain invalid data. A request operation using this session will be rejected by the payment gateway"),
	NO_UPDATE("No attempt has been made to place data into the session. A request operation using this session will be rejected by the payment gateway"),
	SUCCESS("The last attempt to update the session was successful. You may submit a request operation using this session");

	private String code;
	private String messageKey;

	MastercardUpdateStatusType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
