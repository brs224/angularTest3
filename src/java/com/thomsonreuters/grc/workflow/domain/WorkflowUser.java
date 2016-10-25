package com.thomsonreuters.grc.workflow.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workflowUser")
public class WorkflowUser implements Serializable {
	private String id;
	private String firstName;
	private String lastName;
	private String displayName;
	private String email;
	private List<WorkflowGroup> groups;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<WorkflowGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<WorkflowGroup> groups) {
		this.groups = groups;
	}
}
