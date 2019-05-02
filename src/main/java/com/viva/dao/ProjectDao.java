package com.viva.dao;

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

	public Response getProjectsByAssignedManager() {
		return null;
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
}
