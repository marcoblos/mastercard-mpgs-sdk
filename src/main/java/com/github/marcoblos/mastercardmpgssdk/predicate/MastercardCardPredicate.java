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
public enum MastercardCardPredicate {

	// * cardNumber = 0 - 9 length > 8 and < 20

	CARD_NUMBER_IS_VALID("mastercard.source-of-funds.provided.card.number", (MastercardAPIRequest r) -> cardNumberIsValid(r.getSourceOfFunds().getProvided().getCard().getNumber()));

	private String code;
	private String field;
	private Predicate<MastercardAPIRequest> predicate;

	MastercardCardPredicate(String field, Predicate<MastercardAPIRequest> predicate) {
		code = this.name();
		this.field = field;
		this.predicate = predicate;
	}

	private static boolean cardNumberIsValid(String cardNumber) {
		return cardNumber != null ? cardNumber.length() > 8 && cardNumber.length() < 20 : false;
	}

	public static Map<String, Predicate<MastercardAPIRequest>> getPredicates() {
		Map<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		for (MastercardCardPredicate p : MastercardCardPredicate.values()) {
			predicates.put(p.getField(), p.getPredicate());
		}
		return predicates;
	}

}
