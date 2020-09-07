package com.hillel.hw20WebApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.hw20WebApp.db.DBHelper;

@WebServlet("/findActorsByFilm")
public class FindActorsByFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titleFilm = request.getParameter("titleFilm");

		if (titleFilm != null) {
			request.setAttribute("actorsList", new DBHelper().findActorsByFilm(titleFilm));
			request.setAttribute("titleFilm", titleFilm);
		}
		request.getRequestDispatcher("/findActorsByFilm.jsp").forward(request, response);
	}
}