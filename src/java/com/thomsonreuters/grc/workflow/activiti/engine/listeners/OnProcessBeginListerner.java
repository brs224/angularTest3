package com.thomsonreuters.grc.workflow.activiti.engine.listeners;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class OnProcessBeginListerner implements ExecutionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8886315157081715990L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessInstanceId();
		String activitiName = execution.getCurrentActivityId();
		System.out.println("OnProcessBeginListerner: ["+activitiName + "] ");	
		
		RuntimeService runtimeService = execution.getEngineServices().getRuntimeService();
		
	//	Map<String, Object> variables = runtimeService.getVariables(instanceId);
		//String priority = (String) variables.get("priority");
	//	variables.put("priority", "low");
		execution.setVariable("priority", "low");
		System.out.println("getProcessDefinitionId: "+execution.getProcessDefinitionId());
		String[] parts = execution.getProcessDefinitionId().split("[:]");
		System.out.println("/" + parts[0] + "#Default-" + parts[1] + ".0");

		System.out.println("getProcessInstanceId: "+execution.getProcessInstanceId());
	}
}
