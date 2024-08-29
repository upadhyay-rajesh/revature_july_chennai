<%@page import="com.onlineshop.utility.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Online Shopping System</title>
        <!-- Importing all ui libs -->
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
                <div class="container">
                    <div class="row pad-botm">
                        <div class="col-md-12">
                            <h4 class="header-line">ADMIN DASHBOARD</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 col-sm-4 col-xs-6">
                            <div class="alert alert-info back-widget-set text-center">
                                <i class="fa fa-history fa-5x"></i>
                            <%
                                //Count product query
                                ResultSet totalProduct = DatabaseConnection.getResultFromSqlQuery("select count(*) from tblproduct");
                                totalProduct.next();
                                int allProducts = totalProduct.getInt(1);
                            %>
                            <h3>
                                <%=allProducts%>
                            </h3>
                            Total Products
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-6">
                        <div class="alert alert-success back-widget-set text-center">
                            <i class="fa fa-users fa-5x"></i>
                            <%
                                //Count customer query
                                ResultSet totalCustomer = DatabaseConnection.getResultFromSqlQuery("select count(*) from tblcustomer");
                                totalCustomer.next();
                                int allCustomer = totalCustomer.getInt(1);
                            %>
                            <h3><%=allCustomer%></h3>
                            Total Customers
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-6">
                        <div class="alert alert-warning back-widget-set text-center">
                            <i class="fa fa-recycle fa-5x"></i>
                            <%
                                //Count orders query
                                ResultSet totalOrders = DatabaseConnection.getResultFromSqlQuery("select count(*) from tblorders");
                                totalOrders.next();
                                int allOrders = totalOrders.getInt(1);
                            %>
                            <h3><%=allOrders%></h3>
                            Total Orders
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