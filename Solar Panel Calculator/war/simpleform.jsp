<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Simple User Demo</title>
</head>
<body>
<form action="/result" method="post">
System cost: <input name="systemCost" type="text" size="30" maxlength="30"><br>
System size (KW): <input name="systemSize" type="text" size="30" maxlength="30"><br>
Panel age efficiency loss: <input name="panelAgeEfficiencyLoss" type="text" size="30" maxlength="30"><br>
Inverter efficiency: <input name="inverterEfficiency" type="text" size="30" maxlength="30"><br><br>
Average daily hours of sunlight: <input name="averageDailySunlight" type="text" size="30" maxlength="30"><br>
Daily average usage (KWh): <input name="dailyAverageUsage" type="text" size="30" maxlength="30"><br><br>

<input type="submit" value="Submit "> <input type="reset" value="Reset">
</form>
</body>
</html>