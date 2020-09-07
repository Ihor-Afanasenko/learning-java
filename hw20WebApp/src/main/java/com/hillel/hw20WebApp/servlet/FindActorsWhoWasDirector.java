package com.hillel.hw20WebApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.hw20WebApp.db.DBHelper;

@WebServlet("/findActorsWhoWasDirector")
public class FindActorsWhoWasDirector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("actorsList", new DBHelper().findActorsWhoDirectors());
		request.getRequestDispatcher("/findActorsWhoWasDirector.jsp").forward(request, response);
	}
}