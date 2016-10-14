package com.thomsonreuters.grc.workflow.activiti.domain;

public class BpmInstance {
	
	private String instanceid;
	private String processId;
	private String processName;
	private String executionId;
	private String parentInstanceId;
	private String createdBy;
	private String updatedBy;
	private String status;
	private String grcPayloadId;
	public String getInstanceid() {
		return instanceid;
	}
	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public String getParentInstanceId() {
		return parentInstanceId;
	}
	public void setParentInstanceId(String parentInstanceId) {
		this.parentInstanceId = parentInstanceId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGrcPayloadId() {
		return grcPayloadId;
	}
	public void setGrcPayloadId(String grcPayloadId) {
		this.grcPayloadId = grcPayloadId;
	}

	 /*STARTDATE TIMESTAMP(6) 
	 ENDDATE TIMESTAMP(6) */
}
