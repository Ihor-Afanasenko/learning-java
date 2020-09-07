<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<c:import url="WEB-INF/jspf/header.jspf" />
<body>
	<center>
		<form name="removeFilmsByYear" method="post">
			<table>
				<tr>
					<td><b>Input the number of years after which all films
							will be removed</b></td>
					<td><input type="text" name="removeYears" size="1" value=""></td>
				</tr>
			</table>
			<input type="submit" value="Remove films" required> <input
				type="reset" value="Reset">
		</form>
		<c:choose>
			<c:when test="${not empty filmsList}">
				<h2>
					<b> List of films that have been removed</b>
				</h2>
				<table bordercolor="black" border="2" width="60%">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Released year</th>
						<th>Country</th>
					</tr>
					<c:forEach var="film" items="${filmsList}">
						<tr>
							<td><c:out value="${film.id}" /></td>
							<td><c:out value="${film.title}" /></td>
							<td><c:out value="${film.releaseYear }" /></td>
							<td><c:out value="${film.country}" /></td>
						<tr>
					</c:forEach>
				</table>
			</c:when>
			<c:when test="${not empty removeYears && empty filmsList}">
				<h3>
					<b> No search results</b>
				</h3>
			</c:when>
		</c:choose>
</body>
<c:import url="WEB-INF/jspf/footer.jspf" />
</html>