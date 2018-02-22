package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardTransactionType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
public class MastercardTransaction implements Serializable {

	private static final long serialVersionUID = 6481790799330858909L;

	private String id;

	private MastercardAcquirer acquirer;

	private BigDecimal amount;

	private String currency;

	private MastercardTransactionType type;

	public MastercardTransaction() {
		this.acquirer = new MastercardAcquirer();
	}
}
