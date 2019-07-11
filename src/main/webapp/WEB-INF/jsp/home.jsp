<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>This is admin Page</h1>
<c:set var="get" value="${requestScope.LISTSTORE}"/>
<c:set var="search" value="${requestScope.SEARCHVALUE}" />
<%--<c:url var="urlAction" value="/admin" />--%>
<form method="POST" action="/admin/search">
    <label>Enter Name Store</label>
    <input type="text" name="name" value="${name}">
    <input type="submit" value="Search">
</form>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Store Name</th>
        <th>StoreManagerId</th>
        <th>locationId</th>
        <th>ratingPoint</th>
        <th>avatar</th>
        <th>openHour</th>
        <th>closeHour</th>
        <th>status</th>


    </tr>
    <c:if test="${search == null}">
        <c:forEach var="rs" items="${get}">
            <tr>
                <td>${rs.storeId}</td>
                <td>${rs.storeName}</td>
                <td>${rs.storeManagerId}</td>
                <td>${rs.locationId}</td>
                <td>${rs.ratingPoint}</td>
                <td><img src="${rs.avatar}" alt="" width="100px" height="100px"></td>
                <td>${rs.openHour}</td>
                <td>${rs.closeHour}</td>
                <td>
                    <input type="checkbox" name="chkStatus" value="${rs.status}" disabled="true"
                    <c:if test="${rs.status}">
                           checked="checked"
                    </c:if>
                    >
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/edit?storeId=${rs.storeId}">Edit Store</a>
                </td>

            </tr>
        </c:forEach>

    </c:if>
    <c:if test="${search != null}">
        <c:forEach var="rs" items="${search}">
            <tr>
                <td>${rs.storeId}</td>
                <td>${rs.storeName}</td>
                <td>${rs.storeManagerId}</td>
                <td>${rs.locationId}</td>
                <td>${rs.ratingPoint}</td>
                <td><img src="${rs.avatar}" alt="" width="100px" height="100px"></td>
                <td>${rs.openHour}</td>
                <td>${rs.closeHour}</td>
                <td>
                    <input type="checkbox" name="chkStatus" value="${rs.status}" disabled="true"
                    <c:if test="${rs.status}">
                           checked="checked"
                    </c:if>
                    >
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/edit?storeId=${rs.storeId}">Edit Store</a>
                </td>


            </tr>
        </c:forEach>
    </c:if>

</table>
<a href="${pageContext.request.contextPath}/admin/create">Create New Store</a>
</body>
</html>