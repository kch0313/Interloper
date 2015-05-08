package com.citc.messenger.interloper.service;

import static com.citc.messenger.interloper.service.ActvitiHttpUtils.getAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.citc.messenger.interloper.model.ActivitiEntity;
import com.citc.messenger.interloper.model.ProcessInstance;

@Component
public class ActivitiJRuntimeProxyImpl implements ActivitiRestAPI {

	/**
	 * Base Activiti URL
	 */
	@Value("${activiti.base.url}")
	private String baseUrl;

	/**
	 * Url segment for terminating process by id
	 */
	@Value("${activiti.terminate.url}")
	String terminateUrl;

	/**
	 * Url segment for finding process by id
	 */
	@Value("${activiti.process.url}")
	String processUrl;

	public ActivitiEntity findProcessById(Integer proccessInstanceId) {
		String targetUrl = getUrl(processUrl, proccessInstanceId);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProcessInstance> response = null;
		try {

			HttpEntity<String> request = getAuth();
			response = restTemplate.exchange(targetUrl, HttpMethod.GET,
					request, ProcessInstance.class);
			System.out.println(response.getBody());
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return (ActivitiEntity) response.getBody();
	}


	@Override
	public void terminateProcessById(ActivitiEntity instance) {

		if(!(instance instanceof ProcessInstance)){
			throw new IllegalArgumentException("Expecting ProcessInstance");
		}
		ProcessInstance pi = (ProcessInstance) instance;
		Integer id= new Integer(pi.getData().get(0).getId());
		String targetUrl = getUrl(terminateUrl, id, true);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProcessInstance> response = null;
		try {

			HttpEntity<String> request = getAuth();
			response = restTemplate.exchange(targetUrl, HttpMethod.DELETE,
					request, ProcessInstance.class);
			System.out.println(response.getBody());
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
	}
	private String getUrl(String urlSeg, Integer proccessInstanceId) {
		return getUrl(urlSeg, proccessInstanceId, false);
	}

	
	private String getUrl(String urlSeg, Integer proccessInstanceId, Boolean asPath) {
		UriComponentsBuilder targetUrl = UriComponentsBuilder.fromUriString(baseUrl);
		targetUrl.path(urlSeg);
		if(asPath){
			targetUrl.path("/"+ proccessInstanceId).build();
		}else{
			targetUrl.queryParam("id", proccessInstanceId).build();
		}
				
		return targetUrl.toUriString();
	}


}
