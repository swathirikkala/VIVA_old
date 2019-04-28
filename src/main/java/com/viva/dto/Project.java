package com.viva.dto;

public class Project {
	private String projectId;
	private String projectName;
	private String priority;
	private int estimatedHours;
	private String consumedHours;
	private String managerId;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectId, String projectName, String priority, int estimatedHours, String consumedHours,
			String managerId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.priority = priority;
		this.estimatedHours = estimatedHours;
		this.consumedHours = consumedHours;
		this.managerId = managerId;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", priority=" + priority
				+ ", estimatedHours=" + estimatedHours + ", consumedHours=" + consumedHours + ", managerId=" + managerId
				+ "]";
	}

}
