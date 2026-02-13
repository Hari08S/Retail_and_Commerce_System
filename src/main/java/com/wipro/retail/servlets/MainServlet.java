package com.wipro.retail.servlets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import com.wipro.retail.bean.RetailBean;
import com.wipro.retail.service.Administrator;
public class MainServlet extends HttpServlet {
    Administrator admin = new Administrator();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String operation = req.getParameter("operation");
        if (operation.equals("newRecord")) {
            String result = addRecord(req);
            if (result.equals("FAIL") || result.equals("INVALID INPUT"))
                resp.sendRedirect("error.html");
            else
                resp.sendRedirect("success.html");
        }
        else if (operation.equals("viewRecord")) {
            RetailBean bean = viewRecord(req);
            if (bean == null) {
                req.setAttribute("message", "No matching records exists! Please try again!");
            } else {
                req.setAttribute("bean", bean);
            }

            RequestDispatcher rd = req.getRequestDispatcher("displayRetailTransaction.jsp");
            rd.forward(req, resp);
        }
        else if (operation.equals("viewAllRecords")) {
            List<RetailBean> list = admin.viewAllRecords();
            if (list.isEmpty())
                req.setAttribute("message", "No records available!");
            else
                req.setAttribute("list", list);
            RequestDispatcher rd = req.getRequestDispatcher("displayAllRetailTransactions.jsp");
            rd.forward(req, resp);
        }
    }
    public String addRecord(HttpServletRequest request) {
        try {
            RetailBean bean = new RetailBean();
            bean.setCustomerName(request.getParameter("customerName"));
            bean.setProductName(request.getParameter("productName"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            bean.setPurchaseDate(sdf.parse(request.getParameter("purchaseDate")));
            bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            bean.setPrice(Double.parseDouble(request.getParameter("price")));
            bean.setRemarks(request.getParameter("remarks"));
            return admin.addRecord(bean);
        } catch (Exception e) {
            return "FAIL";
        }
    }
    public RetailBean viewRecord(HttpServletRequest request) {
        try {
            String customerName = request.getParameter("customerName");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(request.getParameter("purchaseDate"));
            return admin.viewRecord(customerName, date);
        } catch (Exception e) {
            return null;
        }
    }
}