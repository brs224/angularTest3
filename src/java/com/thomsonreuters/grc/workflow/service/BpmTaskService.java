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
import com.thomsonreuters.grc.workflow.domain.DocumentType;
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

	public WorkOrderTask createInstance(String processName, String workOrderId) {
	    WorkOrderTask wot = new WorkOrderTask();
	    
	        Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("workOrderId", workOrderId );		
	        BpmInstance bpmInstance = activitiTaskService.createProcessInstance(processName, variables);	        
		bpmInstance.setCreatedBy("Smitha");
		bpmInstance.setStatus("Initiated");
		bpmDAOImpl.addProcessInstance(bpmInstance);
		bpmDAOImpl.addWorkOrder(workOrderId, bpmInstance.getInstanceid());
		
		BpmTask bpmTask = activitiTaskService.getCurrentTask(bpmInstance.getInstanceid());
		// bpmDAOImpl.addTask(bpmTask);
		wot.setTaskId(bpmTask.getTaskId());
		wot.setWorkOrderId(workOrderId);
		wot.setTaskName(bpmTask.getTaskName());
		String outcomes = (String) bpmTask.getProcessVariables().get("outcomeList");
		
		WorkOrderPayloadType wopt = new WorkOrderPayloadType();
		wopt.setAction(getActionType(outcomes));
		wopt.setOutcomeSource(OutcomeSourceType.ACTIVITI);
		
		WorkOrderType woType = new WorkOrderType();
		
		woType.setSourceDocument(new DocumentType());
		woType.setManualWorkOrder(true);
		
		wopt.setWorkOrder(woType);
		
		wot.setWorkOrderPayload(wopt);
		
		return wot;
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
	
	public WorkOrderTask updateWorkOrderTask(String taskId, WorkOrderTask workOrderTask) {
	    
	    return workOrderTask;
	}
	
	public WorkOrderTask getWorkOrderTask(String taskId) {
	    WorkOrderTask wot = new WorkOrderTask();
	    WorkOrderPayloadType wopt = new WorkOrderPayloadType();
	    wopt.setWorkOrder(getWorkOrderType(taskId));
	    
	    wopt.setOutcomeSource(OutcomeSourceType.ACTIVITI);
	    	    
	    wopt.setAction(getActionType("CreateWorkOrder"));	    
	    wot.setWorkOrderPayload(wopt);
	    wot.setTaskId(taskId);
	    wot.setTaskName("CreateWorkOrder");
	    
	    return wot;
	}
	
	public WorkOrderTask updateWorkOrderTaskWithOutcome(String taskId, String outcome, WorkOrderTask workOrderTask) {
	    WorkOrderTask wot = this.updateWorkOrderTask(taskId,workOrderTask);
	    
	    Map<String, Object> variables = new HashMap<>();
		variables.put("outcome", outcome);
		//variables.put("workstreamcount", wot.getWorkOrderPayload().getWorkOrder().getWorkStreams().getWorkStream().size());
		variables.put("workstreamcount",0);
	    activitiTaskService.completeTask(taskId,variables);
	    return wot;	    
	}
	
	public String claimTask(String taskId) {
	    activitiTaskService.claimTask(taskId);
	    return "Success";	    
	}
	
	public ActionType getActionType(String outcomes) {
	 String[] outcomeArr =  outcomes.split(",");
	 ActionType at = new ActionType();
	 
	 List<OutcomeInfoType> outcomeInfo = new ArrayList<OutcomeInfoType>();
	
	 OutcomeInfoType oti = null;
	 for(int i=0; i<outcomeArr.length; i++) {
	     oti = new OutcomeInfoType();
	     oti.setDescription(outcomeArr[i]);
		 oti.setValue(outcomeArr[i].toUpperCase());
		 outcomeInfo.add(oti);		 
		
	 }
		 
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
	
	public static void main(String[] args) {
	    BpmTaskService bts = new BpmTaskService();
	    bts.getActionType("Save,Submit");
	}

}
