<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<html>
<body>
<a href="${pageContext.request.contextPath}/registration">Регистрация</a>
${error}
${sessionScope.get("user")}
${userException}
<c:forEach var="user" items="${users}">
    <p>${user.name}</p>
</c:forEach>
</body>
</html>
