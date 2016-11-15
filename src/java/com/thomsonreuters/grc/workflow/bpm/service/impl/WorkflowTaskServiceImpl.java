/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.service.impl;

import java.util.List;
import java.util.Map;

import com.thomsonreuters.grc.workflow.bpm.service.WorkflowTaskService;
import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;
/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
import com.thomsonreuters.grc.workflow.workspace.domain.CreateTaskParams;
import com.thomsonreuters.grc.workflow.workspace.domain.GrcTask;
import com.thomsonreuters.grc.workflow.workspace.domain.TaskSearchParams;

public class WorkflowTaskServiceImpl implements WorkflowTaskService{

    @Override
    public WorkOrderTask createInstance(CreateTaskParams createTaskParams) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void claimTask(String taskId, String assignee) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void releaseTask(String taskId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reassignTask(String taskId, String assignee) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> variables) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<GrcTask> getTasks(TaskSearchParams taskSearchParams) {
        // TODO Auto-generated method stub
        return null;
    }

}
