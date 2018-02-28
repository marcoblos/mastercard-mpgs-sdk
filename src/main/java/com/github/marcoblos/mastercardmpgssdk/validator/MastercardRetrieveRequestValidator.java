package com.github.marcoblos.mastercardmpgssdk.validator;

import java.util.HashMap;
import java.util.function.Predicate;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardRetrieveRequestValidator extends MastercardValidator {

	@Override
	protected HashMap<String, Predicate<MastercardAPIRequest>> getPredicates() {
		HashMap<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		// predicates.putAll(MastercardCardPredicate.getPredicates());
		// predicates.putAll(MastercardCustomerPredicate.getPredicates());
		// predicates.putAll(MastercardExpiryPredicate.getPredicates());
		// predicates.putAll(MastercardOrderPredicate.getPredicates());
		// predicates.putAll(MastercardRequestPredicate.getPredicates());
		return predicates;
	}
}
