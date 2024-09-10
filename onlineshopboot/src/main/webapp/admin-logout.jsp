<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    //Invalidating the session and sending response back to the admin login page
    session.invalidate();
    response.sendRedirect("admin-login.jsp");
%>