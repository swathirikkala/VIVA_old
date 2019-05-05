package com.viva.dto;

public class Sprint {

	private int sprintId;
	private String sprintName;
	private int projectId;
	private int sprintPriority;
	private int estimatedHours;
	private int consumedHours;
	private String startDate;
	private String endDate;
	public Sprint() {
		super();
	}
	public int getSprintId() {
		return sprintId;
	}
	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	public String getSprintName() {
		return sprintName;
	}
	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getSprintPriority() {
		return sprintPriority;
	}
	public void setSprintPriority(int sprintPriority) {
		this.sprintPriority = sprintPriority;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Sprint [sprintId=" + sprintId + ", sprintName=" + sprintName + ", projectId=" + projectId
				+ ", sprintPriority=" + sprintPriority + ", estimatedHours=" + estimatedHours + ", consumedHours="
				+ consumedHours + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	
}
