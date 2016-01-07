<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<h2>Logout</h2>
<form:form action="/logout" method="post">
    <div>
        <button class="btn" type="submit">Logout</button>
    </div>
</form:form>
</body>
