package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

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
public class MastercardBrowserPayment implements Serializable {

	private static final long serialVersionUID = -1665919229466466372L;

	private String redirectUrl;

}
