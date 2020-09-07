<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<c:import url="WEB-INF/jspf/header.jspf" />
<body>
	<center>
		<form name="findActorsShotNfilms" method="post">
			<table>
				<tr>
					<td><b>Input number films</b></td>
					<td><input type="text" name=numberFilms size="10" value=""></td>
				</tr>
			</table>
			<input type="submit" value="Search actors" required> <input
				type="reset" value="Reset">
		</form>
		<c:choose>
			<c:when test="${not empty actorsList}">
				<h3>
					<b> Actors who shot in at least '${numberFilms}' films</b>
				</h3>
				<table bordercolor="blue" border="2" width="30%">
					<tr>
						<th>Full name</th>
						<th>Date of birth</th>
					</tr>
					<c:forEach var="actor" items="${actorsList}">
						<tr>
							<td><c:out value="${actor.name}" /></td>
							<td><c:out value="${actor.dateOfBirth}" /></td>
						<tr>
					</c:forEach>
				</table>
			</c:when>
			<c:when test="${not empty numberFilm && empty actorsList}">
				<h3>
					<b> No search results</b>
				</h3>
			</c:when>
		</c:choose>
</body>
<c:import url="WEB-INF/jspf/footer.jspf" />
</html>