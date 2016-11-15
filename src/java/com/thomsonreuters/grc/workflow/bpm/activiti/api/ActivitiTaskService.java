/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.activiti.api;

import java.util.List;
import java.util.Map;

import com.thomsonreuters.grc.workflow.bpm.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.bpm.domain.BpmTask;
import com.thomsonreuters.grc.workflow.workspace.domain.TaskSearchParams;

/**
 * Service which provides access to Activiti Bpm Task and related operations
 */
public interface ActivitiTaskService {

    /**
     * Creates a new process instance for given parameters
     *
     * @param processName
     * @param variables
     * 
     * @return BpmInstance
     */
    public BpmInstance createProcessInstance(String processName, Map<String, Object> variables);

    /**
     * Called when the task is successfully executed, and the required task
     * paramaters are given by the end-user.
     * 
     * @param taskId Unique identifier of the user task
     * @param variables
     */
    public void completeTask(String taskId, Map<String, Object> variables);

    /**
     * Claims responsibility for a task with the given ID: the given assignee is
     * made assignee for the task.
     *
     * @param taskId Unique identifier of the user task
     * @param assignee User who claims the task
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
     * Reassigns a task
     *
     * @param taskId Unique identifier of the user task
     * @param assignee User to whom the task is reassigned
     */
    public void reassignTask(String taskId, String assignee);

    /**
     * Retrieves the current active task for the given process instance Id
     *
     * @param processInstanceId
     *            Unique identifier of the process instance
     *            
     * @return BpmTask          
     */
    public BpmTask getCurrentTask(String processInstanceId);

    /**
     * Retrieves Tasks based on the Search Parameters
     *
     * @param taskSearchParams
     * 
     * @return List<BpmTask>
     */
    public List<BpmTask> getTasks(TaskSearchParams taskSearchParams);

}