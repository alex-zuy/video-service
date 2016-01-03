<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Logout page</title>
</head>
<body>
    <h2>Logout</h2>
    <c:import url="common/nav.jsp"/>
    <form:form action="/logout" method="post">
        <div>
            <button type="submit">Logout</button>
        </div>
    </form:form>
    </body>
</html>
