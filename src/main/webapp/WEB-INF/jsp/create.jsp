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
</head>
<body>
    <h3>Create New Store</h3>
    <form method="POST" action="/admin/insert">
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
        <input type="text" name="stAva" value="" />
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
</body>
</html>