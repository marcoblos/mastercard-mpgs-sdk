package com.github.marcoblos.mastercardmpgssdk.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author marcoblos 2018-03-22
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class MastercardWallet implements Serializable {

	private static final long serialVersionUID = -4667239087792153086L;

	private MastercardMasterpass masterpass;

}
