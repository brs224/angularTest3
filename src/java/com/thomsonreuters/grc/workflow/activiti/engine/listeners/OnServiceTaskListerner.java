package com.thomsonreuters.grc.workflow.activiti.engine.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class OnServiceTaskListerner implements ExecutionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6364020016157002136L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessInstanceId();
		String activitiName = execution.getCurrentActivityId();
		String priority = (String) execution.getVariable("priority");
		System.out.println("OnServiceTaskListerner: ["+activitiName + "] ");	
		if(activitiName.equalsIgnoreCase("initialtask")) {
			System.out.println("priority: "+ priority);
			if(priority.equalsIgnoreCase("high")) {
				execution.setVariable("approvalneeded", "yes");
			} else {
				execution.setVariable("approvalneeded", "no");

			}
		}
		
	}

}
