package com.thomsonreuters.grc.workflow.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.thomsonreuters.grc.workflow.activiti.domain.BpmInstance;
import com.thomsonreuters.grc.workflow.activiti.domain.BpmTask;
import com.thomsonreuters.grc.workflow.domain.WorkOrderType;
import com.thomsonreuters.grc.workflow.domain.WorkStreamType;

public class BpmDAOImpl {

    @Autowired
    private DataSource grcActivitiDataSource;
    private JdbcTemplate jdbcTemplate;

    public void setGrcActivitiDataSource(DataSource grcActivitiDataSource) {
	this.grcActivitiDataSource = grcActivitiDataSource;
    }

    public void addProcessInstance(BpmInstance bpmInstance) {
	// Insert instance into BPM_INSTANCE table
	String add = "INSERT INTO BPM_INSTANCE (INSTANCEID, PROCESSID , PROCESSNAME, EXECUTIONID, "
		+ "PARENTINSTANCEID, CREATEDBY, UPDATEDBY, STATUS) VALUES ( ? , ? , ? , ?, ? , ? , ? , ?)";

	this.jdbcTemplate = new JdbcTemplate(grcActivitiDataSource);
	jdbcTemplate.update(add,
		new Object[] { bpmInstance.getInstanceid(), bpmInstance.getProcessId(), bpmInstance.getProcessName(),
			bpmInstance.getExecutionId(), bpmInstance.getParentInstanceId(), bpmInstance.getCreatedBy(),
			bpmInstance.getUpdatedBy(), bpmInstance.getStatus() });
    }
    
    public void addWorkOrder(String workOrderId, String instanceId) {
	// Insert instance into WORK_ORDER table
	String add = "INSERT INTO WORK_ORDER (INSTANCEID, WORKORDERID) VALUES ( ? , ? )";

	this.jdbcTemplate = new JdbcTemplate(grcActivitiDataSource);
	jdbcTemplate.update(add,
		new Object[] { instanceId, workOrderId });
    }

    public WorkOrderType getWorkOrderTask(String taskId) {
	WorkOrderType wot = null;
    
	this.jdbcTemplate = new JdbcTemplate(grcActivitiDataSource);
	String lookup = "SELECT WO.* from WORK_ORDER WO, BPM_TASK BT where WO.INSTANCEID = BT.INSTANCEID AND BT.TASKID = ? ";
	System.out.println("TaskId: "+ taskId);
	try {
	     wot = jdbcTemplate.queryForObject(lookup, new Object[] { taskId },
                new WorkOrderMapper());
        
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	return wot;
    }
    
    public List<WorkStreamType> getWorkStreamTaskList(String taskId) {
	this.jdbcTemplate = new JdbcTemplate(grcActivitiDataSource);
   	String lookup = "SELECT WS.* from WORK_STREAM WS, WORK_ORDER WO, BPM_TASK BT where WO.WORKORDERID = WS.WORKORDERID "
   		+ " AND WO.INSTANCEID = BT.INSTANCEID AND BT.TASKID   = ? ";
                 
           return jdbcTemplate.query(lookup,
                   new Object[] { taskId },
                   new WorkStreamMapper());
       }

    public DataSource getGrcActivitiDataSource() {
	return grcActivitiDataSource;
    }

    public void addTask(BpmTask bpmTask) {
	// Insert instance into BPM_TASK table
	String add = "INSERT INTO BPM_TASK (TASKID, TASKNAME, TITLE, ACTIVITYNAME, INSTANCEID, PROCESSID, PROCESSNAME, EXECUTIONID, ACQUIREDBY, "
		+ "ASSIGNEES, REVIEWERS, ORIGINALASSIGNEEUSER, CREATOR, UPDATEDBY,"
		+ "SWIMLANEROLE, CREATEDDATE, UPDATEDDATE, DUEDATE, COMPLETEDDATE, CLAIMDATE, PRIORITY, OUTCOME, STATE ) "
		+ "VALUES ( ? , ? , ? , ?, ?, ? , ? , ? , ?, ?, ? , ? , ? , ?, ?, ? , ? , ? , ?, ?, ? , ? , ?)";
	this.jdbcTemplate = new JdbcTemplate(grcActivitiDataSource);
	jdbcTemplate.update(add,
		new Object[] { bpmTask.getTaskId(), bpmTask.getTaskName(), bpmTask.getTitle(),
			bpmTask.getActivityName(), bpmTask.getInstanceId(), bpmTask.getProcessId(),
			bpmTask.getProcessName(), bpmTask.getExecutionId(), bpmTask.getAcquiredBy(),
			bpmTask.getAssignees(), bpmTask.getReviewers(), bpmTask.getOriginalAssigneeUser(),
			bpmTask.getCreator(), bpmTask.getUpdatedBy(), bpmTask.getSwimlaneRole(),
			bpmTask.getCreatedDate(), bpmTask.getUpdatedDate(), bpmTask.getDueDate(),
			bpmTask.getCompletedDate(), bpmTask.getClaimDate(), bpmTask.getPriority(), bpmTask.getOutcome(),
			bpmTask.getState() });
    }

    private static class WorkOrderMapper implements RowMapper<WorkOrderType> {

	@Override
	public WorkOrderType mapRow(ResultSet rs, int rowNum) throws SQLException {
	    WorkOrderType wot = new WorkOrderType();
	    wot.setUuid(rs.getString("UUID"));
	    wot.setRegarding(rs.getString("REGARDING"));
	    wot.setSummary(rs.getString("SUMMARY"));
	    wot.setStatus(rs.getString("STATUS"));
	    wot.setSectorsConceptIds(rs.getString("SECTORSCONCEPTIDS"));
	    wot.setWorkProductType(rs.getString("WORKPRODUCTTYPE"));
	    return wot;
	}
    }
    
    private static class WorkStreamMapper implements RowMapper<WorkStreamType> {

 	@Override
 	public WorkStreamType mapRow(ResultSet rs, int rowNum) throws SQLException {
 	   WorkStreamType wst = new WorkStreamType();
 	   	wst.setWorkProduct(rs.getString("WORKPRODUCT"));
 	   	wst.setWorkProductId(rs.getString("WORKPRODUCTID"));
 	   	wst.setCountry(rs.getString("COUNTRY"));
 	   	wst.setCountryConceptId(rs.getString("COUNTRYCONCEPTID"));
 	   	wst.setRegion(rs.getString("REGION"));
 	   	wst.setRegionConceptId(rs.getString("REGIONCONCEPTID"));
 	   	wst.setJurisdiction(rs.getString("JURISDICTION"));
 	   	wst.setRegulator(rs.getString("REGULATOR"));
 	   	wst.setSector(rs.getString("SECTOR"));
 	   	wst.setWorkOrderUuid(rs.getString("WORKORDERUUID"));
 	   	wst.setUuid(rs.getString("UUID"));
 	    return wst;
 	}
     }
}
