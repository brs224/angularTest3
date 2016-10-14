package com.thomsonreuters.grc.workflow.activiti.engine.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class OnHumanTaskListener implements ExecutionListener{

	private static final long serialVersionUID = -2136360869424262505L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
	    
	        String instanceId = execution.getProcessInstanceId();
		String activitiName = execution.getCurrentActivityId();
		System.out.println("OnHumanTaskListerner: ["+activitiName + ": " + instanceId +  "] ");			
		
	}

}
