package com.github.marcoblos.mastercardmpgssdk.factory;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardTransaction;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardRefundRequestFactory {

	public static MastercardAPIRequest build(MastercardRequestDTO dto) {
		dto = getValidMastercardRequestDTO(dto);
		MastercardAPIRequest request = new MastercardAPIRequest();
		request.setApiOperation(MastercardAPIOperationType.REFUND);
		request.setTransaction(newTransactionToRefund(dto));
		return request;
	}

	private static MastercardTransaction newTransactionToRefund(MastercardRequestDTO dto) {
		MastercardTransaction transaction = new MastercardTransaction();
		transaction.setCurrency(dto.getCurrency());
		transaction.setAmount(dto.getAmount());
		return transaction;
	}

	private static MastercardRequestDTO getValidMastercardRequestDTO(MastercardRequestDTO dto) {
		if (dto == null) {
			dto = new MastercardRequestDTO();
		}
		return dto;
	}

}
