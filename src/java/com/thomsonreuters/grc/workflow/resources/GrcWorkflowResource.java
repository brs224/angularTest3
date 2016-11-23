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

import com.thomsonreuters.grc.workflow.bpm.service.WorkflowTaskService;
import com.thomsonreuters.grc.workflow.domain.WorkOrderTask;
import com.thomsonreuters.grc.workflow.domain.WorkStreamTask;
import com.thomsonreuters.grc.workflow.workspace.domain.*;

/*
Class: GrcWorkflowResource
*/
@Path("/grcWorkflow")
public class GrcWorkflowResource {

    @Autowired
    private WorkflowTaskService workflowTaskService;
    
    @GET
    @Path("/processEngineName")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getProcessEngineName() {
	
	return null;
    }
    
    @GET
    @Path("/deployment/{deploymentId}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getDeploymentResources(@PathParam("deploymentId") String deploymentId) {
	
	return null;
    }

    /**
     * Function: CreateInstance
     * 
     * Creates a new instance of a given process
     * 
     * URL - /bpmInstance
     * Method - POST
     * Consumes - application/json
     * Produces - application/json
     * 
     * Required CreateTaskParams
     *     CreateTaskParams
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/bpmInstance
     *     
     * Example POST Body:
     *  {
     *    "processName": "workorder",
     *    "taskName": "CreateWorkOrderFromBench",
     *    "createdBy": "UserABC"
     *  }
     * 
     */
    @POST
    @Path("/bpmInstance")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask createInstance(CreateTaskParams createTaskParams) {
        
        return null;
    } 
  
    /**
     * Function: GetWorkOrderTask
     * 
     * Retrieves WorkOrderTask for a given taskId
     * 
     * URL - /workOrderTasks
     * Method - GET
     * Produces - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     *     
     * Returns:
     *     WorkOrderTask
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/workOrderTasks/10
     * 
     */
    @GET
    @Path("/workOrderTasks/{taskId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask getWorkOrderTask(@PathParam("taskId") String taskId) {

        return null;
    }

    /**
     * Function: UpdateWorkOrderTask
     * 
     * Updates WorkOrderTask for a given taskId
     * 
     * URL - /workOrderTasks
     * Method - PUT
     * Consumes - application/json
     * Produces - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/workOrderTasks/10
     * 
     * Example POST Body:
     * {
     *  "taskId": "100000",
     *  "taskName": "CreateWorkOrderFromBench",
     *  "workOrderId": "10",
     *  "workOrderPayload": {
     *      "workOrder": {
     *          ..
     *       }
     *   }
     * }
     */
    @PUT
    @Path("/workOrderTasks/{taskId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask updateWorkOrderTask(@PathParam("taskId") String taskId, WorkOrderTask workOrderTask) {

        return null;
    }
    
    /**
     * Function: UpdateWorkOrderTaskWithOutcome
     * 
     * Completes WorkOrderTask for a given taskId with a given outcome
     * 
     * URL - /workOrderTasks
     * Method - PUT
     * Consumes - application/json
     * Produces - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     *     outcome - The outcome of the task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/workOrderTasks/10/Submit
     * 
     * Example POST Body:
     * {
     *  "taskId": "100000",
     *  "taskName": "CreateWorkOrderFromBench",
     *  "workOrderId": "10",
     *  "workOrderPayload": {
     *      "workOrder": {
     *          ..
     *       }
     *   }
     * }
     */
    @PUT
    @Path("/workOrderTasks/{taskId}/{outcome}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkOrderTask updateWorkOrderTaskWithOutcome(@PathParam("taskId") String taskId, @PathParam("outcome") String outcome,
        WorkOrderTask workOrderTask) {

        return null;
    }
        
    /**
     * Function: GetWorkStreamTask
     * 
     * Retrieves WorkStreamTask for a given taskId
     * 
     * URL - /workStreamTasks
     * Method - GET
     * Produces - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     *     
     * Returns:
     *     WorkStreamTask 
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/workStreamTasks/10
     * 
     */
    @GET
    @Path("/workStreamTasks/{taskId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkStreamTask getWorkStreamTask(@PathParam("taskId") String taskId) {

        return null;
    }

    /**
     * Function: UpdateWorkStreamTask
     * 
     * Updates WorkStreamTask for a given taskId
     * 
     * URL - /workStreamTasks
     * Method - PUT
     * Consumes - application/json
     * Produces - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/workStreamTasks/10
     * 
     * Example POST Body:
     * {
     *  "taskId": "100000",
     *  "taskName": "CreateWorkOrderFromBench",
     *  "workStreamPayload": {
     *      "country": {
     *          ..
     *       }
     *   }
     * }
     */
    @PUT
    @Path("/workStreamTasks/{taskId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkStreamTask updateWorkStreamTask(@PathParam("taskId") String taskId, WorkStreamTask workStreamTask) {

        return null;
    }

    /**
     * Function: UpdateWorkStreamTaskWithOutcome
     * 
     * Completes WorkStreamTask for a given taskId with a given outcome
     * 
     * URL - /workStreamTasks
     * Method - PUT
     * Consumes - application/json
     * Produces - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     *     outcome - The outcome of the task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/workStreamTasks/10/Submit
     * 
     * Example POST Body:
     * {
     *  "taskId": "100000",
     *  "taskName": "CreateWorkOrderFromBench",
     *  "workStreamPayload": {
     *      "country": {
     *          ..
     *       }
     *   }
     * }
     */
    @PUT
    @Path("/workStreamTasks/{taskId}/{outcome}")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public WorkStreamTask updateWorkStreamTaskWithOutcome(@PathParam("taskId") String taskId, @PathParam("outcome") String outcome,
	    WorkStreamTask workStreamTask) {

        return null;
    }

    /**
     * Function: ClaimTask
     * 
     * Claims a task
     * 
     * URL - /claimTask
     * Method - PUT
     * Consumes - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/claimTask/10
     * 
     * Example POST Body:
     * {
     *    "assignee": "UserABC"
     * }
     */
    @PUT
    @Path("/claimTask/{taskId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void claimTask(@PathParam("taskId") String taskId, AssignTaskParams assignTaskParams) {

    }
    
    /**
     * Function: ReleaseTask
     * 
     * Releases a task
     * 
     * URL - /releaseTask
     * Method - PUT
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/releaseTask/10
     */
    @PUT
    @Path("/releaseTask/{taskId}")
    public void releaseTask(@PathParam("taskId") String taskId) {

    }
       
    /**
     * Function: ReassignTask
     * 
     * Reassigns a task to a different user
     * 
     * URL - /reassignTask
     * Method - PUT
     * Consumes - application/json
     * 
     * Required Path Parameters:
     *     taskId - The unique ID of the user task
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/reassignTask/10
     * 
     * Example POST Body:
     * {
     *    "assignee": "UserABC"
     * }
     */
    @PUT
    @Path("/reassignTask/{taskId}")
    @Consumes({ MediaType.APPLICATION_JSON })
    public void reassignTask(@PathParam("taskId") String taskId, AssignTaskParams AssignTaskParams) {

    }
    
    /**
     * Function: GetTasks
     * 
     * Retrieves Tasks based on the Search Parameters
     * 
     * URL - /tasks
     * Method - GET
     * Produces - application/json
     * 
     * Query Parameters:
     *     process - Name of the BPM Process
     *     task - Name of the User Task
     *     assignmentState - State of assignment - ASSIGNED/UNASSIGNED
     *     assignee - Name/ID of assignee
     *     group - Name of assignee group
     *     taskStatus - State of the task - OPEN/TERMINATED/COMPLETE..
     *     
     * Returns:
     *     List of GrTask
     * 
     * Example URL:
     *     http://localhost:8080/grcworkflow/resources/grcWorkflow/tasks?process=workorder&assignee=UserABC
     * 
     */
    @GET
    @Path("/tasks")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<GrcTask> getTasks(@QueryParam("process") String process, @QueryParam("task") String task, @QueryParam("assignmentState") String assignmentState,
            @QueryParam("assignee") String assignee, @QueryParam("group") String group, @QueryParam("taskStatus") String taskStatus) {

        return null;	
    }

    public WorkflowTaskService getWorkflowTaskService() {
        return workflowTaskService;
    }

    public void setWorkflowTaskService(WorkflowTaskService workflowTaskService) {
        this.workflowTaskService = workflowTaskService;
    }
}
