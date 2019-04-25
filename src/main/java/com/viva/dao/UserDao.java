package com.viva.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.viva.db.util.DBConnectionUtil;
import com.viva.dto.User;

public class UserDao {

	public Response registerUser(User user) {
		Response response = new Response();
		String query = "insert into user values ('" + user.getEmailId() + "','" + user.getFirstName() + "','"
				+ user.getLastName() + "','" + user.getDob() + "'," + user.getDepartment()+ ",'"
				+ user.getDesignation() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','"
				+ user.getSecurityAnswer() + "')";
		int saveDBResponse = DBConnectionUtil.insert(query);
		if (saveDBResponse == 0) {
			response.setResponseCode(0);
			response.setResponseMessage("Please verify details");
			response.setResponseObject(user);
		} else if (saveDBResponse == -1) {
			response.setResponseCode(-1);
			response.setResponseMessage("Internal server error");
			response.setResponseObject(user);
		} else {
			response.setResponseCode(1);
			response.setResponseMessage("Registration success");
			response.setResponseObject(user);
		}
		System.out.println("Registration Response : " + response);
		return response;
	}

	public Response login(User user) {
		Response response = new Response();
		String query = "select * from user where id ='" + user.getEmailId() + "' and password = '" + user.getPassword()
				+ "'";
		List<User> userReponse = parseUsers(DBConnectionUtil.getData(query));
		if (userReponse == user && userReponse.size() == 0) {
			response.setResponseCode(0);
			response.setResponseMessage("Please verify credentials");
			response.setResponseObject(user);
		} else {
			response.setResponseCode(1);
			response.setResponseMessage("Login success");
			response.setResponseObject(userReponse.get(0));
		}
		System.out.println("Login Response : " + response);
		return response;
	}

	private List<User> parseUsers(ResultSet rs) {
		List<User> users = new ArrayList<User>();
		try {
			if (null != rs && rs.next()) {
				User user = new User();
				user.setEmailId(rs.getString(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setDepartment(rs.getString(5));
				user.setDesignation(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setSecurityQuestion(rs.getString(8));
				user.setSecurityAnswer(rs.getString(9));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
