<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
    <title><decorator:title default="Video service"/></title>
    <script src="/webjars/jquery/2.1.4/jquery.js"></script>
    <link rel="stylesheet" href="/webjars/materializecss/0.97.0/css/materialize.css"/>
    <script src="/webjars/materializecss/0.97.0/js/materialize.js"></script>
    <style>
        body {
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }

        main {
            flex: 1 0 auto;
        }
    </style>
</head>
<body>
    <header>
        <jsp:include page="./fragments/nav.jsp"/>
    </header>
    <main>
        <div class="container">
            <decorator:body />
        </div>
    </main>
    <footer class="page-footer">
        <jsp:include page="./fragments/footer.jsp"/>
    </footer>
</body>
</html>
