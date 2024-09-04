<%@page import="com.demoboot.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <h2>List of Employee</h2>

    <!-- Unordered list to display names -->
    <ul>
        <!-- JSTL forEach tag to iterate over the list of names -->
        <c:forEach var="c" items="${empList}">
            <li>${c.name}</li>
            <li>${c.password}</li>
            <li>${c.email}</li>
            <li>${c.address}</li>
        </c:forEach>
    </ul>


<%

	List<Customer> ll=(List<Customer>)request.getAttribute("empList");
	for(Customer c : ll){
		%>
		
		Name is <%= c.getName() %>
		Password is <%= c.getPassword() %>
		Email is <%= c.getEmail() %>
		Address is <%= c.getAddress() %>
		
		<%
	}

%>

