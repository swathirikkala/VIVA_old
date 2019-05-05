package com.viva.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.viva.dao.util.ResponseBuilder;
import com.viva.dao.util.SprintMethods;
import com.viva.db.util.DBConnectionUtil;
import com.viva.db.util.QueryBuilder;
import com.viva.dto.Sprint;

public class SprintDao {

	public Response addSprint(Sprint sprint) {
		int addSprintResponse = DBConnectionUtil.insert(QueryBuilder.getAddSprintQuery(sprint));
		return ResponseBuilder.getResponse(addSprintResponse, SprintMethods.addSprint.name(), sprint);
	}

	public Response getSpintsByProject(Sprint sprint) {
		ResultSet sprintsRS = DBConnectionUtil.getData(QueryBuilder.getAllSprintsByProjectQuery(sprint));
		List<Sprint> sprintsList = parseSprints(sprintsRS);
		return ResponseBuilder.getResponse(sprintsList.size(), SprintMethods.getSpintsByProject.name(),
				sprintsList);

	}

	private List<Sprint> parseSprints(ResultSet rs) {
		List<Sprint> sprintsList = new ArrayList<Sprint>();
		try {
			while (null != rs && rs.next()) {
				Sprint sprint = new Sprint();
				sprint.setSprintId(rs.getInt(1));
				sprint.setSprintName(rs.getString(2));
				sprint.setProjectId(rs.getInt(3));
				sprint.setSprintPriority(rs.getInt(4));
				sprint.setStartDate(rs.getString(5));
				sprint.setEndDate(rs.getString(6));
				sprint.setEstimatedHours(rs.getInt(7));
				sprint.setConsumedHours(rs.getInt(8));
				sprintsList.add(sprint);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sprintsList;
	}
}
