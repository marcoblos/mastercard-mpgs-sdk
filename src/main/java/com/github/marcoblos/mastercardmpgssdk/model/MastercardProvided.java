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
public class MastercardProvided implements Serializable {

	private static final long serialVersionUID = -3712579955502435787L;

	MastercardCard card;

	public MastercardProvided() {
		this.card = new MastercardCard();
	}

}
