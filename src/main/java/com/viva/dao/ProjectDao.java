package com.viva.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.viva.dao.util.ProjectMethods;
import com.viva.dao.util.ResponseBuilder;
import com.viva.db.util.DBConnectionUtil;
import com.viva.db.util.QueryBuilder;
import com.viva.dto.Project;

public class ProjectDao {

	public Response addProject(Project project) {

		int addProjectResponse = DBConnectionUtil.insert(QueryBuilder.getAddProjectQuery(project));
		return ResponseBuilder.getResponse(addProjectResponse, ProjectMethods.addProject.name(), project);
	}

	public Response getProjects() {
		return null;
	}

	public Response getProjectsByAssignedManager(Project project) {
		ResultSet data = DBConnectionUtil.getData(QueryBuilder.getProjectsByAssignedManagerQuery(project));
		List<Project> assigendProjects = parseProjects(data);
		return ResponseBuilder.getResponse(assigendProjects.size(), ProjectMethods.getProjectsByAssignedManager.name(),
				assigendProjects);
	}

	public Response getProjectsByCreatedBy() {
		return null;
	}

	public Response updateProject() {
		return null;
	}

	public Response deleteProject() {
		return null;
	}

	public Response getProjectUniqueBusinessValues() {
		return null;
	}

	public Response getProjectSegregatedBusinessValues() {
		return null;
	}

	private List<Project> parseProjects(ResultSet rs) {
		List<Project> projects = new ArrayList<Project>();
		try {
			while (null != rs && rs.next()) {
				Project project = new Project();
				project.setProjectId(rs.getInt(1));
				project.setProjectName(rs.getString(2));
				project.setPriority(rs.getInt(3));
				project.setEstimatedHours(rs.getInt(4));
				project.setConsumedHours(rs.getInt(5));
				project.setAssignedManager(rs.getString(6));
				project.setCreatedBy(rs.getNString(7));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}
}
