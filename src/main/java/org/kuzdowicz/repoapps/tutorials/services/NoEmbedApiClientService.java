package org.kuzdowicz.repoapps.tutorials.services;

import org.kuzdowicz.repoapps.tutorials.models.NoEmbedApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class NoEmbedApiClientService {

	private Gson gson;
	private RestTemplate restTemplate;
	private final static String NOEMBED_REQ_LINK = "https://noembed.com/embed?url=";

	@Autowired
	public NoEmbedApiClientService(Gson gson, RestTemplate restTemplate) {
		this.gson = gson;
		this.restTemplate = restTemplate;
	}

	public NoEmbedApiResponse getDataByLink(String videoLink) {

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(NOEMBED_REQ_LINK + videoLink, String.class);
		return gson.fromJson(responseEntity.getBody(), NoEmbedApiResponse.class);
	}

}
