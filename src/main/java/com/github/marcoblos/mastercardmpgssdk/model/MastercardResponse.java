package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardResponseResultType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MastercardResponse implements Serializable {

	private static final long serialVersionUID = 1820245868571852443L;

	private MastercardOrder order;

	private List<MastercardError> errors;

	private MastercardResponseResultType result;

	private MastercardBrowserPayment browserPayment;

	private String merchant;

	private MastercardResponseGateway response;

	private MastercardTransaction transaction;

	private String correlationId;

	private MastercardSession session;

	private String successIndicator;

	public MastercardResponse() {
		this.order = new MastercardOrder();
		this.errors = new ArrayList<>();
		this.browserPayment = new MastercardBrowserPayment();
		this.response = new MastercardResponseGateway();
		this.transaction = new MastercardTransaction();
	}

	public MastercardResponse(List<MastercardError> errors) {
		if (!errors.isEmpty()) {
			this.result = MastercardResponseResultType.ERROR;
		} else {
			this.result = MastercardResponseResultType.PENDING;
		}
		this.errors = errors;
		this.order = new MastercardOrder();
		this.browserPayment = new MastercardBrowserPayment();
		this.response = new MastercardResponseGateway();
		this.transaction = new MastercardTransaction();
	}

}
