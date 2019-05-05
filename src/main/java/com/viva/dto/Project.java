package com.viva.dto;

public class Project {
	private int projectId;
	private String projectName;
	private int priority;
	private int estimatedHours;
	private int consumedHours;
	private String assignedManager;
	private String createdBy;

	public Project() {
		super();
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public int getConsumedHours() {
		return consumedHours;
	}

	public void setConsumedHours(int consumedHours) {
		this.consumedHours = consumedHours;
	}

	public String getAssignedManager() {
		return assignedManager;
	}

	public void setAssignedManager(String assignedManager) {
		this.assignedManager = assignedManager;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", priority=" + priority
				+ ", estimatedHours=" + estimatedHours + ", consumedHours=" + consumedHours + ", assignedManager="
				+ assignedManager + ", createdBy=" + createdBy + "]";
	}

	
}
