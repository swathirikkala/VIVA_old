package com.viva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viva.dao.ProjectDao;
import com.viva.dao.UserDao;
import com.viva.dao.util.ProjectMethods;
import com.viva.dao.util.UserMethods;
import com.viva.dto.Project;
import com.viva.dto.User;
import com.viva.util.ServiceUtil;

/**
 * Servlet implementation class GetAllProjectsByUserAsignedServlet
 */
public class GetAllProjectsByUserAsignedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllProjectsByUserAsignedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceUtil.callService(request, response, Project.class, ProjectDao.class, ProjectMethods.getProjectsByAssignedManager.name());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
