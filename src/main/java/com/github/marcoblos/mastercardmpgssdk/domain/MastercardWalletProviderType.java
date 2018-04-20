package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-03-12
 *
 */
@Getter
public enum MastercardWalletProviderType {

	AMEX_EXPRESS_CHECKOUT("Amex Express Checkout wallet provider"),
	MASTERPASS_ONLINE("MasterPass Online wallet provider"),
	VISA_CHECKOUT("Visa Checkout wallet provider");

	private String code;
	private String messageKey;

	MastercardWalletProviderType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
