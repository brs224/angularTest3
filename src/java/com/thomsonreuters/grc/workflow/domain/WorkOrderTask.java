package com.thomsonreuters.grc.workflow.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workOrderTask")
public class WorkOrderTask {

	private String taskName;
	private WorkOrderPayloadType workOrderPayload;
	private String taskId;
	private String workOrderId;
	
	public String getTaskName() {
	    return taskName;
	}
	public void setTaskName(String taskName) {
	    this.taskName = taskName;
	}
	public WorkOrderPayloadType getWorkOrderPayload() {
	    return workOrderPayload;
	}
	public void setWorkOrderPayload(WorkOrderPayloadType workOrderPayload) {
	    this.workOrderPayload = workOrderPayload;
	}
	
	public String getTaskId() {
	    return taskId;
	}
	public void setTaskId(String taskId) {
	    this.taskId = taskId;
	}
	public String getWorkOrderId() {
	    return workOrderId;
	}
	public void setWorkOrderId(String workOrderId) {
	    this.workOrderId = workOrderId;
	}		

}
