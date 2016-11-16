/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.service;

import com.thomsonreuters.grc.workflow.domain.WorkStreamTask;

/**
 * Service which provides access to WorkStream Task and related operations.
 */
public interface WorkStreamService {

    /**
     * Returns Work Stream Payload for a given taskId
     *
     * @param taskId
     *            Unique identifier of the user task
     * 
     * @return WorkStreamTask
     */
    public WorkStreamTask getWorkStreamTask(String taskId);

    /**
     * Updates database with the provided Work Stream Payload for a given taskId
     *
     * @param taskId
     *            Unique identifier of the user task
     * @param workStreamTask
     *            Work Stream payload
     * 
     * @return WorkStreamTask
     */
    public WorkStreamTask updateWorkStreamTask(String taskId, WorkStreamTask workStreamTask);

    /**
     * Updates database with the provided Work Stream Payload for a given taskId
     * and completes the user task with the given outcome
     *
     * @param workStreamTask
     *            Work Stream payload
     * @param taskId
     *            Unique identifier of the user task
     * @param outcome
     *            outcome of the task
     * 
     * @return WorkStreamTask
     */
    public WorkStreamTask updateWorkStreamTaskWithOutcome(String taskId, String outcome, WorkStreamTask workStreamTask);

}