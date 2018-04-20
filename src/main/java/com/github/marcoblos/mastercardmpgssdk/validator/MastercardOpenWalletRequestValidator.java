package com.github.marcoblos.mastercardmpgssdk.validator;

import java.util.HashMap;
import java.util.function.Predicate;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;

/**
 * 
 * @author marcoblos 2018-03-22
 *
 */
public class MastercardOpenWalletRequestValidator extends MastercardValidator {

	@Override
	protected HashMap<String, Predicate<MastercardAPIRequest>> getPredicates() {

		HashMap<String, Predicate<MastercardAPIRequest>> predicates = new HashMap<>();
		return predicates;
	}
}
