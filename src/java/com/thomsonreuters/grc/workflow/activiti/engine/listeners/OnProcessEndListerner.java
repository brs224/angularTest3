package com.thomsonreuters.grc.workflow.activiti.engine.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class OnProcessEndListerner implements ExecutionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6801625789768052028L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String activitiName = execution.getCurrentActivityId();
		System.out.println("OnProcessEndListerner: ["+activitiName + "] ");		
		String approvalneeded = (String) execution.getVariable("approvalneeded");
		if(approvalneeded.equalsIgnoreCase("yes")) {
			System.out.println("Approved");
		} else {
			System.out.println("Pre Approved");
		}
	}

}
