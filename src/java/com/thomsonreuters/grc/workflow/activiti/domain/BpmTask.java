package com.thomsonreuters.grc.workflow.activiti.domain;

public class BpmTask {
	
	private String taskId;
	private String taskName;      
	private String title;      
	private String activityName;      
	private String instanceId;  
	private String processId;      
	private String processName; 
	private String executionId;     
	private String acquiredBy;     
	private String assignees;     
	private String reviewers;     
	private String originalAssigneeUser;    
	private String creator;    
	private String updatedBy;    
	private String swimlaneRole;      
	private String createdDate;  
	private String updatedDate;  
	private String dueDate;  
	private String completedDate;  
	private String claimDate;  
	private String priority; 
	private String outcome;      
	private String state; 
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
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
	public String getAcquiredBy() {
		return acquiredBy;
	}
	public void setAcquiredBy(String acquiredBy) {
		this.acquiredBy = acquiredBy;
	}
	public String getAssignees() {
		return assignees;
	}
	public void setAssignees(String assignees) {
		this.assignees = assignees;
	}
	public String getReviewers() {
		return reviewers;
	}
	public void setReviewers(String reviewers) {
		this.reviewers = reviewers;
	}
	public String getOriginalAssigneeUser() {
		return originalAssigneeUser;
	}
	public void setOriginalAssigneeUser(String originalAssigneeUser) {
		this.originalAssigneeUser = originalAssigneeUser;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getSwimlaneRole() {
		return swimlaneRole;
	}
	public void setSwimlaneRole(String swimlaneRole) {
		this.swimlaneRole = swimlaneRole;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
