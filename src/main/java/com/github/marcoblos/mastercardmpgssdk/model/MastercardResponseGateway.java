package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardResponseGatewayCodeType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class MastercardResponseGateway implements Serializable {

	private static final long serialVersionUID = 495637380266979328L;

	private MastercardResponseGatewayCodeType gatewayCode;

}
