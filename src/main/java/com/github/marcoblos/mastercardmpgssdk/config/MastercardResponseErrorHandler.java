package com.github.marcoblos.mastercardmpgssdk.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * Extends Spring's default implementation of the {@link ResponseErrorHandler} interface.
 *
 * <p>
 * This error handler checks for the status code on the {@link ClientHttpResponse}: Any code with series {@link org.springframework.http.HttpStatus.Series#CLIENT_ERROR} or
 * {@link org.springframework.http.HttpStatus.Series#SERVER_ERROR} except 400 is considered to be an error; this behavior can be changed by overriding the {@link #hasError(HttpStatus)} method. Unknown
 * status codes will be ignored by {@link #hasError(ClientHttpResponse)}.
 *
 * @author marcoblos 2018-02-22
 * 
 * @see RestTemplate#setErrorHandler
 */
public class MastercardResponseErrorHandler extends DefaultResponseErrorHandler {

	/**
	 * Template method called from {@link #hasError(ClientHttpResponse)}.
	 * <p>
	 * The default implementation checks if the given status code is {@link HttpStatus.Series#CLIENT_ERROR CLIENT_ERROR} or {@link HttpStatus.Series#SERVER_ERROR SERVER_ERROR}. Can be overridden in
	 * subclasses.
	 * 
	 * @param statusCode the HTTP status code
	 * @return {@code true} if the response has an error; {@code false} otherwise
	 * @see #getHttpStatusCode(ClientHttpResponse)
	 */
	protected boolean hasError(HttpStatus statusCode) {
		return HttpStatus.BAD_REQUEST.equals(statusCode) ? false : defaultValidator(statusCode);
	}

	private boolean defaultValidator(HttpStatus statusCode) {
		return statusCode.series() == HttpStatus.Series.CLIENT_ERROR ||
				statusCode.series() == HttpStatus.Series.SERVER_ERROR;
	}

}
