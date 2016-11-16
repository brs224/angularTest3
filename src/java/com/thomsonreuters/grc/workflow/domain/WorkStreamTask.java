/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workStreamTask")
public class WorkStreamTask {
    
    public String taskName;
    public String taskId;
    public String workOrderId;
    public String workStreamId;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public String getWorkStreamId() {
        return workStreamId;
    }

    public void setWorkStreamId(String workStreamId) {
        this.workStreamId = workStreamId;
    }

}
