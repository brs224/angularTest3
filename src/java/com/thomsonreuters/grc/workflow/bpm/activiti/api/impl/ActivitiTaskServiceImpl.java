/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.activiti.api.impl;

import java.util.List;
import java.util.Map;

import com.thomsonreuters.grc.workflow.bpm.activiti.api.ActivitiTaskService;
import com.thomsonreuters.grc.workflow.bpm.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.bpm.domain.BpmTask;
import com.thomsonreuters.grc.workflow.workspace.domain.TaskSearchParams;

public class ActivitiTaskServiceImpl implements ActivitiTaskService{

    @Override
    public BpmInstance createProcessInstance(String processName, Map<String, Object> variables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> variables) {
        // TODO Auto-generated method stub
        
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
    public BpmTask getCurrentTask(String processInstanceId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BpmTask> getTasks(TaskSearchParams taskSearchParams) {
        // TODO Auto-generated method stub
        return null;
    }

}
