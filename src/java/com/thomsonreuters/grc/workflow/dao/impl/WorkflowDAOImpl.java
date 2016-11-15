/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.dao.impl;

import com.thomsonreuters.grc.workflow.bpm.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.bpm.domain.BpmTask;
import com.thomsonreuters.grc.workflow.dao.WorkflowDAO;
import com.thomsonreuters.grc.workflow.domain.WorkOrderType;

public class WorkflowDAOImpl implements WorkflowDAO {

    @Override
    public void addProcessInstance(BpmInstance bpmInstance) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTask(BpmTask bpmTask) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addWorkOrder(String workOrderId, String instanceId) {
        // TODO Auto-generated method stub

    }

    @Override
    public WorkOrderType getWorkOrderTask(String taskId) {
        // TODO Auto-generated method stub
        return null;
    }
}
