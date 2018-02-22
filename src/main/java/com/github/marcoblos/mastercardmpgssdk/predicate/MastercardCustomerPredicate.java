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
public enum MastercardCustomerPredicate {

	// * customerEmail = length > 3

	CUSTOMER_EMAIL_IS_VALID("mastercard.customer.email", (MastercardAPIRequest r) -> emailIsValid(r.getCustomer().getEmail()));

	private String code;
	private String field;
	private Predicate<MastercardAPIRequest> predicate;

	MastercardCustomerPredicate(String field, Predicate<MastercardAPIRequest> predicate) {
		code = this.name();
		this.field = field;
		this.predicate = predicate;
	}

	private static boolean emailIsValid(String email) {
		return email != null ? email.length() > 3 : false;
	}

	public static Map<String, Predicate<MastercardAPIRequest>> getPredicates() {
		Map<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		for (MastercardCustomerPredicate p : MastercardCustomerPredicate.values()) {
			predicates.put(p.getField(), p.getPredicate());
		}
		return predicates;
	}

}
