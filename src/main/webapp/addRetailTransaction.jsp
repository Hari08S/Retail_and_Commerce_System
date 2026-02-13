<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Record</title>
</head>
<body>
<h2>Add New Retail Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord"/>
Customer Name: <input type="text" name="customerName"/><br/><br/>
Product Name: <input type="text" name="productName"/><br/><br/>
Purchase Date: <input type="date" name="purchaseDate"/><br/><br/>
Quantity: <input type="text" name="quantity"/><br/><br/>
Price: <input type="text" name="price"/><br/><br/>
Remarks: <input type="text" name="remarks"/><br/><br/>
<input type="submit" value="Add"/>
<input type="reset" value="Clear"/>
</form>
</body>
</html>
