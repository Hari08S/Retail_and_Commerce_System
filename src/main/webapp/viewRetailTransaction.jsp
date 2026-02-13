<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Retail Transaction</title>
</head>
<body>
<h2>View Retail Transaction</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewRecord"/>
Customer Name: <input type="text" name="customerName"/><br/><br/>
Purchase Date: <input type="date" name="purchaseDate"/><br/><br/>
<input type="submit" value="View"/>
</form>
</body>
</html>