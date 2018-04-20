package com.github.marcoblos.mastercardmpgssdk.factory;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardWalletProviderType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardOrder;

/**
 * 
 * @author marcoblos 2018-03-12
 *
 */
public class MastercardOpenWalletRequestFactory {

	public static MastercardAPIRequest build(MastercardRequestDTO dto) {
		dto = getValidMastercardRequestDTO(dto);
		MastercardAPIRequest request = new MastercardAPIRequest();
		request.setApiOperation(MastercardAPIOperationType.OPEN_WALLET);
		request.setOrder(newOrderForOpenWallet(MastercardWalletProviderType.MASTERPASS_ONLINE));
		return request;
	}

	private static MastercardOrder newOrderForOpenWallet(MastercardWalletProviderType walletProvider) {
		MastercardOrder order = new MastercardOrder();
		order.setWalletProvider(walletProvider);
		return order;
	}

	private static MastercardRequestDTO getValidMastercardRequestDTO(MastercardRequestDTO dto) {
		if (dto == null) {
			dto = new MastercardRequestDTO();
		}
		return dto;
	}

}
