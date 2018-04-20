package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-03-12
 *
 */
@Getter
public enum MastercardRequestType {

	TRANSACTION("Transaction Request"),
	ORDER("Order Request"),
	SESSION("Session Request");

	private String code;
	private String messageKey;

	MastercardRequestType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
