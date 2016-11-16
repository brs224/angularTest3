/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.workspace.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grctask")
public class GrcTask {

    private String title;
    private String taskId;
    private String taskName;
    private String instanceid;
    private String process;
    private int workOrderId;
    private String region;
    private String regulator;
    private String jurisdiction;
    private String sourceCitation;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
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
    public String getInstanceid() {
        return instanceid;
    }
    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }
    public String getProcess() {
        return process;
    }
    public void setProcess(String process) {
        this.process = process;
    }
    public int getWorkOrderId() {
        return workOrderId;
    }
    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegulator() {
        return regulator;
    }
    public void setRegulator(String regulator) {
        this.regulator = regulator;
    }
    public String getJurisdiction() {
        return jurisdiction;
    }
    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
    public String getSourceCitation() {
        return sourceCitation;
    }
    public void setSourceCitation(String sourceCitation) {
        this.sourceCitation = sourceCitation;
    }
       
}
