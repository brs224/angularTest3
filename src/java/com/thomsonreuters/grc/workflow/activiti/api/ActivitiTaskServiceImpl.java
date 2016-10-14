package com.thomsonreuters.grc.workflow.activiti.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.grc.workflow.activiti.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.activiti.domain.BpmTask;

public class ActivitiTaskServiceImpl {

    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;

    public BpmInstance createProcessInstance(String processName, Map<String, Object> variables) {
	BpmInstance bpmInstance = new BpmInstance();
	ProcessInstance instance = runtimeService.startProcessInstanceByKey(processName, variables);

	bpmInstance.setExecutionId(instance.getId());
	bpmInstance.setInstanceid(instance.getProcessInstanceId());
	bpmInstance.setProcessId(instance.getProcessDefinitionId());
	bpmInstance.setProcessName(instance.getProcessDefinitionName());

	System.out.println("instance: " + instance.getId() + " ; " + instance.getProcessDefinitionId() + " ; "
		+ instance.getProcessDefinitionId());
	return bpmInstance;
    }

    public ProcessEngine getProcessEngine() {
	return processEngine;
    }

    public void setProcessEngine(ProcessEngine processEngine) {
	this.processEngine = processEngine;
    }

    public void completeTask(String taskId, Map<String,Object> variables) {
	taskService.complete(taskId, variables);
    }
    
    
    public void claimTask(String taskId) {
	taskService.claim(taskId, "Smitha");
    }

    public String processEngineName() {
	return processEngine.getName();
    }

    public List<String> listDeploymentsResources(String deploymentId) {
	return repositoryService.getDeploymentResourceNames(deploymentId);
    }

    public BpmTask getCurrentTask(String processInstanceId) {
	BpmTask bpmTask = null;
	TaskQuery query = taskService.createTaskQuery().processInstanceId(processInstanceId).includeProcessVariables();
	Task task = query.singleResult();
	if(task!=null) {
	    bpmTask = new BpmTask();
	    bpmTask.setTaskId(task.getId());
	    bpmTask.setAssignees(task.getAssignee());
	    bpmTask.setActivityName(task.getName());
	    bpmTask.setInstanceId(task.getProcessInstanceId()); 
	    bpmTask.setTaskName(task.getTaskDefinitionKey());
	    bpmTask.setProcessVariables(task.getProcessVariables());
    
	}
	return bpmTask;
    }

    /*
     * public void assignTask(BpmInstance bpmInstance, String
     * assigneeWestUserId) { TaskService taskService =
     * processEngine.getTaskService(); Task task = getActivitiTask(bpmInstance,
     * taskService); taskService.setAssignee(task.getId(), assigneeWestUserId );
     * return; }
     * 
     * public void unAssignTask(BpmInstance bpmInstance) { TaskService
     * taskService = processEngine.getTaskService(); Task task =
     * getActivitiTask(bpmInstance, taskService);
     * taskService.setAssignee(task.getId(), null ); return; }
     * 
     * 
     * 
     * private Task getActivitiTask(BpmInstance bpmInstance, TaskService
     * taskService) { String activityName =
     * bpmInstance.getBpmActivity().getActivityName(); ProcessInstanceQuery
     * query = processEngine.getRuntimeService().createProcessInstanceQuery();
     * ProcessInstance processInstance =
     * query.processInstanceId(bat.getBpmProjectThread().
     * getBpmFulfillmentProject().getFuegoInstanceNumber().toString()).
     * singleResult(); Task task =
     * taskService.createTaskQuery().processInstanceId(processInstance.getId()).
     * taskDefinitionKey(activityName).active().singleResult(); return task; }
     */

}
