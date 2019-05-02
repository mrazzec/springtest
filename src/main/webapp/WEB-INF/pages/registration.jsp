<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <td><label>Name:</label></td>
                <td>
                    <spring:input path="name" />
                    <spring:errors path="name" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Pass:</label></td>
                <td>
                    <spring:input path="pass" />
                    <spring:errors path="pass" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td>
                    <spring:input path="email" />
                    <spring:errors path="email" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label>Age:</label></td>
                <td>
                    <spring:input path="age" />
                    <spring:errors path="age" cssClass="error"/>
                </td>

            </tr>

            <tr>
                <td><label></label></td>
                <td><spring:button>Add</spring:button></td>
            </tr>
        </table>
    </table>
</spring:form>
</body>
</html>
