package com.citc.messenger.interloper.model;

import java.io.Serializable;
import java.util.List;

public class ProcessInstance implements Serializable, ActivitiEntity {
	
	private static final long serialVersionUID = 3389644476541172537L;
		public List<ProcessInstanceDetail> data ;
	    public Integer total ;
	    public Integer start ;
	    public String sort ;
	    public String order ;
	    public Integer size ;

	    public List<ProcessInstanceDetail> getData() {
			return data;
		}
		public void setData(List<ProcessInstanceDetail> data) {
			this.data = data;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public Integer getStart() {
			return start;
		}
		public void setStart(Integer start) {
			this.start = start;
		}
		public String getSort() {
			return sort;
		}
		public void setSort(String sort) {
			this.sort = sort;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
	    
	    
	
	

}
