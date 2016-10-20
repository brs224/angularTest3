package com.thomsonreuters.grc.workflow.service;

import javax.ws.rs.core.MediaType;

import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.thomsonreuters.grc.workflow.activiti.api.ActivitiIdentityServiceImpl;
import com.thomsonreuters.grc.workflow.domain.WorkflowGroup;
import com.thomsonreuters.grc.workflow.domain.WorkflowUser;

public class WorkflowIdentityService {
    @Autowired
    private ActivitiIdentityServiceImpl activitiIdentityService;

    private String securityClientUrl = null;

	public static final String HEADER_SESSION_TOKEN = "X-West-session-token";

	public static final String DISPLAY_NAME_KEY = "displayName";
	public static final String EMPLOYEE_ID_KEY = "employeeId";
	public static final String EMAIL_KEY = "email";
	public static final String FIRST_NAME_KEY = "firstName";
	public static final String LAST_NAME_KEY = "lastName";
	

	protected static final String USER_INFO_URI = "/userInfo/";
	
	public String addUser(String userid){
		
		String status = "SUCCESS";
		JSONObject userInfo = null;
		
		Client client = Client.create();
		// just makes sense to renew the authentication rather than just check if valid.
		// we will want to renew the session anyway and renew will return indication that
		// the session token is no longer valid if that is the case anyway.
		WebResource webResource = client.resource(getSecurityClientUrl())
				.path(USER_INFO_URI + userid);

		Builder builder = webResource.type(MediaType.APPLICATION_JSON);
		builder.header(HEADER_SESSION_TOKEN, "GRC_WORKFLOWencrypted");
		try {
			ClientResponse response = builder.get(ClientResponse.class);
			
			System.out.println("ResponseStatus is "+response.getStatus());
			
			String json = response.getEntity(String.class);
			System.out.println("ResponsePayload is "+json);
			userInfo = new JSONObject(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.destroy();
		}
		//create new user object and populate
		WorkflowUser newUser = new WorkflowUser();
		newUser.setId(userid);
		newUser.setEmail(userInfo.getString(EMAIL_KEY));
		newUser.setFirstName(userInfo.getString(FIRST_NAME_KEY));
		newUser.setLastName(userInfo.getString(LAST_NAME_KEY));
		newUser.setDisplayName(userInfo.getString(DISPLAY_NAME_KEY));
		//now save the user object
		status = activitiIdentityService.addUser(newUser);
		
		return status;
	}
	
	public String addGroup( String groupId, String groupName){
		String status = "SUCCESS";
		WorkflowGroup newGroup = new WorkflowGroup();
		newGroup.setId(groupId);
		newGroup.setName(groupName);
		status = activitiIdentityService.addGroup(newGroup);
		
;		return status;
	}
	
	public String addUserToGroup (String userId, String groupId){
		return activitiIdentityService.addUserToGroup(userId, groupId);
	}
	
	public WorkflowUser getUser(String userId){
		return activitiIdentityService.getUser(userId);
	}
	
	public WorkflowGroup getGroup(String groupId){
		return activitiIdentityService.getGroup(groupId);
	}
	
	
	public String getSecurityClientUrl() {
		return securityClientUrl;
	}

	public void setSecurityClientUrl(String securityClientUrl) {
		this.securityClientUrl = securityClientUrl;
	}


	public ActivitiIdentityServiceImpl getActivitiIdentityService() {
		return activitiIdentityService;
	}


	public void setActivitiIdentityService(ActivitiIdentityServiceImpl activitiIdentityService) {
		this.activitiIdentityService = activitiIdentityService;
	}
	

}
