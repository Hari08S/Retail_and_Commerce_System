<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.wipro.retail.bean.RetailBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Retail Records</title>
</head>
<body>
<h2>Retail Records</h2>
<%
String message = (String)request.getAttribute("message");
List<RetailBean> list = (List<RetailBean>)request.getAttribute("list");

if(message != null){
    out.println("<h3>" + message + "</h3>");
}
else if(list != null){
    for(RetailBean bean : list){
%>
<hr>
Record ID: <%=bean.getRecordId()%><br/>
Customer Name: <%=bean.getCustomerName()%><br/>
Product Name: <%=bean.getProductName()%><br/>
Purchase Date: <%=bean.getPurchaseDate()%><br/>
Quantity: <%=bean.getQuantity()%><br/>
Price: <%=bean.getPrice()%><br/>
Remarks: <%=bean.getRemarks()%><br/>

<%
    }
}
%>
</body>
</html>
