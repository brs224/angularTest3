/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.bpm.activiti.engine.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class OnServiceTaskListerner implements ExecutionListener {

    private static final long serialVersionUID = -6364020016157002136L;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        try {
            String instanceId = execution.getProcessInstanceId();
            String activitiName = execution.getCurrentActivityId();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}