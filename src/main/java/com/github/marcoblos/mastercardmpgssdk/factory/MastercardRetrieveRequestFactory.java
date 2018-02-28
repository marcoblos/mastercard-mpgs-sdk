package com.github.marcoblos.mastercardmpgssdk.factory;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardRetrieveRequestFactory {

	public static MastercardAPIRequest build(MastercardRequestDTO dto) {
		dto = getValidMastercardRequestDTO(dto);
		MastercardAPIRequest request = new MastercardAPIRequest();
		request.setApiOperation(MastercardAPIOperationType.RETRIEVE);
		return request;
	}

	private static MastercardRequestDTO getValidMastercardRequestDTO(MastercardRequestDTO dto) {
		if (dto == null) {
			dto = new MastercardRequestDTO();
		}
		return dto;
	}

}
