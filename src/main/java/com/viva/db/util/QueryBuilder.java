package com.viva.db.util;

import com.viva.dto.Project;
import com.viva.dto.Sprint;
import com.viva.dto.User;

public class QueryBuilder {

	public static String getAddProjectQuery(Project project) {
		String query = "insert into project (name,priority,estimated_hours,hours_consumed,manager_name,created_by) values('"
				+ project.getProjectName() + "'," + project.getPriority() + "," + project.getEstimatedHours() + ","
				+ project.getConsumedHours() + ",'" + project.getAssignedManager() + "','" + project.getCreatedBy()
				+ "')";

		return query;
	}

	public static String getRegisterUserQuery(User user) {
		String query = "insert into user values ('" + user.getEmailId() + "','" + user.getFirstName() + "','"
				+ user.getLastName() + "','" + user.getDob() + "'," + user.getDepartment() + ",'"
				+ user.getDesignation() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','"
				+ user.getSecurityAnswer() + "')";
		return query;
	}

	public static String getUserLoginQuery(User user) {
		String query = "select * from user where id ='" + user.getEmailId() + "' and password = '" + user.getPassword()
				+ "'";
		return query;
	}

	public static String getAllUsers() {
		String query = "select * from user";
		return query;
	}

	public static String getProjectsByAssignedManagerQuery(Project project) {
		String query = "select * from project where manager_name = '" + project.getAssignedManager()+"'";
		return query;
	}

	public static String getAddSprintQuery(Sprint sprint) {
		String query = "INSERT INTO sprint(name,project_id,priority,start_date, end_date,hours_estimation,hours_consumed) VALUES ('"+
				sprint.getSprintName()+"',"+sprint.getProjectId()+","+sprint.getSprintPriority()+",'"+
				sprint.getStartDate()+"','"+sprint.getEndDate()+"',"+
				sprint.getEstimatedHours()+","+sprint.getConsumedHours()+")";
		return query;
	}

	public static String getAllSprintsByProjectQuery(Sprint sprint) {
		String query = "select * from sprint where project_id = " + sprint.getProjectId()+"";
		return query;
	}
}
