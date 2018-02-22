package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardValidationType {

	INVALID("The request contained a field with a value that did not pass validation"),
	MISSING("The request was missing a mandatory field"),
	UNSUPPORTED("The request contained a field that is unsupported");

	private String code;
	private String messageKey;

	MastercardValidationType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
