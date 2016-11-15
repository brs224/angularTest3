/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.service;

import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;

/**
 * Service which provides access to Work Order Task and related operations.
 */
public interface WorkOrderService {

    /**
     * Returns Work Order Payload for a given taskId
     *
     * @param taskId
     *            Unique identifier of the user task
     * 
     * @return WorkOrderTask
     */
    public WorkOrderTask getWorkOrderTask(String taskId);

    /**
     * Updates database with the provided Work Order Payload for a given taskId
     *
     * @param taskId
     *            Unique identifier of the user task
     * @param workOrderTask
     *            Work Order payload
     * 
     * @return WorkOrderTask
     */
    public WorkOrderTask updateWorkOrderTask(String taskId, WorkOrderTask workOrderTask);

    /**
     * Updates database with the provided Work Order Payload for a given taskId
     * and completes the user task with the given outcome
     *
     * @param workOrderTask
     *            Work Order payload
     * @param taskId
     *            Unique identifier of the user task
     * @param outcome
     *            outcome of the task
     * 
     * @return WorkOrderTask
     */
    public WorkOrderTask updateWorkOrderTaskWithOutcome(String taskId, String outcome, WorkOrderTask workOrderTask);

}