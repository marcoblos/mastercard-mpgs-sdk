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
public class MastercardCustomer implements Serializable {

	private static final long serialVersionUID = 7104770628952274920L;

	private String email; // "email from customer that make this order"

}
