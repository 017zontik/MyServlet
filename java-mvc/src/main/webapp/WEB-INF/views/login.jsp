<%--
  Created by IntelliJ IDEA.
  User: 017zo
  Date: 17.05.2020
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Registratiob</title>
</head>
<body>

<h2>Enter user information</h2>
<form:form method="post" modelAttribute="userOb" action="/login" >
    <table>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Input"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>