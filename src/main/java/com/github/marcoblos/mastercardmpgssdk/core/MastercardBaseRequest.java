package com.github.marcoblos.mastercardmpgssdk.core;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.github.marcoblos.mastercardmpgssdk.config.MastercardProperties;
import com.github.marcoblos.mastercardmpgssdk.config.MastercardRestTemplate;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardAPIOperationType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardRequestType;
import com.github.marcoblos.mastercardmpgssdk.domain.MastercardURLParametersType;
import com.github.marcoblos.mastercardmpgssdk.dto.MastercardRequestResponseDTO;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIResponse;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardResponse;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardStatus;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardBaseRequest {

	public static MastercardResponse execute(MastercardRestTemplate restTemplate, MastercardProperties properties, MastercardRequestResponseDTO requestResponseDTO,
			Map<MastercardURLParametersType, String> parameters) {
		if (!requestResponseDTO.getResponse().getErrors().isEmpty()) {
			return requestResponseDTO.getResponse();
		}

		ResponseEntity<MastercardAPIResponse> call = restTemplate.exchange(
				getTransactionUrl(properties, requestResponseDTO, parameters),
				requestResponseDTO.getRequest().getApiOperation().getHttpMethod(),
				new HttpEntity<MastercardAPIRequest>(clearAttributesBeforeSendRequest(requestResponseDTO.getRequest())),
				MastercardAPIResponse.class);
		return buildResponse(call);
	}

	private static MastercardAPIRequest clearAttributesBeforeSendRequest(MastercardAPIRequest request) {
		MastercardAPIOperationType requestType = request.getApiOperation();
		switch (requestType) {
			case OPEN_WALLET:
				request.setApiOperation(null);
				break;
			default:
				break;
		}
		return request;
	}

	private static String getTransactionUrl(MastercardProperties properties, MastercardRequestResponseDTO requestResponseDTO, Map<MastercardURLParametersType, String> parameters) {
		MastercardRequestType requestType = requestResponseDTO.getRequest().getApiOperation().getRequestType();
		return properties.getUrl(requestType, parameters);
	}

	public static MastercardResponse buildResponse(ResponseEntity<MastercardAPIResponse> call) {
		MastercardAPIResponse response = call.getBody();
		if (response == null) {
			return new MastercardResponse();
		}
		return MastercardResponse.builder()
				.order(response.getOrder())
				.errors(Arrays.asList(response.getError()))
				.result(response.getResult())
				.browserPayment(response.getBrowserPayment())
				.merchant(response.getMerchant())
				.response(response.getResponse())
				.transaction(response.getTransaction())
				.correlationId(response.getCorrelationId())
				.session(response.getSession())
				.successIndicator(response.getSuccessIndicator())
				.build();
	}

	public static MastercardStatus apiStatus(MastercardRestTemplate restTemplate, MastercardProperties properties) {
		return restTemplate.getForObject(properties.getInformationUrl(), MastercardStatus.class);
	}

}
