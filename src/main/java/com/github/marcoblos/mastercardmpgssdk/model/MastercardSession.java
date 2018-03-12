package com.github.marcoblos.mastercardmpgssdk.model;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardUpdateStatusType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MastercardSession {

	private String id;

	private MastercardUpdateStatusType updateStatus;

	private String version;

}
