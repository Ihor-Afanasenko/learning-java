<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<c:import url="WEB-INF/jspf/header.jspf" />
<body>
	<center>
		<form name="findActorsByFilm" method="post" action="/findActorsByFilm">
			<table>
				<tr>
					<td><B>Input title film </B></td>
					<td><input type=text name="titleFilm" size="30" value=""></td>
				</tr>
			</table>
			<input type="submit" value="Search actors" required> <input
				type="reset" value="Reset">
			<c:choose>
				<c:when test="${not empty actorsList}">
					<h3>
						<b> List actors who shot in the '${titleFilm}' film</b>
					</h3>
					<table bordercolor="blue" border="2" width="30%">
						<tr>
							<th>Full name</th>
							<th>Date of birth</th>
						</tr>
						<c:forEach var="actor" items="${actorsList}">
							<tr>
								<td text="align-center"><c:out value="${actor.name}" /></td>
								<td text="align-center"><c:out value="${actor.dateOfBirth}" /></td>
							<tr>
						</c:forEach>
					</table>
				</c:when>
				<c:when test="${not empty titleFilm && empty actorsList}">
					<h3>
						<b> No search results</b>
					</h3>
				</c:when>
			</c:choose>
		</form>
</body>
<c:import url="WEB-INF/jspf/footer.jspf" />
</html>