package com.thomsonreuters.grc.workflow.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.grc.workflow.activiti.api.ActivitiTaskServiceImpl;
import com.thomsonreuters.grc.workflow.activiti.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.activiti.domain.BpmTask;
import com.thomsonreuters.grc.workflow.dao.impl.BpmDAOImpl;
import com.thomsonreuters.grc.workflow.domain.ActionType;
import com.thomsonreuters.grc.workflow.domain.OutcomeInfoType;
import com.thomsonreuters.grc.workflow.domain.OutcomeList;
import com.thomsonreuters.grc.workflow.domain.OutcomeSourceType;
import com.thomsonreuters.grc.workflow.domain.WorkOrderPayloadType;
import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;
import com.thomsonreuters.grc.workflow.domain.WorkOrderType;
import com.thomsonreuters.grc.workflow.domain.WorkStreamListType;

public class BpmTaskService {

	@Autowired
	private ActivitiTaskServiceImpl activitiTaskService;
	@Autowired
	private BpmDAOImpl bpmDAOImpl;

	public String createInstance(String processName, String workOrderId) {
	    
	        Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("workOrderId", workOrderId );	
	        BpmInstance bpmInstance = activitiTaskService.createProcessInstance(processName, variables);	        
		bpmInstance.setCreatedBy("Smitha");
		bpmInstance.setStatus("Initiated");
		bpmDAOImpl.addProcessInstance(bpmInstance);
		bpmDAOImpl.addWorkOrder(workOrderId, bpmInstance.getInstanceid());
		
		BpmTask bpmTask = activitiTaskService.getCurrentTask(bpmInstance.getInstanceid());
		// bpmDAOImpl.addTask(bpmTask);
		return "Instance Created";

	}
	
	public WorkOrderType getWorkOrderType(String taskId) {
	    WorkOrderType wot = bpmDAOImpl.getWorkOrderTask(taskId);

	    if(wot!=null) {
	        WorkStreamListType wslt = new WorkStreamListType();
		wslt.setWorkStream(bpmDAOImpl.getWorkStreamTaskList(taskId));
		wot.setWorkStreams(wslt);
	    }
	    return wot;
	}
	
	public WorkOrderTask updateWorkOrderTask(String taskId, WorkOrderTask workOrderPayload) {
	    return workOrderPayload;
	}
	
	public WorkOrderTask getWorkOrderTask(String taskId) {
	    WorkOrderTask wot = new WorkOrderTask();
	    WorkOrderPayloadType wopt = new WorkOrderPayloadType();
	    wopt.setWorkOrder(getWorkOrderType(taskId));
	    
	    wopt.setOutcomeSource(OutcomeSourceType.ACTVITI);
	    
	    
	    wopt.setAction(getActionType("CreateWorkOrder"));
	    
	    wot.setWorkOrderPayload(wopt);
	    wot.setTaskId(taskId);
	    wot.setTaskName("CreateWorkOrder");
	    
	    return wot;
	}
	
	public ActionType getActionType(String taskName) {
	 ActionType at = new ActionType();
	 
	 List<OutcomeInfoType> outcomeInfo = new ArrayList<OutcomeInfoType>();
	 OutcomeInfoType oti = new OutcomeInfoType();
	 oti.setDescription("Cancel");
	 oti.setValue("CANCEL");
	 outcomeInfo.add(oti);
	 
	 oti = new OutcomeInfoType();
	 oti.setDescription("Submit");
	 oti.setValue("SUBMIT");
	 outcomeInfo.add(oti);
	 
	 OutcomeList outcomeList = new OutcomeList();
	 outcomeList.setOutcomeInfo(outcomeInfo);
	 at.setOutcomeList(outcomeList);
	 return at;
	}
	
	public List<String> listDeploymentsResources(String deploymentId){
		return activitiTaskService.listDeploymentsResources(deploymentId);
	}
	
	public String getProcessEngineName(){
		return activitiTaskService.processEngineName();
	}

	public ActivitiTaskServiceImpl getActivitiTaskService() {
		return activitiTaskService;
	}

	public void setActivitiTaskService(ActivitiTaskServiceImpl activitiTaskService) {
		this.activitiTaskService = activitiTaskService;
	}

	public BpmDAOImpl getBpmDAOImpl() {
		return bpmDAOImpl;
	}

	public void setBpmDAOImpl(BpmDAOImpl bpmDAOImpl) {
		this.bpmDAOImpl = bpmDAOImpl;
	}	

}
