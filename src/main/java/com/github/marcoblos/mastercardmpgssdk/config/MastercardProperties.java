package com.github.marcoblos.mastercardmpgssdk.config;

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

	private String getUrl() {
		return getBaseUrl().concat(getApiVersion());
	}

	public String getInformationUrl() {
		return getUrl().concat("/information");
	}

	/**
	 * Used for refund and pay requests
	 * 
	 * @param orderId an unique identifier provided by user of this SDK. It will be used by you to track transactions about one order
	 * @param transactionReference an unique identifier. Orders can have multiples transactions associeted with it
	 * @return String
	 */
	public String getTransactionUrl(String orderId, String transactionReference) {
		return String.format(
				getUrl().concat("/merchant/%s/order/%s/transaction/%s"),
				getMerchantId(),
				orderId,
				transactionReference);
	}

}
