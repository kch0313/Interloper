package com.citc.messenger.interloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citc.messenger.interloper.model.ActivitiEntity;
import com.citc.messenger.interloper.model.ProcessInstance;
import com.citc.messenger.interloper.service.ActivitiJRuntimeProxyImpl;

@RestController
public class KillEndPoint {

		@Autowired(required=true)
		ActivitiJRuntimeProxyImpl runtimeApi;
	
	    @RequestMapping("/killproc")
	    public ActivitiEntity killproc(@RequestParam(value="id", defaultValue="0") Integer id) {

	    	System.out.println("Trying to locate and kill Process instance " + id );
	    	
	    	ActivitiEntity instance= (ActivitiEntity) runtimeApi.findProcessById(id);
	    	if(instance != null){
	    		System.out.println("*** Process ***");
	    		ProcessInstance processInstance= (ProcessInstance)instance;
	    		System.out.println(processInstance.getData().get(0).getProcessDefinitionId());
	    		runtimeApi.terminateProcessById(instance);
	    	}
	    	
	    	
	        return instance;
	    } 

}
