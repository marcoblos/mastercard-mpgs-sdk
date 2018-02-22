package com.github.marcoblos.mastercardmpgssdk.predicate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardOrderPredicate {

	// * amount = length > 0 and < 15
	// * currency = A - Z (capitalized letters) length == 3
	// * orderReference = length > 0 and < 41

	AMOUNT_IS_VALID("mastercard.order.amount", (MastercardAPIRequest r) -> amountIsValid(r.getOrder().getAmount())),
	CURRENCY_IS_VALID("mastercard.order.currency", (MastercardAPIRequest r) -> currencyIsValid(r.getOrder().getCurrency())),
	ORDER_REFERENCE_IS_VALID("mastercard.order.reference", (MastercardAPIRequest r) -> orderReferenceIsValid(r.getOrder().getReference()));

	private String code;
	private String field;
	private Predicate<MastercardAPIRequest> predicate;

	MastercardOrderPredicate(String field, Predicate<MastercardAPIRequest> predicate) {
		code = this.name();
		this.field = field;
		this.predicate = predicate;
	}

	private static boolean orderReferenceIsValid(String orderReference) {
		return orderReference != null ? orderReference.length() > 0 && orderReference.length() < 41 : false;
	}

	private static boolean currencyIsValid(String currency) {
		return "EUR".equals(currency) || "GBP".equals(currency) || "USD".equals(currency) || "AUD".equals(currency);
	}

	private static boolean amountIsValid(BigDecimal amount) {
		return amount != null ? amount.toPlainString().length() > 0 && amount.toPlainString().length() < 15 : false;
	}

	public static Map<String, Predicate<MastercardAPIRequest>> getPredicates() {
		Map<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		for (MastercardOrderPredicate p : MastercardOrderPredicate.values()) {
			predicates.put(p.getField(), p.getPredicate());
		}
		return predicates;
	}

}
