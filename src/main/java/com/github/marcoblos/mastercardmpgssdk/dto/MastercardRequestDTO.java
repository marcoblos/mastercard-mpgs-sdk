package com.github.marcoblos.mastercardmpgssdk.dto;

import java.math.BigDecimal;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;

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
public class MastercardRequestDTO {

	private MastercardAPIOperationType apiOperation;

	private String orderReference;

	private BigDecimal amount;

	private String currency;

	private String cardNumber;

	private String cardSecurityCode;

	private String cardMonth;

	private String cardYear;

	private String customerEmail;

	private String userId;

	/**
	 * It is a workaround because @Builder.Default didn't work see this issue on GitHub https://github.com/rzwitserloot/lombok/issues/1347
	 */
	public MastercardRequestDTO() {
		this.apiOperation = MastercardAPIOperationType.NOOP;
	}

}
