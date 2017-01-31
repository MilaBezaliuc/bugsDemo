<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <link type="text/css" href="../css/styles.css" rel="stylesheet" />
</head>
<body>
<div>
    <div align="center">
        <div style="width: 300px; height: 500px;">
            <form:form method="GET" action="/login/endava">
                <div class="imgcontainer">
                    <img src="pics/incognito.jpg" alt="Avatar" class="avatar" height="100px">
                </div>
                <h3 align="center" style="color:maroon;">Hi there! Log in, please</h3>

                <div class="container" align="left">
                    <input type="password" size="27" placeholder="Password" name="password" required="required" />
              <button type="submit">Login</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
