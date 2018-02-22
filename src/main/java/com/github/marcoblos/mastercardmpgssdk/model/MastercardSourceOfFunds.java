package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardSourceOfFundsType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
public class MastercardSourceOfFunds implements Serializable {

	private static final long serialVersionUID = 2257591051755126776L;

	private MastercardSourceOfFundsType type = MastercardSourceOfFundsType.CARD;

	private MastercardProvided provided;

	public MastercardSourceOfFunds() {
		this.provided = new MastercardProvided();
	}

}
