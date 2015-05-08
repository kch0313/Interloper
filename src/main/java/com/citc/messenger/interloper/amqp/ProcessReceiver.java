package com.citc.messenger.interloper.amqp;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

import com.citc.messenger.interloper.service.ActivitiJRuntimeProxyImpl;
import com.citc.messenger.interloper.model.ActivitiEntity;
import com.citc.messenger.interloper.model.ProcessInstance;


public class ProcessReceiver {
	
	@Autowired(required=true)
	ActivitiJRuntimeProxyImpl runtimeApi;
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(Integer id) {
		System.out.println("Trying to locate and kill Process instance " + id );
    	ActivitiEntity instance= (ActivitiEntity) runtimeApi.findProcessById(id);
    	if(instance != null){
    		System.out.println("*** Process ***");
    		ProcessInstance processInstance= (ProcessInstance)instance;
    		System.out.println(processInstance.getData().get(0).getProcessDefinitionId());
    		runtimeApi.terminateProcessById(instance);
    	}
		latch.countDown();
	}
	
	

	public CountDownLatch getLatch() {
		return latch;
	}

}
