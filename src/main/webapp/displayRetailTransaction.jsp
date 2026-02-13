<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wipro.retail.bean.RetailBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retail Record Details</title>
</head>
<body>
<h2>Retail Record Information</h2>
<%
String message = (String)request.getAttribute("message");
RetailBean bean = (RetailBean)request.getAttribute("bean");
if(message != null){
    out.println("<h3>" + message + "</h3>");
}
else if(bean != null){
%>
<hr>
Record ID: <%=bean.getRecordId()%><br/><br/>
Customer Name: <%=bean.getCustomerName()%><br/><br/>
Product Name: <%=bean.getProductName()%><br/><br/>
Purchase Date: <%=bean.getPurchaseDate()%><br/><br/>
Quantity: <%=bean.getQuantity()%><br/><br/>
Price: <%=bean.getPrice()%><br/><br/>
Remarks: <%=bean.getRemarks()%><br/><br/>
<%
}
%>
</body>
</html>
