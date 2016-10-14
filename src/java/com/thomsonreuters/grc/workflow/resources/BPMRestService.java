package com.thomsonreuters.grc.workflow.resources;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;
import com.thomsonreuters.grc.workflow.service.BpmTaskService;

@Path("/grcWorkflow")
public class BPMRestService {

    @Autowired
    private BpmTaskService bpmTaskService;

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
	WorkOrderTask ret = bpmTaskService.createInstance(processName, workOrderId);
	return ret;
    }

    @GET
    @Path("/processEngineName")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getProcessEngineName() {
	return bpmTaskService.getProcessEngineName();
    }

    @GET
    @Path("/deployment/{deploymentId}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getDeploymentResources(@PathParam("deploymentId") String deploymentId) {
	List<String> resources = bpmTaskService.listDeploymentsResources(deploymentId);
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
	    ret = bpmTaskService.getWorkOrderTask(taskId);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return ret;
    }

    @GET
    @Path("/updatetWorkOrderTask/{taskId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask updateWorkOrderTask(@PathParam("taskId") String taskId, WorkOrderTask workOrderTask) {
	WorkOrderTask ret = null;
	try {
	    ret = bpmTaskService.updateWorkOrderTask(taskId, workOrderTask);
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
	    ret = bpmTaskService.updateWorkOrderTaskWithOutcome(taskId, outcome, workOrderTask);
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
	    ret = bpmTaskService.claimTask(taskId);
	} catch (Exception e) {
	    ret = "Failure";
	    e.printStackTrace();
	}
	return ret;
    }

    public BpmTaskService getBpmTaskService() {
	return bpmTaskService;
    }

    public void setBpmTaskService(BpmTaskService bpmTaskService) {
	this.bpmTaskService = bpmTaskService;
    }

}
