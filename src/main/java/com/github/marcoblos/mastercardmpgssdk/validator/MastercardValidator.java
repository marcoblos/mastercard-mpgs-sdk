package com.github.marcoblos.mastercardmpgssdk.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardError;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardResponse;

/**
 * 
 * @author marcoblos 2018-03-12
 *
 */
public abstract class MastercardValidator {

	public MastercardResponse validate(MastercardAPIRequest request) {
		List<MastercardError> errors = new ArrayList<>();

		getPredicates().forEach((field, predicate) -> {
			if (!predicate.test(request)) {
				errors.add(new MastercardError(field));
			}
		});
		return new MastercardResponse(errors);
	}

	protected abstract HashMap<String, Predicate<MastercardAPIRequest>> getPredicates();

}
