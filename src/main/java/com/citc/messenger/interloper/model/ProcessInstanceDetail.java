package com.citc.messenger.interloper.model;

import java.io.Serializable;
import java.util.List;

public class ProcessInstanceDetail implements Serializable {

	private static final long serialVersionUID = 5792181496722376659L;
	public String id ;
    public String url ;
    public Object businessKey ;
    public Boolean suspended ;
    public Boolean ended ;
    public String processDefinitionId ;
    public String processDefinitionUrl ;
    public String activityId ;
    public List<Object> variables ;
    public String tenantId ;
    public Boolean completed ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Object getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(Object businessKey) {
		this.businessKey = businessKey;
	}
	public Boolean getSuspended() {
		return suspended;
	}
	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}
	public Boolean getEnded() {
		return ended;
	}
	public void setEnded(Boolean ended) {
		this.ended = ended;
	}
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public String getProcessDefinitionUrl() {
		return processDefinitionUrl;
	}
	public void setProcessDefinitionUrl(String processDefinitionUrl) {
		this.processDefinitionUrl = processDefinitionUrl;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public List<Object> getVariables() {
		return variables;
	}
	public void setVariables(List<Object> variables) {
		this.variables = variables;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
    
    

	
}
