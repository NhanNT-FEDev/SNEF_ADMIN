<%@ page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create New Page</title>
    <link href="css/all.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/sb-admin-2.css">
    <!-- Custom styles for this page -->
    <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/dataTables.bootstrap4.css">
    <script src="https://kit.fontawesome.com/85cfd1cc6c.js"></script>
</head>
<body>
    <h3>Create New Store</h3>
    <form method="POST" action="/admin/insert" enctype="multipart/form-data">
        <label>Store Name</label>
        <input type="text" name="stName" value="" />
        <br/>
        <label>Location</label>
        <input type="text" name="stLocal" value="" />
        <br/>
        <label>Rating Point</label>
        <input type="text" name="stRat" value="" />
        <br/>
        <label>Avatar</label>
        <input type="file" name="file" value="" />
        <br/>
        <label>Open Hour</label>
        <input type="text" name="stOpen" value=""/>
        <br/>
        <label>Close Hour</label>
        <input type="text" name="stClose" value=""/>
        <br/>
        <label>Store Manager</label>
        <input type="text" name="stMana" value=""/>
        <br/>
        <label>Active</label>
        <input type="checkbox" name="chkStatus" value=""/>
        <br/>
        <input type="submit" value="Insert" />
        <input type="reset" value="reset" />

    </form>
    <c:set var="err" value="${requestScope.ERR}"/>
    <c:if test="${err}">
        <h3 style="color: red">${err}</h3>
    </c:if>
</body>
</html>