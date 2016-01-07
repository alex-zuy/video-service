<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<h2>Login</h2>
<form:form commandName="login" action="/login" method="post">
    <div class="input-field">
        <label for="username">Username</label>
        <form:input path="username"/>
    </div>
    <div class="input-field">
        <label for="password">Password</label>
        <form:password path="password"/>
    </div>
    <div class="input-field">
        <button class="btn" type="submit">Submit</button>
    </div>
</form:form>
</body>
