package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardErrorCauseType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardValidationType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = { "field" })
public class MastercardError implements Serializable {

	private static final long serialVersionUID = -5635739032258202684L;

	private MastercardErrorCauseType cause;

	private String explanation;

	private String field;

	private String supportCode;

	private MastercardValidationType validationType;

	// explanation will be fullfilled only if cause is INVALID_REQUEST or SERVER_BUSY

	// field will be fullfilled only if cause is INVALID_REQUEST and a field level validation error was encountered

	// supportCode will be fullfilled only if cause is SERVER_FAILED or REQUEST_REJECTED

	// validationType will be fullfilled only if cause is INVALID_REQUEST

	public MastercardError(String invalidField) {
		this.field = invalidField;
		this.cause = MastercardErrorCauseType.INVALID_REQUEST;
		this.explanation = MastercardValidationType.INVALID.getMessageKey();
		this.validationType = MastercardValidationType.INVALID;
	}

}
