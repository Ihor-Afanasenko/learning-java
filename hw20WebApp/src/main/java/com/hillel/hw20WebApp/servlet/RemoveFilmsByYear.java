package com.hillel.hw20WebApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.hw20WebApp.db.DBHelper;

@WebServlet("/removeFilmsByYear")
public class RemoveFilmsByYear extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("removeYears") != null) {
			DBHelper db = new DBHelper();
			int removeYear = Integer.parseInt(request.getParameter("removeYears"));
			request.setAttribute("removeYears", removeYear);
			request.setAttribute("filmsList", db.findFilmsOlderThenGivenYear(removeYear));
			db.deleteFilmsByYears(removeYear);
		}
		request.getRequestDispatcher("/removeFilmsByYear.jsp").forward(request, response);
	}
}