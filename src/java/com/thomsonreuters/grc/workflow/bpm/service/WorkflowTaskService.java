/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.service;

import java.util.List;
import java.util.Map;

import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;
import com.thomsonreuters.grc.workflow.workspace.domain.CreateTaskParams;
import com.thomsonreuters.grc.workflow.workspace.domain.GrcTask;
import com.thomsonreuters.grc.workflow.workspace.domain.TaskSearchParams;

/**
 * Service which provides access to Workflow Task and related operations in the
 * BPM workflow.
 */
public interface WorkflowTaskService {

    /**
     * Creates a new process instance for given parameters
     *
     * @param createTaskParams
     *            processName, taskName and createdBy
     * 
     * @return WorkOrderTask
     */
    public WorkOrderTask createInstance(CreateTaskParams createTaskParams);

    /**
     * Claims responsibility for a task with the given ID: the given assignee is
     * made assignee for the task.
     *
     * @param taskId
     *            Unique identifier of the user task
     * @param assignee
     *            User who claims the task
     */
    public void claimTask(String taskId, String assignee);

    /**
     * Releases a task to the initially assigned group
     *
     * @param taskId
     *            Unique identifier of the user task
     */
    public void releaseTask(String taskId);

    /**
     * Reassigns a task to the given assignee
     *
     * @param taskId
     *            Unique identifier of the user task
     * @param assignee
     *            User to whom the task is reassigned
     */
    public void reassignTask(String taskId, String assignee);

    /**
     * Called when the task is successfully executed, and the required task
     * paramaters are given by the end-user.
     * 
     * @param taskId
     *            Unique identifier of the user task
     * @param variables
     *            process data specific to the given task
     */
    public void completeTask(String taskId, Map<String, Object> variables);

    /**
     * Retrieves Tasks based on the Search Parameters
     *
     * @param taskSearchParams task search parameters
     * 
     * @return List<GrcTask>
     */
    public List<GrcTask> getTasks(TaskSearchParams taskSearchParams);

}