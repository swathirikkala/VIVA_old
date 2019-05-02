package com.viva.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.viva.dao.util.ResponseBuilder;
import com.viva.dao.util.UserMethods;
import com.viva.db.util.DBConnectionUtil;
import com.viva.db.util.QueryBuilder;
import com.viva.dto.User;

public class UserDao {

	public Response registerUser(User user) {
		
		int saveDBResponse = DBConnectionUtil.insert(QueryBuilder.getRegisterUserQuery(user));
		return ResponseBuilder.getResponse(saveDBResponse, UserMethods.registerUser.name(), user);
		
	}

	public Response login(User user) {

		List<User> userLoginReponse = parseUsers(DBConnectionUtil.getData(QueryBuilder.getUserLoginQuery(user)));
		return ResponseBuilder.getResponse(userLoginReponse.size(), UserMethods.login.name(), userLoginReponse);
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
