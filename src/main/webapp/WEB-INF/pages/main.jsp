<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message Saver</title>
    <script>
        function change(){
            var source= document.getElementById("source");
            var destination= document.getElementById("destination");
            destination.value=source.value;
        }
    </script>
    <link type="text/css" href="../css/styles.css" rel="stylesheet" />

</head>
<body>
<br>
<h2 align="center">*************** Follow the steps: ***************</h2>
<form action="/main2">
    <p>1. Click this button. It has to refresh your current page. Investigate what's the problem. </p>
    <button type="submit">Click</button>
</form>

<form action="/main" method="post">
    <p>2. Type a name. Then click the button to save it in the local storage. If it is successfully saved, you will see this name in the dropdown list below.</p>
        <input type="text" name="message" id="source" onkeyup="change();">
        <button type="submit">Save to local storage</button>

</form>
<form action="/dbsave">
    <p>3. Press this button to save to database. Check if name has appeared in database</p>
        <input type="text" name="message" id="destination" >
        <button type="submit">Save to database</button>

</form>

<form action="/delete">
    <p>4. Delete selected name from local storage and database</p>
        <select name="message">
            <c:forEach items="${set}" var="s">
                <option >${s}</option>
            </c:forEach>
        </select>
        <button type="submit">Delete from all storages</button>

</form>



</body>
</html>
