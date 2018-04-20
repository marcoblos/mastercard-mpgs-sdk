package com.github.marcoblos.mastercardmpgssdk.dto;

import java.math.BigDecimal;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardWalletProviderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MastercardRequestDTO {

	private MastercardAPIOperationType apiOperation;

	private String orderReference;

	private BigDecimal amount;

	private String currency;

	private String cardNumber;

	private String cardSecurityCode;

	private String cardMonth;

	private String cardYear;

	private String customerEmail;

	private String userId;

	private MastercardWalletProviderType walletProvider;

	private static String forceCardYearTwoDigits(String cardYear) {
		String cardYearFormated = cardYear;
		if (cardYearFormated != null && cardYearFormated.length() > 2) {
			try {
				cardYearFormated = Year.parse(cardYear).format(DateTimeFormatter.ofPattern("uu"));
			} catch (DateTimeParseException e) {
				// do nothing! we have some explanation about it!
				// we try to format the card year but if DateTimeFormatter is not work properly we can ignoring here
				// because user will receive and error from validators more readable than we can provide from here
			}
		}
		return cardYearFormated;
	}

	/**
	 * It is a workaround because @Builder.Default didn't work see this issue on GitHub https://github.com/rzwitserloot/lombok/issues/1347
	 */
	public MastercardRequestDTO() {
		this.apiOperation = MastercardAPIOperationType.NOOP;
	}

	public void setCardYear(String cardYear) {
		this.cardYear = MastercardRequestDTO.forceCardYearTwoDigits(cardYear);
	}

	public static MastercardRequestDTOBuilder builder() {
		return new CustomMastercardRequestDTOBuilder();
	}

	private static class CustomMastercardRequestDTOBuilder extends MastercardRequestDTOBuilder {

		@Override
		public MastercardRequestDTO build() {
			super.cardYear = MastercardRequestDTO.forceCardYearTwoDigits(super.cardYear);
			return super.build();
		}

	}

}
