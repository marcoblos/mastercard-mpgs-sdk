package com.github.marcoblos.mastercardmpgssdk.factory;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardOrder;

/**
 * 
 * @author marcoblos 2018-03-12
 *
 */
public class MastercardCreateCheckoutSessionRequestFactory {

	public static MastercardAPIRequest build(MastercardRequestDTO dto) {
		dto = getValidMastercardRequestDTO(dto);
		MastercardAPIRequest request = new MastercardAPIRequest();
		request.setApiOperation(MastercardAPIOperationType.CREATE_CHECKOUT_SESSION);
		request.setOrder(newOrderForCreateCheckoutSession(dto));
		return request;
	}

	private static MastercardOrder newOrderForCreateCheckoutSession(MastercardRequestDTO dto) {
		MastercardOrder order = new MastercardOrder();
		order.setCurrency(dto.getCurrency());
		order.setReference(dto.getOrderReference());
		order.setId(dto.getOrderReference());
		return order;
	}

	private static MastercardRequestDTO getValidMastercardRequestDTO(MastercardRequestDTO dto) {
		if (dto == null) {
			dto = new MastercardRequestDTO();
		}
		return dto;
	}

}
