package com.github.marcoblos.mastercardmpgssdk.model;

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
public class MastercardStatus {

	private String gatewayVersion;
	private String status;

	@Override
	public String toString() {
		return "gatewayVersion: " + this.gatewayVersion + ", " + "status: " + this.status;
	}

}
