
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.amazonclientapp.dto.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
        <script src="jquery-3.2.1.min.js"></script>
        <script src='../../../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
        <script src="../../../../../../m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            //Checking whether customer in session or not
            if (session.getAttribute("name") != null && session.getAttribute("name") != "") {
        %>
    <body>
        <div class="ban-top">
            <div class="container">
                <div class="top_nav_left">
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                                </button>
                            </div>
                            <jsp:include page="header.jsp"></jsp:include>
                            </div>
                        </nav>
                    </div>
                    <div class="top_nav_right">
                        <div class="cart box_1">
                            <a href="checkout.jsp"> 
                            <%
                                //Getting count of products of cart
                                int count =(Integer) request.getAttribute("totalcartitem");
                            %>
                            <h3>
                                <div class="total">
                                    <i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>
                                    (
                                    <%=count%>
                                    items )
                                </div>
                            </h3>
                        </a>
                        <p>
                            <a href="javascript:;" class="simpleCart_empty">My Cart</a>
                        </p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="page-head">
            <div class="container">
                <h3>My Orders</h3>
            </div>
        </div>
        <div class="checkout">
            <div class="container">
                <h3>My Orders</h3>
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>SR.No</th>
                                <th>Order No</th>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>MRP($)</th>
                                <th>Selling Price($)</th>
                                <th>Total Price($)</th>
                                
                                <th>Status</th>
                            </tr>
                        </thead>
                        <%
                            int index = 0;
                            //Getting all products
                            List totalProduct1 = (List)request.getAttribute("myorder");
                            for (Object ss:totalProduct1) {
                            	//System.out.println("pppp "+ss);
                       	
                            	LinkedHashMap totalProduct=(LinkedHashMap)ss;
                                index++;
                        %>
                        <tr class="rem1">
                            <td class="invert"><%=index%></td>
                            <td class="invert"><%=totalProduct.get("order_no")%></td>
                            <td class="invert"><img src=uploads/<%=totalProduct.get("image")%> style="width: 150px; height: 100px;"><br><%=totalProduct.get("quantity")%></td>
                            <td class="invert"><%=totalProduct.get("quantity")%></td>
                            <td class="invert"><del><%=totalProduct.get("product_price")%></del></td>
                            <td class="invert"><%=totalProduct.get("product_selling_price")%></td>
                            <td class="invert"><%=totalProduct.get("product_total_price")%></td>
                            
                           
                            <%
                                //If order is delivered
                                if (totalProduct.get("order_status").equals("Deliver")) {
                            %>
                            <td><span class="label label-success"><strong>Delivered</strong></span></td>
                            <%
                            } else {
                            %>
                            <td><span class="label label-danger"><strong>Pending</strong></span></td>
                            <%
                                }
                            %>
                        </tr>
                        <%
                            }
                        %>
                        <script>
                            $('.value-plus').on('click', function () {
                                var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) + 1;
                                divUpd.text(newVal);
                            });

                            $('.value-minus').on('click', function () {
                                var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) - 1;
                                if (newVal >= 1)
                                    divUpd.text(newVal);
                            });
                        </script>
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <%
            } else {
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>