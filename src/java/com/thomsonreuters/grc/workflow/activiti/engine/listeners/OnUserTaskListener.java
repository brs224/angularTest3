package com.thomsonreuters.grc.workflow.activiti.engine.listeners;

import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class OnUserTaskListener implements TaskListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void notify(DelegateTask task) {
	// TODO Auto-generated method stub
	System.out.println("OnUserTaskListener :: delegateTask : " + task.getEventName());
	Map<String, Object> variables = task.getVariables();
	
	switch(task.getEventName()) {
	    case "create" : variables.put("outcomeList", "Save,Submit"); break;
	    case "assignment":  variables.put("outcomeList", "Release,Submit"); break;
	    case "complete":  variables.put("outcomeList", "Rework"); break;
	    default:  variables.put("outcomeList", "Submit, Cancel"); break;
	}
	variables.put("outcomeSource", "Activiti");
	
	System.out.println("Outcomes: " + variables.get("outcomeList"));
	task.setVariables(variables);
    }

}
