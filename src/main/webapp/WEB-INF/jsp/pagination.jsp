<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>SNEF - Admin Page</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>

<body>
<c:set var="rs" value="${requestScope.LIST}"/>
<c:set var="currentPage" value="${requestScope.CURRENTPAGE}"/>
<c:set var="noOfPage" value="${requestScope.PAGE}"/>

<h3>Check Pagination </h3>
<table border="1" cellpadding="0" width="100%">
		<thead>
		<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${rs}">
				<tr>
						<td>${list.storeId}</td>
						<td>${list.storeName}</td>
						<td>${list.address}</td>
						<td>${list.phone}</td>
				</tr>
		</c:forEach>
		</tbody>
</table>
<%--For displaying Previous link except for the 1st page --%>
<%--<c:if test="${currentPage != 1}">--%>
<%--<td><a href="employee.do?page=${currentPage - 1}">Previous</a></td>--%>
<%--</c:if>--%>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<%--<table border="1" cellpadding="5" cellspacing="5">--%>
<%--		<tr>--%>
<nav aria-label="Page navigation example">
		<ul class="pagination">
				<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/page?page=${currentPage - 1}">Previous</a>
				</li>
				<c:forEach var="page" begin="1" end="${noOfPage}" step="1">
						<li class="page-item">
								<c:choose>
										<c:when test="${currentPage eq page}">
												<a class="page-link" href="${pageContext.request.contextPath}/page?page=${page}" style="background: #2e59d9; color: white">${page}</a>
										</c:when>
										<c:otherwise>
												<a class="page-link" href="${pageContext.request.contextPath}/page?page=${page}">${page}</a>
										</c:otherwise>
								</c:choose>
						</li>
				</c:forEach>
				<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/page?page=${currentPage + 1}">Next</a>
				</li>
		</ul>
</nav>
<%--		</tr>--%>
<%--</table>--%>

<%--For displaying Next link --%>
<%--<c:if test="${currentPage lt noOfPage}">--%>
<%--		<td><a href="employee.do?page=${currentPage + 1}">Next</a></td>--%>
<%--</c:if>--%>


</body>

</html>