package com.viva.dto;

public class Project {
	private String projectId;
	private String projectName;
	private String priority;
	private int estimatedHours;
	private String consumedHours;
	private String assignedManager;
	private String createdBy;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectId, String projectName, String priority, int estimatedHours, String consumedHours,
			String assignedManager, String createdBy) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.priority = priority;
		this.estimatedHours = estimatedHours;
		this.consumedHours = consumedHours;
		this.assignedManager = assignedManager;
		this.createdBy = createdBy;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public String getConsumedHours() {
		return consumedHours;
	}

	public void setConsumedHours(String consumedHours) {
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
