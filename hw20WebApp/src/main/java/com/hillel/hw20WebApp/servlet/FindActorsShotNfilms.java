package com.hillel.hw20WebApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.hw20WebApp.db.DBHelper;

@WebServlet("/findActorsShotNfilms")
public class FindActorsShotNfilms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("numberFilms") != null) {
			int numberFilms = Integer.parseInt(request.getParameter("numberFilms"));
			request.setAttribute("actorsList", new DBHelper().findActorsNfilms(numberFilms));
			request.setAttribute("numberFilms", numberFilms);
		}
		request.getRequestDispatcher("/findActorsShotNfilms.jsp").forward(request, response);
	}
}