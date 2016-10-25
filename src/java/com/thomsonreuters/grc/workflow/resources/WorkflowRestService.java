package com.thomsonreuters.grc.workflow.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;
import com.thomsonreuters.grc.workflow.domain.WorkflowGroup;
import com.thomsonreuters.grc.workflow.domain.WorkflowUser;
import com.thomsonreuters.grc.workflow.service.WorkflowIdentityService;
import com.thomsonreuters.grc.workflow.service.WorkflowTaskService;

@Path("/grcWorkflow")
public class WorkflowRestService {

    @Autowired
    private WorkflowTaskService workflowTaskService;
    @Autowired
    private WorkflowIdentityService workflowIdentityService;

    @GET
    @Path("/test")
    @Produces({ MediaType.TEXT_PLAIN })
    public String test() {
	return "LENS_SUCCESS";
    }

    @GET
    @Path("/createInstance/{processName}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask createInstance(@PathParam("processName") String processName,
	    @QueryParam("workOrderId") String workOrderId) {
	WorkOrderTask ret = workflowTaskService.createInstance(processName, workOrderId);
	return ret;
    }

    @GET
    @Path("/processEngineName")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getProcessEngineName() {
	return workflowTaskService.getProcessEngineName();
    }

    @GET
    @Path("/deployment/{deploymentId}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getDeploymentResources(@PathParam("deploymentId") String deploymentId) {
	List<String> resources = workflowTaskService.listDeploymentsResources(deploymentId);
	StringBuffer returnString = new StringBuffer();
	for (String next : resources) {
	    returnString.append(next);
	    returnString.append("///");
	}

	return returnString.toString();
    }

    @GET
    @Path("/getWorkOrderTask/{taskId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask getWorkOrderTask(@PathParam("taskId") String taskId) {
	WorkOrderTask ret = null;
	try {
	    ret = workflowTaskService.getWorkOrderTask(taskId);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return ret;
    }

    @PUT
    @Path("/updatetWorkOrderTask/{taskId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask updateWorkOrderTask(@PathParam("taskId") String taskId, WorkOrderTask workOrderTask) {
	WorkOrderTask ret = null;
	try {
	    ret = workflowTaskService.updateWorkOrderTask(taskId, workOrderTask);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return ret;
    }

    @PUT
    @Path("{taskId}/{outcome}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask updateTaskWithOutcome(@PathParam("taskId") String taskId, @PathParam("outcome") String outcome,
	    WorkOrderTask workOrderTask) {
	WorkOrderTask ret = null;
	try {
	    ret = workflowTaskService.updateWorkOrderTaskWithOutcome(taskId, outcome, workOrderTask);
	} catch (Exception e) {	   
	    e.printStackTrace();
	}
	return ret;
    }
    

    @PUT
    @Path("/claim/{taskId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public String claimTask(@PathParam("taskId") String taskId) {
	String ret = null;
	try {
	    ret = workflowTaskService.claimTask(taskId);
	} catch (Exception e) {
	    ret = "Failure";
	    e.printStackTrace();
	}
	return ret;
    }
    
    @GET
    @Path("/identity/createUser/{userId}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String createNewUser(@PathParam("userId") String userId){
    	return workflowIdentityService.addUser(userId);
    }

    @GET
    @Path("/identity/createGroup/{groupId}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String createNewGroup(@PathParam("groupId") String groupId, @QueryParam ("groupName")String groupName){
    	
    	return workflowIdentityService.addGroup(groupId, groupName);
    }
    
    @GET
    @Path("/identity/getUser/{userId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkflowUser getUser(@PathParam("userId") String userId){
    	return workflowIdentityService.getUser(userId);
    }

    @GET
    @Path("/identity/getUsers")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<WorkflowUser> getUsers(){
    	return workflowIdentityService.getUsers();
    }

    @GET
    @Path("/identity/getGroup/{groupId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkflowGroup getGroup(@PathParam("groupId") String groupId){
    	return workflowIdentityService.getGroup(groupId);
    }

    @GET
    @Path("/identity/getGroups")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<WorkflowGroup> getGroups(){
    	return workflowIdentityService.getGroups();
    }

    @GET
    @Path("/identity/getGroups/{userId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<WorkflowGroup> getGroupsForUser(@PathParam("userId") String userId){
    	return workflowIdentityService.getGroupsForUser(userId);
    }


    @GET
    @Path("/identity/addUserToGroup")
    @Produces({ MediaType.TEXT_PLAIN })
    public String addUserToGroup(@QueryParam("userId") String userId, @QueryParam("groupId") String groupId){
    	return workflowIdentityService.addUserToGroup(userId, groupId);
    }


    public WorkflowTaskService getWorkflowTaskService() {
	return workflowTaskService;
    }

    public void setWorkflowTaskService(WorkflowTaskService workflowTaskService) {
	this.workflowTaskService = workflowTaskService;
    }

	public WorkflowIdentityService getWorkflowIdentityService() {
		return workflowIdentityService;
	}

	public void setWorkflowIdentityService(WorkflowIdentityService workflowIdentityService) {
		this.workflowIdentityService = workflowIdentityService;
	}

}
