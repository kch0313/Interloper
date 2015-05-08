package com.citc.messenger.interloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citc.messenger.interloper.amqp.ProcessListener;

@RestController
public class KillEndPoint {

		@Autowired(required=true)
		ProcessListener listener;
	
	    @RequestMapping("/killproc")
	    public String killproc(@RequestParam(value="id", defaultValue="0") Integer id) {
	    	listener.sendMessage(id);
	        return String.format("{status:200, description:message recieved to kill process id %d}", id);
	    } 

}
