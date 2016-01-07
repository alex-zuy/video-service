<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<h2>Register</h2>
<form:form commandName="user" action="/register" method="post">
    <div class="input-field">
        <label for="username">Username</label>
        <form:input path="username"/>
        <form:errors path="username"/>
    </div>
    <div class="input-field">
        <label for="email">Email</label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>
    <div class="input-field">
        <label for="password">Password</label>
        <form:password path="password"/>
        <form:errors path="password"/>
    </div>
    <div>
        <button class="btn" type="submit">Submit</button>
    </div>
</form:form>
</body>
