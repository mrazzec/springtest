<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registration User</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>
<c:out value="${error}"/>

<spring:form modelAttribute="newUser" method="post" action="/registration">

    <table>
        <table>
            <tr>
                <td><label>Login:</label></td>
                <td>
                    <form:input path="name" />
                    <form:errors path="name" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Pass:</label></td>
                <td>
                    <form:input path="pass" />
                    <form:errors path="pass" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td>
                    <form:input path="email" />
                    <form:errors path="email" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Age:</label></td>
                <td>
                    <form:input path="age" />
                    <form:errors path="age" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label></label></td>
                <td><form:button>Add</form:button></td>
            </tr>
        </table>
    </table>
</spring:form>
</body>
</html>
