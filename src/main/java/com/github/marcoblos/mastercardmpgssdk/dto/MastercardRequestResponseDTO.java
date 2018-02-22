package com.github.marcoblos.mastercardmpgssdk.dto;

import com.github.marcoblos.mastercardmpgssdk.model.MastercardAPIRequest;
import com.github.marcoblos.mastercardmpgssdk.model.MastercardResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
public class MastercardRequestResponseDTO {

	private MastercardResponse response;

	private MastercardAPIRequest request;

	public void setResponse(MastercardResponse response) {
		this.response = response;
		if (!response.getErrors().isEmpty()) {
			this.request = new MastercardAPIRequest();
		}
	}

	public MastercardRequestResponseDTO() {
		this.response = new MastercardResponse();
		this.request = new MastercardAPIRequest();
	}

}
