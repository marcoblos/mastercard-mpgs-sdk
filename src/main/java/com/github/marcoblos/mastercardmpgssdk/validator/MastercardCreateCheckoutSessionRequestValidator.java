package com.github.marcoblos.mastercardmpgssdk.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.predicate.MastercardOrderPredicate;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardCreateCheckoutSessionRequestValidator extends MastercardValidator {

	private static final List<MastercardOrderPredicate> customPredicates = Arrays.asList(MastercardOrderPredicate.CURRENCY_IS_VALID, MastercardOrderPredicate.ORDER_REFERENCE_IS_VALID);

	@Override
	protected HashMap<String, Predicate<MastercardAPIRequest>> getPredicates() {

		HashMap<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		predicates.putAll(MastercardOrderPredicate.getPredicates(customPredicates));
		return predicates;
	}
}
