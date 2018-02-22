package com.github.marcoblos.mastercardmpgssdk.predicate;

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
public enum MastercardExpiryPredicate {

	// * cardMonth = number between 1 and 12
	// * cardYear = length == 2

	CARD_MONTH_IS_VALID("mastercard.source-of-funds.provided.card.expiry.month", (MastercardAPIRequest e) -> monthIsValid(e.getSourceOfFunds().getProvided().getCard().getExpiry().getMonth())),
	CARD_YEAR_IS_VALID("mastercard.source-of-funds.provided.card.expiry.year", (MastercardAPIRequest e) -> yearIsValid(e.getSourceOfFunds().getProvided().getCard().getExpiry().getYear()));

	private String code;
	private String field;
	private Predicate<MastercardAPIRequest> predicate;

	MastercardExpiryPredicate(String field, Predicate<MastercardAPIRequest> predicate) {
		code = this.name();
		this.field = field;
		this.predicate = predicate;
	}

	private static boolean monthIsValid(String month) {
		Integer monthNumber = null;
		try {
			monthNumber = Integer.valueOf(month);
		} catch (NumberFormatException e) {
			return false;
		}
		return monthNumber > 0 && monthNumber < 13;
	}

	private static boolean yearIsValid(String year) {
		return year != null ? year.length() == 2 : false;
	}

	public static Map<String, Predicate<MastercardAPIRequest>> getPredicates() {
		Map<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		for (MastercardExpiryPredicate p : MastercardExpiryPredicate.values()) {
			predicates.put(p.getField(), p.getPredicate());
		}
		return predicates;
	}

}
