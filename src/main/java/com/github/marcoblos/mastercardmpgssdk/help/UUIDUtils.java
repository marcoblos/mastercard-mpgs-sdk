package com.github.marcoblos.mastercardmpgssdk.help;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class UUIDUtils {

	private static final int DEFAULT_LENGTH = 12;

	private UUIDUtils() {
	}

	/**
	 * Generate unique token with 12 characters
	 * 
	 * @return String
	 */
	public static String generate() {
		return generate(DEFAULT_LENGTH);
	}

	/**
	 * Generate unique token with quantity parameter, max value is 48 if quantity parameter is great than 48 assume that parameter is 48
	 * 
	 * @param length the size of string
	 * @return String
	 */
	public static String generate(int length) {
		String uid = UUID.randomUUID().toString();
		byte[] b = Base64.encodeBase64(uid.getBytes());
		return new String(b).substring(0, length > 48 ? 48 : length);
	}

}
