package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardWalletProviderType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class MastercardOrder implements Serializable {

	private static final long serialVersionUID = -1217195364008806000L;

	private String id;

	private BigDecimal amount;

	private String currency; // java Upper case alphabetic text, USD, BRL, EUR...

	private String reference; // "reference": "orderId",

	private Date customerOrderDate;

	private LocalDateTime creationTime;

	private BigDecimal totalAuthorizedAmount;

	private BigDecimal totalCapturedAmount;

	private BigDecimal totalRefundedAmount;

	private MastercardWalletProviderType walletProvider;

	public String getCustomerOrderDate() {
		return this.customerOrderDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(customerOrderDate) : null;
	}

}
