package com.thomsonreuters.grc.workflow.activiti.engine.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class OnGateWayEntryListener implements ExecutionListener {

	private static final long serialVersionUID = -4699080415075061353L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessInstanceId();
		String activitiName = execution.getCurrentActivityId();
		System.out.println("OnGateWayEntryListener: ["+activitiName + "] ");			
		String approvalneeded = (String) execution.getVariable("approvalneeded");
		if(approvalneeded.equalsIgnoreCase("yes")) {
			execution.setVariable("approval", "flowapproval");
		} else {
			execution.setVariable("approval", "none");
		}
	}
}