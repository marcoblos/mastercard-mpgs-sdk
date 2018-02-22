package com.github.marcoblos.mastercardmpgssdk.factory;

import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestResponseDTO;
import com.github.marcoblos.mastercardmpgssdk.validator.MastercardPayRequestValidator;
import com.github.marcoblos.mastercardmpgssdk.validator.MastercardRefundRequestValidator;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardObjectRequestFactory {

	private static MastercardPayRequestValidator payValidator = new MastercardPayRequestValidator();
	private static MastercardRefundRequestValidator refundValidator = new MastercardRefundRequestValidator();

	public static MastercardRequestResponseDTO build(MastercardRequestDTO dto) {
		dto = getValidMastercardRequestDTO(dto);
		MastercardRequestResponseDTO responseRequestDTO = new MastercardRequestResponseDTO();
		switch (dto.getApiOperation()) {
			case PAY:
				responseRequestDTO.setRequest(MastercardPayRequestFactory.build(dto));
				responseRequestDTO.setResponse(payValidator.validate(responseRequestDTO.getRequest()));
				return responseRequestDTO;
			case REFUND:
				responseRequestDTO.setRequest(MastercardRefundRequestFactory.build(dto));
				responseRequestDTO.setResponse(refundValidator.validate(responseRequestDTO.getRequest()));
				return responseRequestDTO;
			default:
				return responseRequestDTO;
		}
	}

	private static MastercardRequestDTO getValidMastercardRequestDTO(MastercardRequestDTO dto) {
		if (dto == null) {
			dto = new MastercardRequestDTO();
		}
		return dto;
	}

}
