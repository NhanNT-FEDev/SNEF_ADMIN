<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Store By Id</title>
</head>
<body>
    <c:set var="info" value="${requestScope.STOREDETAIL}" />
    <h3>Edit Product</h3>
    <form action="/admin/save" method="POST">
        <c:forEach var="rs" items="${info}" >
            <input type="text" value="${rs.storeId}" name="txtId" hidden />
            <label>Store Name</label>
            <input type="text" value="${rs.storeName}" name="txtName"/>
            <br/>
            <label>Store Manager</label>
            <input type="text" value="${rs.storeManagerId}" name="txtManager" />
            <br/>
            <label>Location</label>
            <input type="text" value="${rs.locationId}" name="txtLocation" />
            <br/>
            <label>Rating Point</label>
            <input type="text" value="${rs.ratingPoint}" name="txtRating" />
            <br/>
            <label>Avatar</label>
<%--            <input type="image" value="${rs.avatar}" name="txtAva" width="100px" height="100px">--%>
            <img src="${rs.avatar}" width="100px" height="100px"  />
            <br/>
            <label>Open Hour</label>
            <input type="text" value="${rs.openHour}" name="txtOpen" />
            <br/>
            <label>Close Hour</label>
            <input type="text" value="${rs.closeHour}" name="txtClose" />
            <br/>
            <label>Status</label>
            <input type="checkbox" name="chkStatus" value="${rs.status}"
            <c:if test="${rs.status}">
                checked="checked"
            </c:if>
            />
            <br/>
        </c:forEach>
        <br/>
        <input type="submit" value="Save">

    </form>
    <c:if test="${not empty msg}">
        <h4 style="color: red">${msg}</h4>
    </c:if>
</body>
</html>