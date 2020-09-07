<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<c:import url="WEB-INF/jspf/header.jspf" />

<body>
	<center>
		<form name="findFilmsByYear" method="post">
			<p>
				<b>Films were released in the current or previous year</b>
			</p>
			<table bordercolor="blue" border="2" width="40%">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Released year</th>
					<th>Country</th>
				</tr>
				<c:choose>
					<c:when test="${not empty filmList}">
						<c:forEach var="film" items="${filmList}">
							<tr>
								<td><c:out value="${film.id}" /></td>
								<td><c:out value="${film.title}" /></td>
								<td><c:out value="${film.releaseYear }" /></td>
								<td><c:out value="${film.country}" /></td>
							<tr>
						</c:forEach>
					</c:when>
					<c:when test="${empty filmList}">
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