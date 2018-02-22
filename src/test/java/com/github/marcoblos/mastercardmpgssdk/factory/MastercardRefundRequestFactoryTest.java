package com.github.marcoblos.mastercardmpgssdk.factory;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardSourceOfFundsType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestDTO;
import com.github.marcoblos.mastercardmpgssdk.help.UUIDUtils;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardRefundRequestFactoryTest {

	@Test
	public void create_pay_object_with_success() {
		MastercardRequestDTO dto = buildSuccessRefundRequestDTOWithExcessiveInformations();
		MastercardAPIRequest request = MastercardRefundRequestFactory.build(dto);

		Assert.assertTrue(request.getSourceOfFunds() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getExpiry() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getNumber() == null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getSecurityCode() == null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getExpiry().getMonth() == null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getExpiry().getYear() == null);
		Assert.assertTrue(request.getCustomer() != null);
		Assert.assertTrue(request.getCustomer().getEmail() == null);
		Assert.assertTrue(request.getUserId() == null);
		Assert.assertTrue(request.getTransaction() != null);
		Assert.assertTrue(request.getTransaction().getAcquirer() != null);
		Assert.assertTrue(request.getTransaction().getAcquirer().getId() == null);
		Assert.assertTrue(request.getTransaction().getCurrency() != null);
		Assert.assertTrue(request.getTransaction().getId() == null);
		Assert.assertTrue(request.getTransaction().getAmount() != null);
		Assert.assertTrue(request.getTransaction().getType() == null);
		Assert.assertTrue(request.getOrder() != null);
		Assert.assertTrue(request.getOrder().getCurrency() == null);
		Assert.assertTrue(request.getOrder().getCustomerOrderDate() == null);
		Assert.assertTrue(request.getOrder().getId() == null);
		Assert.assertTrue(request.getOrder().getReference() == null);
		Assert.assertTrue(request.getOrder().getAmount() == null);
		Assert.assertTrue(request.getOrder().getCreationTime() == null);
		Assert.assertTrue(request.getOrder().getTotalAuthorizedAmount() == null);
		Assert.assertTrue(request.getOrder().getTotalCapturedAmount() == null);
		Assert.assertTrue(request.getOrder().getTotalRefundedAmount() == null);
		Assert.assertEquals(request.getApiOperation(), MastercardAPIOperationType.REFUND);
		Assert.assertEquals(request.getSourceOfFunds().getType(), MastercardSourceOfFundsType.CARD);
	}

	@Test
	public void create_pay_object_with_null_object() {
		MastercardRequestDTO dto = null;
		MastercardAPIRequest request = MastercardRefundRequestFactory.build(dto);

		Assert.assertTrue(request.getSourceOfFunds() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getExpiry() != null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getNumber() == null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getSecurityCode() == null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getExpiry().getMonth() == null);
		Assert.assertTrue(request.getSourceOfFunds().getProvided().getCard().getExpiry().getYear() == null);
		Assert.assertTrue(request.getCustomer() != null);
		Assert.assertTrue(request.getCustomer().getEmail() == null);
		Assert.assertTrue(request.getUserId() == null);
		Assert.assertTrue(request.getTransaction() != null);
		Assert.assertTrue(request.getTransaction().getAcquirer() != null);
		Assert.assertTrue(request.getTransaction().getAcquirer().getId() == null);
		Assert.assertTrue(request.getTransaction().getCurrency() == null);
		Assert.assertTrue(request.getTransaction().getId() == null);
		Assert.assertTrue(request.getTransaction().getAmount() == null);
		Assert.assertTrue(request.getTransaction().getType() == null);
		Assert.assertTrue(request.getOrder() != null);
		Assert.assertTrue(request.getOrder().getCurrency() == null);
		Assert.assertTrue(request.getOrder().getCustomerOrderDate() == null);
		Assert.assertTrue(request.getOrder().getId() == null);
		Assert.assertTrue(request.getOrder().getReference() == null);
		Assert.assertTrue(request.getOrder().getAmount() == null);
		Assert.assertTrue(request.getOrder().getCreationTime() == null);
		Assert.assertTrue(request.getOrder().getTotalAuthorizedAmount() == null);
		Assert.assertTrue(request.getOrder().getTotalCapturedAmount() == null);
		Assert.assertTrue(request.getOrder().getTotalRefundedAmount() == null);
		Assert.assertEquals(request.getApiOperation(), MastercardAPIOperationType.REFUND);
		Assert.assertEquals(request.getSourceOfFunds().getType(), MastercardSourceOfFundsType.CARD);
	}

	private MastercardRequestDTO buildSuccessRefundRequestDTOWithExcessiveInformations() {
		return MastercardRequestDTO.builder()
				.amount(new BigDecimal(1))
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

}
