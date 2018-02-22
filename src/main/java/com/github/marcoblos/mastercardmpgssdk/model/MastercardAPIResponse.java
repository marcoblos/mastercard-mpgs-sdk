package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import com.github.marcoblos.mastercardmpgssdk.domain.MastercardResponseResultType;

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
public class MastercardAPIResponse implements Serializable {

	private static final long serialVersionUID = 1820245868571852443L;

	private MastercardOrder order;

	private MastercardError error;

	private MastercardResponseResultType result;

	private MastercardBrowserPayment browserPayment;

	private String merchant;

	private MastercardResponseGateway response;

	private MastercardTransaction transaction;

}
