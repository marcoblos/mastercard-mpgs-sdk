package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardResponseGatewayCodeType {

	ABORTED("Transaction aborted by payer"),
	ACQUIRER_SYSTEM_ERROR("Acquirer system error occurred processing the transaction"),
	APPROVED("Transaction Approved"),
	APPROVED_PENDING_SETTLEMENT("Transaction Approved - pending batch settlement"),
	AUTHENTICATION_FAILED("3D Secure authentication failed"),
	BLOCKED("Transaction blocked due to Risk or 3D Secure blocking rules"),
	CANCELLED("Transaction cancelled by payer"),
	DECLINED("Transaction declined by issuer"),
	DECLINED_AVS("Transaction declined due to address verification"),
	DECLINED_AVS_CSC("Transaction declined due to address verification and card security code"),
	DECLINED_CSC("Transaction declined due to card security code"),
	DECLINED_DO_NOT_CONTACT("Transaction declined - do not contact issuer"),
	DECLINED_INVALID_PIN("Transaction declined due to invalid PIN"),
	DECLINED_PAYMENT_PLAN("Transaction declined due to payment plan"),
	DECLINED_PIN_REQUIRED("Transaction declined due to PIN required"),
	DEFERRED_TRANSACTION_RECEIVED("Deferred transaction received and awaiting processing"),
	DUPLICATE_BATCH("Transaction declined due to duplicate batch"),
	EXCEEDED_RETRY_LIMIT("Transaction retry limit exceeded"),
	EXPIRED_CARD("Transaction declined due to expired card"),
	INSUFFICIENT_FUNDS("Transaction declined due to insufficient funds"),
	INVALID_CSC("Invalid card security code"),
	LOCK_FAILURE("Order locked - another transaction is in progress for this order"),
	NOT_ENROLLED_3D_SECURE("Card holder is not enrolled in 3D Secure"),
	NOT_SUPPORTED("Transaction type not supported"),
	PARTIALLY_APPROVED("The transaction was approved for a lesser amount than requested. The approved amount is returned in order.totalAuthorizedAmount"),
	PENDING("Transaction is pending"),
	REFERRED("Transaction declined - refer to issuer"),
	SUBMITTED(
			"The transaction has successfully been created in the gateway. It is either awaiting submission to the acquirer or has been submitted to the acquirer but the gateway has not yet received a response about the success or otherwise of the payment"),
	SYSTEM_ERROR("Internal system error occurred processing the transaction"),
	TIMED_OUT(
			"The gateway has timed out the request to the acquirer because it did not receive a response. You can handle the transaction as a declined transaction. Where possible the gateway will attempt to reverse the transaction"),
	UNKNOWN(
			"The transaction has been submitted to the acquirer but the gateway was not able to find out about the success or otherwise of the payment. If the gateway subsequently finds out about the success of the payment it will update the response code"),
	UNSPECIFIED_FAILURE("Transaction could not be processed");

	private String code;
	private String messageKey;

	MastercardResponseGatewayCodeType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
