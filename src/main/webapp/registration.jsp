<%--
  Created by IntelliJ IDEA.
  User: 017zo
  Date: 29.04.2020
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница регистрации</title>
</head>
<body>
<form action="/registration" method="post">
    login: <input name="login" type="text" />
    <br><br>
    password: <input name="password" type="number" min=6 />
    <br></br>
    username: <input name="username" type="text" />
    <br></br>
    <input type="submit" value="registration"  >
        Regitration
    </input>
</form>

</body>
</html>
