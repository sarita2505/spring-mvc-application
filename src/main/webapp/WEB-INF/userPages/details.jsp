<%@ taglib prefix="c"
       uri="http://java.sun.com/jstl/core" %>

<html>
<body>
<h1>success</h1>
<c:out value="${details}"></c:out>
userName:<c:out value="${user.name}"/><br>
email:<c:out value="${user.email}"/><br>
password:<c:out value="${user.password}"/><br>
</body>
</html>