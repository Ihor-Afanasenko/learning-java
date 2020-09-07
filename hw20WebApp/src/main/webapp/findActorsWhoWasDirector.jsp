<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<c:import url="WEB-INF/jspf/header.jspf" />
<body>
	<center>
		<form name="findActorsWhoWasDirector" method="post">
			<h3>
				<b> Actors who were directors of at least one of the films</b>
			</h3>
			<table bordercolor="blue" border="2" width="30%">
				<tr>
					<th>Full name</th>
					<th>Date of birth</th>
				</tr>
				<c:choose>
					<c:when test="${not empty actorsList}">
						<c:forEach var="actor" items="${actorsList}">
							<tr>
								<td><c:out value="${actor.name}" /></td>
								<td><c:out value="${actor.dateOfBirth}" /></td>
							<tr>
						</c:forEach>
					</c:when>
					<c:when test="${empty actorsList}">
						<h3>
							<b> No search results</b>
						</h3>
					</c:when>
				</c:choose>
			</table>
		</form>
</body>
<c:import url="WEB-INF/jspf/footer.jspf" />
</html>