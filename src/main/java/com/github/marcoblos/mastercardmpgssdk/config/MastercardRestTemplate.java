package com.github.marcoblos.mastercardmpgssdk.config;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
public class MastercardRestTemplate extends RestTemplate {

	public MastercardRestTemplate(String merchantId, String apiKey) {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(AuthScope.ANY),
				new UsernamePasswordCredentials("merchant.".concat(merchantId), apiKey));
		HttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		factory.setConnectionRequestTimeout(10 * 1000);
		factory.setReadTimeout(10 * 1000);
		super.setRequestFactory(factory);
		super.setErrorHandler(errorHandler());
	}

	private MastercardResponseErrorHandler errorHandler() {
		MastercardResponseErrorHandler errorHandler = new MastercardResponseErrorHandler();
		return errorHandler;
	}

}
