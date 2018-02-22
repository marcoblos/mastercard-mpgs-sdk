package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
public class MastercardCard implements Serializable {

	private static final long serialVersionUID = -7016004324567300713L;

	private String number;

	private MastercardExpiry expiry;

	private String securityCode;

	public MastercardCard() {
		this.expiry = new MastercardExpiry();
	}

}
