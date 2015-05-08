package com.citc.messenger.interloper.service;

import com.citc.messenger.interloper.model.ActivitiEntity;

public interface ActivitiRestAPI {
	
	public ActivitiEntity findProcessById(Integer processId);
	public void terminateProcessById(ActivitiEntity instance);

}
