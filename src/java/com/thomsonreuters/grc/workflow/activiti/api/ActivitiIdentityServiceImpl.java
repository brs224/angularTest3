package com.thomsonreuters.grc.workflow.activiti.api;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.thomsonreuters.grc.workflow.domain.WorkflowGroup;
import com.thomsonreuters.grc.workflow.domain.WorkflowUser;
import com.thomsonreuters.grc.workflow.service.WorkflowIdentityService;

public class ActivitiIdentityServiceImpl {

	@Autowired
	private IdentityService identityService;

	/**
	 * Adds a user if they do not already exist
	 * 
	 * @param newUser
	 * @return
	 */
	public String addUser(WorkflowUser newUser) {
		String status = "SUCCESS";
		if ((identityService.createUserQuery().userId(newUser.getId()).singleResult()) == null) {
			User newActivitiUser = identityService.newUser(newUser.getId());
			newActivitiUser.setEmail(newUser.getEmail());
			newActivitiUser.setFirstName(newUser.getFirstName());
			newActivitiUser.setLastName(newUser.getLastName());
			// now save the user object
			identityService.saveUser(newActivitiUser);
			// we can add any of our specific data on a user as generic info
			identityService.setUserInfo(newUser.getId(), WorkflowIdentityService.DISPLAY_NAME_KEY,
					newUser.getDisplayName());
		} else {
			status = "EXISTS ALREADY";
		}
		return status;
	}

	/**
	 * Gets the details for a single user
	 * 
	 * @param userId
	 * @return
	 */
	public WorkflowUser getUser(String userId) {
		WorkflowUser returnUser = null;
		// must use the queries to fetch details about a user
		User user = identityService.createUserQuery().userId(userId).singleResult();
		if (user != null) {
			returnUser = new WorkflowUser();
			returnUser.setId(userId);
			returnUser.setEmail(user.getEmail());
			returnUser.setFirstName(user.getFirstName());
			returnUser.setLastName(user.getLastName());
			returnUser.setDisplayName(identityService.getUserInfo(userId, WorkflowIdentityService.DISPLAY_NAME_KEY));
		}

		return returnUser;
	}

	public void addUserInfo(String userId, String infoKey, String infoValue) {
		identityService.setUserInfo(userId, infoKey, infoValue);
	}

	/**
	 * Add a new group
	 * 
	 * @param newGroup
	 * @return
	 */
	public String addGroup(WorkflowGroup newGroup) {
		String status = "SUCCESS";
		if ((identityService.createGroupQuery().groupId(newGroup.getId()).singleResult()) == null) {
			Group newActivitiGroup = identityService.newGroup(newGroup.getId());
			if (newGroup.getName() != null) {
				newActivitiGroup.setName(newGroup.getName());
			} else {
				newActivitiGroup.setName(newGroup.getId());
			}
			identityService.saveGroup(newActivitiGroup);
		} else {
			status = "EXISTS ALREADY";
		}

		return status;
	}

	/**
	 * Add a user to a group
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public String addUserToGroup(String userId, String groupId) {
		String status = "SUCCESS";
		// check if user exists
		if ((identityService.createUserQuery().userId(userId).singleResult()) != null) {
			// check if group exists
			if ((identityService.createGroupQuery().groupId(groupId).singleResult()) != null) {
				// check if user is already member of group
				if ((identityService.createGroupQuery().groupId(groupId).groupMember(userId)) == null) {
					identityService.createMembership(userId, groupId);
				} else {
					status = "USER IS ALREADY MEMBER OF GROUP";
				}
			} else {
				status = "GROUP DOES NOT EXIST";
			}
		} else {
			status = "USER DOES NOT EXIST";
		}

		return status;
	}

	public WorkflowGroup getGroup(String groupId) {
		WorkflowGroup returnGroup = null;
		Group group = identityService.createGroupQuery().groupId(groupId).singleResult();
		if (group != null) {
			returnGroup = new WorkflowGroup();
			returnGroup.setId(group.getId());
			returnGroup.setName(group.getName());
		}
		return returnGroup;
	}

}
