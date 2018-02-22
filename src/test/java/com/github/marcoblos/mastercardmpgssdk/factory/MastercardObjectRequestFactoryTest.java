package com.github.marcoblos.mastercardmpgssdk.factory;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestResponseDTO;
import com.github.marcoblos.mastercardmpgssdk.help.UUIDUtils;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardObjectRequestFactoryTest {

	@Test
	public void create_pay_and_refund_object_with_success() {
		MastercardRequestDTO dtoPay = buildSuccessPayRequestDTO(MastercardAPIOperationType.PAY);
		MastercardRequestDTO dtoRefund = buildSuccessPayRequestDTO(MastercardAPIOperationType.REFUND);

		MastercardRequestResponseDTO requestPay = MastercardObjectRequestFactory.build(dtoPay);
		MastercardRequestResponseDTO requestRefund = MastercardObjectRequestFactory.build(dtoRefund);

		Assert.assertNotEquals(requestPay.getRequest().getApiOperation(), requestRefund.getRequest().getApiOperation());
	}

	@Test
	public void create_object_with_null_dto() {
		MastercardRequestDTO dtoPay = null;
		MastercardRequestResponseDTO requestPay = MastercardObjectRequestFactory.build(dtoPay);
		Assert.assertTrue(requestPay.getRequest().getApiOperation() == null);
	}

	private MastercardRequestDTO buildSuccessPayRequestDTO(MastercardAPIOperationType type) {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal(1))
				.apiOperation(type)
				.cardMonth("05")
				.cardYear("21")
				.cardSecurityCode("100")
				.cardNumber("5123450000000008")
				.currency("EUR")
				.customerEmail("marcoblos1234@gmail.com")
				.orderReference(UUIDUtils.generate())
				.userId(UUIDUtils.generate())
				.build();
	}

}
