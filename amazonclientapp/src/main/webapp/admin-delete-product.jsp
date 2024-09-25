
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<%
    
    int deleteProduct = Integer.parseInt(request.getAttribute("customerresult").toString());
    if (deleteProduct > 0) {
        response.sendRedirect("admin-view-product.jsp");
    } else {
        response.sendRedirect("admin-view-product.jsp");
    }
%>