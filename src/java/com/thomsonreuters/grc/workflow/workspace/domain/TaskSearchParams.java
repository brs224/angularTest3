/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.workspace.domain;

import javax.ws.rs.QueryParam;

public class TaskSearchParams {

    private @QueryParam("process") String process;
    private @QueryParam("task") String task;
    private @QueryParam("assignmentState") String assignmentState;
    private @QueryParam("assignee") String assignee;
    private @QueryParam("group") String group;
    private @QueryParam("taskStatus") String taskStatus;
    
    public String getProcess() {
        return process;
    }
    public void setProcess(String process) {
        this.process = process;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getAssignmentState() {
        return assignmentState;
    }
    public void setAssignmentState(String assignmentState) {
        this.assignmentState = assignmentState;
    }
    public String getAssignee() {
        return assignee;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
       
}
