package com.github.marcoblos.mastercardmpgssdk.validator;

import java.util.HashMap;
import java.util.function.Predicate;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.predicate.MastercardCardPredicate;
import com.github.marcoblos.mastercardmpgssdk.predicate.MastercardCustomerPredicate;
import com.github.marcoblos.mastercardmpgssdk.predicate.MastercardExpiryPredicate;
import com.github.marcoblos.mastercardmpgssdk.predicate.MastercardOrderPredicate;
import com.github.marcoblos.mastercardmpgssdk.predicate.MastercardRequestPredicate;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardPayRequestValidator extends MastercardValidator {

	@Override
	protected HashMap<String, Predicate<MastercardAPIRequest>> getPredicates() {
		// * is necessary to validate this fields for pay request and whole are compulsory:
		// *
		// * amount = length > 0 and < 15
		// * currency = A - Z (capitalized letters) length == 3
		// * orderReference = length > 0 and < 41
		// * cardNumber = 0 - 9 length > 8 and < 20
		// * cardSecurityCode = 0 - 9 length > 2 and < 5
		// * cardMonth = number between 1 and 12
		// * cardYear = length == 2
		// * customerEmail = length > 3
		// * userId = length > 0 and < 257

		HashMap<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		predicates.putAll(MastercardCardPredicate.getPredicates());
		predicates.putAll(MastercardCustomerPredicate.getPredicates());
		predicates.putAll(MastercardExpiryPredicate.getPredicates());
		predicates.putAll(MastercardOrderPredicate.getPredicates());
		predicates.putAll(MastercardRequestPredicate.getPredicates());
		return predicates;
	}
}
