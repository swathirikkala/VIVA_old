package com.viva.db.util;

import com.viva.dto.Project;
import com.viva.dto.User;

public class QueryBuilder {

	public static String getAddProjectQuery(Project project) {
		String query = "inser into project values('" + project.getProjectName() + "'," + project.getPriority() + "',"
				+ project.getEstimatedHours() + ",0,'" + project.getAssignedManager() + "','" + project.getCreatedBy()
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
}
