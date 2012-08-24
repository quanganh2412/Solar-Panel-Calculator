<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Simple User Demo</title>
</head>
<body>
<form action="/calculate" method="post">
Text 1: <input name="text" type="text" size="30" maxlength="30"><br>
<input type="checkbox" name="checkbox" value="salami">Checkbox 1<br>
<input type="hidden" name="hiddenValue" value="1">

<input type="submit" value="Submit "> <input type="reset" value="Reset">
</form>
</body>
</html>