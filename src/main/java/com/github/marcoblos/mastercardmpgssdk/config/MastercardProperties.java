package com.github.marcoblos.mastercardmpgssdk.config;

import java.util.Map;

import org.springframework.util.Assert;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardRequestType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardURLParametersType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
public class MastercardProperties {

	private String baseUrl;

	private String apiVersion;

	private String merchantId;

	private String apiKey;

	private String getDefaultUrl() {
		return getBaseUrl().concat(getApiVersion());
	}

	public String getInformationUrl() {
		return getDefaultUrl().concat("/information");
	}

	/**
	 * Used for refund and pay requests
	 * 
	 * @param orderReference an unique identifier provided by user of this SDK. It will be used by you to track transactions about one order
	 * @param transactionReference an unique identifier. Orders can have multiples transactions associeted with it
	 * @return String
	 */
	public String getTransactionUrl(String orderReference, String transactionReference) {
		Assert.notNull(orderReference, "orderReference is null");
		Assert.notNull(transactionReference, "transactionReference is null");
		return String.format(
				getDefaultUrl().concat("/merchant/%s/order/%s/transaction/%s"),
				getMerchantId(),
				orderReference,
				transactionReference);
	}

	public String getOrderUrl(String orderReference) {
		Assert.notNull(orderReference, "orderReference is null");
		return String.format(
				getDefaultUrl().concat("/merchant/%s/order/%s"),
				getMerchantId(),
				orderReference);
	}

	public String getSessionUrl(String sessionId) {
		if (sessionId == null) {
			return String.format(
					getDefaultUrl().concat("/merchant/%s/session"),
					getMerchantId());
		} else {
			return String.format(
					getDefaultUrl().concat("/merchant/%s/session/%s"),
					getMerchantId(),
					sessionId);
		}
	}

	public String getUrl(MastercardRequestType operationType, Map<MastercardURLParametersType, String> parameters) {
		switch (operationType) {
			case TRANSACTION:
				return this.getTransactionUrl(parameters.get(MastercardURLParametersType.ORDER_REFERENCE), parameters.get(MastercardURLParametersType.TRANSACTION_REFERENCE));
			case SESSION:
				return this.getSessionUrl(parameters.get(MastercardURLParametersType.SESSION_ID));
			case ORDER:
				return this.getOrderUrl(parameters.get(MastercardURLParametersType.ORDER_REFERENCE));
			default:
				return "";
		}
	}

}
