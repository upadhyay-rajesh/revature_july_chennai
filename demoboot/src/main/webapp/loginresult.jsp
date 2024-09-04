<%@page isELIgnored="false" %>

<%

	String str=request.getAttribute("registrationresult").toString();
	if(str.equals("Login Fail")){
		%>
		<%= "Invalid id and password" %>
		<%@include file="signin.jsp" %>
		<%
	}
	else{
%>


${registrationresult}

<a href="displayAll">display all profile</a>
<a href="deleteProfile">delete profile</a>
<a href="editProfile">edit profile</a>
<a href="viewProfile">view profile</a>

<%
}
%>