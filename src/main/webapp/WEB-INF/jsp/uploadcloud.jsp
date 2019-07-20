
<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/admin/upload" method="POST" enctype="multipart/form-data" >
        <label>Choice Image</label>
        <input type="file" name="file" value="" />
        <br/>
        <input type="submit" name="Submit" />
    </form>
</body>
</html>