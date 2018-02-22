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
public enum MastercardRequestPredicate {

	// * userId = length > 0 and < 257

	USER_ID_IS_VALID("mastercard.request.user-id", (MastercardAPIRequest r) -> userIdIsValid(r.getUserId()));

	private String code;
	private String field;
	private Predicate<MastercardAPIRequest> predicate;

	MastercardRequestPredicate(String field, Predicate<MastercardAPIRequest> predicate) {
		code = this.name();
		this.field = field;
		this.predicate = predicate;
	}

	private static boolean userIdIsValid(String userId) {
		return userId != null ? userId.length() > 0 && userId.length() < 257 : false;
	}

	public static Map<String, Predicate<MastercardAPIRequest>> getPredicates() {
		Map<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		for (MastercardRequestPredicate p : MastercardRequestPredicate.values()) {
			predicates.put(p.getField(), p.getPredicate());
		}
		return predicates;
	}

}
