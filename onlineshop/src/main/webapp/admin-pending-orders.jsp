<%@page import="com.onlineshop.utility.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Online Shopping System</title>
        <!-- Importing all ui libs -->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script src="js/simpleCart.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <script src="js/jquery.easing.min.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <%
            //Checking whether admin in session or not
            if (session.getAttribute("uname") != null && session.getAttribute("uname") != "") {
        %>
        <jsp:include page="adminHeader.jsp"></jsp:include>
            <div class="content-wrapper">
                <div class="container-fluid">
                    <div class="row pad-botm">
                        <div class="col-md-12">
                            <h4 class="header-line">Pending Orders</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="panel panel-success">
                                <div class="panel-heading">Pending Orders</div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Order No</th>
                                                    <th>Customer Details</th>
                                                    <th>Product</th>
                                                    <th>Qty</th>
                                                    <th>Total Amount</th>
                                                    <th>Status</th>
                                                    <th>Date</th>
                                                    <th>Payment Mode</th>
                                                </tr>
                                            </thead>
                                        <%
                                            ResultSet resultOrders = DatabaseConnection.getResultFromSqlQuery("select * from tblorders where order_status='Pending'");
                                            while (resultOrders.next()) {
                                        %>
                                        <tbody>
                                            <tr>
                                                <td><%=resultOrders.getInt(1)%></td>
                                                <td><%=resultOrders.getInt(2)%></td>
                                                <td><%=resultOrders.getString(3)%>|<%=resultOrders.getString(4)%>|<%=resultOrders.getString(5)%>|<%=resultOrders.getString(6)%>|<%=resultOrders.getString(7)%>|<%=resultOrders.getString(8)%></td>
                                                <td><img src="uploads/<%=resultOrders.getString(9)%>"
                                                         alt="" class="pro-image-front"
                                                         style="width: 150px; height: 100px;"><br><%=resultOrders.getString(10)%></td>
                                                <td><%=resultOrders.getString(11)%></td>
                                                <td><%=resultOrders.getString(14)%></td>
                                                <%
                                                    if (resultOrders.getString(15).equals("Deliver")) {
                                                %>
                                                <td><span class="label label-success">Delivered</span></td>
                                                <%
                                                } else {
                                                %>
                                                <td><span class="label label-danger">Pending</span></td>
                                                <%
                                                    }
                                                %>
                                                <td><%=resultOrders.getString(16)%></td>
                                                <td><%=resultOrders.getString(17)%></td>
                                            </tr>
                                        </tbody>
                                        <%
                                            }
                                        %>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
            <script src="assets/js/jquery-1.10.2.js"></script>
            <script src="assets/js/bootstrap.js"></script>
            <script src="assets/js/custom.js"></script>
        <%
            } else {
                response.sendRedirect("admin-login.jsp");
            }
        %>
    </body>
</html>