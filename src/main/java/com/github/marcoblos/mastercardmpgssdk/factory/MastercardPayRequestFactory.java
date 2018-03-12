package com.github.marcoblos.mastercardmpgssdk.factory;

import java.util.Date;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardSourceOfFundsType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardCard;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardCustomer;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardExpiry;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardOrder;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardProvided;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardSourceOfFunds;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardPayRequestFactory {

	public static MastercardAPIRequest build(MastercardRequestDTO dto) {
		dto = getValidMastercardRequestDTO(dto);
		MastercardAPIRequest request = new MastercardAPIRequest();
		request.setApiOperation(MastercardAPIOperationType.PAY);
		request.setOrder(newOrder(dto));
		request.setSourceOfFunds(newSourceOfFunds(dto));
		request.setCustomer(newCustomer(dto));
		request.setUserId(dto.getUserId());
		return request;
	}

	private static MastercardOrder newOrder(MastercardRequestDTO dto) {
		MastercardOrder order = new MastercardOrder();
		order.setAmount(dto.getAmount());
		order.setCurrency(dto.getCurrency());
		order.setReference(dto.getOrderReference());
		order.setCustomerOrderDate(new Date());
		return order;
	}

	private static MastercardSourceOfFunds newSourceOfFunds(MastercardRequestDTO dto) {
		MastercardSourceOfFunds sourceOfFunds = new MastercardSourceOfFunds();
		sourceOfFunds.setType(MastercardSourceOfFundsType.CARD);
		sourceOfFunds.setProvided(newProvided(dto));
		return sourceOfFunds;
	}

	private static MastercardProvided newProvided(MastercardRequestDTO dto) {
		MastercardProvided provided = new MastercardProvided();
		provided.setCard(newSuccessCard(dto));
		return provided;
	}

	private static MastercardCard newSuccessCard(MastercardRequestDTO dto) {
		MastercardCard card = new MastercardCard();
		card.setNumber(dto.getCardNumber());
		card.setSecurityCode(dto.getCardSecurityCode());
		card.setExpiry(newExpiry(dto));
		return card;
	}

	private static MastercardExpiry newExpiry(MastercardRequestDTO dto) {
		MastercardExpiry expiry = new MastercardExpiry();
		expiry.setMonth(dto.getCardMonth());
		expiry.setYear(dto.getCardYear());
		return expiry;
	}

	private static MastercardCustomer newCustomer(MastercardRequestDTO dto) {
		MastercardCustomer customer = new MastercardCustomer();
		customer.setEmail(dto.getCustomerEmail());
		return customer;
	}

	private static MastercardRequestDTO getValidMastercardRequestDTO(MastercardRequestDTO dto) {
		if (dto == null) {
			dto = new MastercardRequestDTO();
		}
		return dto;
	}

}
