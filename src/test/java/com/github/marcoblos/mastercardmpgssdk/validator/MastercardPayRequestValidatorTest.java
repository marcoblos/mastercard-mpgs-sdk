package com.github.marcoblos.mastercardmpgssdk.validator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.factory.MastercardPayRequestFactory;
import com.github.marcoblos.mastercardmpgssdk.help.UUIDUtils;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardError;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardResponse;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardPayRequestValidatorTest {

	private static MastercardPayRequestValidator payValidator = new MastercardPayRequestValidator();

	@Test
	public void valid_pay_request_object() {
		MastercardAPIRequest request = MastercardPayRequestFactory.build(buildValidPayRequestDTO());
		MastercardResponse mastercardResponse = payValidator.validate(request);
		Assert.assertEquals(mastercardResponse.getErrors().size(), 0);
	}

	@Test
	public void invalid_expiry_pay_request_object() {
		MastercardAPIRequest request = MastercardPayRequestFactory.build(buildInvalidExpiryPayRequestDTO());
		MastercardResponse mastercardResponse = payValidator.validate(request);
		Assert.assertEquals(mastercardResponse.getErrors().size(), 2);
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.source-of-funds.provided.card.expiry.month"));
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.source-of-funds.provided.card.expiry.year"));
	}

	@Test
	public void invalid_order_pay_request_object() {
		MastercardAPIRequest request = MastercardPayRequestFactory.build(buildInvalidOrderPayRequestDTO());
		MastercardResponse mastercardResponse = payValidator.validate(request);
		Assert.assertEquals(mastercardResponse.getErrors().size(), 3);
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.order.amount"));
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.order.reference"));
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.order.currency"));
	}

	@Test
	public void invalid_card_pay_request_object() {
		MastercardAPIRequest request = MastercardPayRequestFactory.build(buildInvalidCardPayRequestDTO());
		MastercardResponse mastercardResponse = payValidator.validate(request);
		Assert.assertEquals(mastercardResponse.getErrors().size(), 2);
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.source-of-funds.provided.card.number"));
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.source-of-funds.provided.card.security-code"));
	}

	@Test
	public void invalid_customer_pay_request_object() {
		MastercardAPIRequest request = MastercardPayRequestFactory.build(buildInvalidCustomerPayRequestDTO());
		MastercardResponse mastercardResponse = payValidator.validate(request);
		Assert.assertEquals(mastercardResponse.getErrors().size(), 1);
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.customer.email"));
	}

	@Test
	public void invalid_request_pay_request_object() {
		MastercardAPIRequest request = MastercardPayRequestFactory.build(buildInvalidRequestPayRequestDTO());
		MastercardResponse mastercardResponse = payValidator.validate(request);
		Assert.assertEquals(mastercardResponse.getErrors().size(), 1);
		Assert.assertTrue(compareMastercardResponseAndField(mastercardResponse, "mastercard.request.user-id"));
	}

	private boolean compareMastercardResponseAndField(MastercardResponse mastercardResponse, String field) {
		return mastercardResponse.getErrors().contains(new MastercardError(field));
	}

	private MastercardRequestDTO buildValidPayRequestDTO() {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal("1.00"))
				.apiOperation(MastercardAPIOperationType.PAY)
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

	private MastercardRequestDTO buildInvalidExpiryPayRequestDTO() {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal("1.00"))
				.apiOperation(MastercardAPIOperationType.PAY)
				.cardMonth("50")
				.cardYear("212")
				.cardSecurityCode("100")
				.cardNumber("5123450000000008")
				.currency("EUR")
				.customerEmail("marcoblos1234@gmail.com")
				.orderReference(UUIDUtils.generate())
				.userId(UUIDUtils.generate())
				.build();
	}

	private MastercardRequestDTO buildInvalidOrderPayRequestDTO() {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal("100000000000000000000"))
				.orderReference(UUIDUtils.generate(41))
				.currency("BRL")
				.apiOperation(MastercardAPIOperationType.PAY)
				.cardMonth("10")
				.cardYear("21")
				.cardSecurityCode("100")
				.cardNumber("5123450000000008")
				.customerEmail("marcoblos1234@gmail.com")
				.userId(UUIDUtils.generate())
				.build();
	}

	private MastercardRequestDTO buildInvalidCardPayRequestDTO() {
		return MastercardRequestDTO.builder()
				.cardSecurityCode("10000")
				.cardNumber("51234500000000080000")
				.amount(new BigDecimal("1.00"))
				.apiOperation(MastercardAPIOperationType.PAY)
				.cardMonth("05")
				.cardYear("21")
				.currency("EUR")
				.customerEmail("marcoblos1234@gmail.com")
				.orderReference(UUIDUtils.generate())
				.userId(UUIDUtils.generate())
				.build();
	}

	private MastercardRequestDTO buildInvalidCustomerPayRequestDTO() {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal("1.00"))
				.apiOperation(MastercardAPIOperationType.PAY)
				.cardMonth("05")
				.cardYear("21")
				.cardSecurityCode("100")
				.cardNumber("5123450000000008")
				.currency("EUR")
				.customerEmail("a@b")
				.orderReference(UUIDUtils.generate())
				.userId(UUIDUtils.generate())
				.build();
	}

	private MastercardRequestDTO buildInvalidRequestPayRequestDTO() {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal("1.00"))
				.apiOperation(MastercardAPIOperationType.PAY)
				.cardMonth("05")
				.cardYear("21")
				.cardSecurityCode("100")
				.cardNumber("5123450000000008")
				.currency("EUR")
				.customerEmail("marcoblos1234@gmail.com")
				.orderReference(UUIDUtils.generate())
				.userId("")
				.build();
	}

}
