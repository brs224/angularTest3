/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.dao;

import com.thomsonreuters.grc.workflow.bpm.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.bpm.domain.BpmTask;
import com.thomsonreuters.grc.workflow.domain.WorkOrderType;

/**
 * Provides operations to be performed on GRC Workflow database
 */
public interface WorkflowDAO {

    /**
     * Inserts Bpm Instance data into the table
     *
     * @param bpmInstance
     */
    public void addProcessInstance(BpmInstance bpmInstance);

    /**
     * Inserts Bpm task data into the table
     *
     * @param bpmTask
     * 
     */
    public void addTask(BpmTask bpmTask);

    /**
     * Inserts Work Order data into the table
     *
     * @param workOrderId
     * @param instanceId
     */
    public void addWorkOrder(String workOrderId, String instanceId);

    /**
     * Retrives Work Order data for a given task Id
     *
     * @param taskId
     * 
     * @return WorkOrderType
     */
    public WorkOrderType getWorkOrderTask(String taskId);

}
