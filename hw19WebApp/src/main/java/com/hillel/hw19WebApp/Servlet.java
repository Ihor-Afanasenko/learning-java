package com.hillel.hw19WebApp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String numbers = request.getParameter("numbers");
		String word = request.getParameter("word");

		PrintWriter out = response.getWriter();

		out.print("Sorted number: ");
		new RequestProcessor().processingNumbers(numbers).stream().forEach(n -> out.print(n + " "));
		out.println();
		out.println("Frequency word (" + word + ") in text: " + new RequestProcessor().findFrequencyWordInText(word));
		out.close();
	}
}