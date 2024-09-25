<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.amazonclientapp.dto.Product"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <!-- Importing all ui libs -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/pignose.layerslider.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <script src="js/jquery.easing.min.js"></script>
   <!--  <script src='../../../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
    <script src="../../../../../../m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
 --></head>
<body>
<body>
    <div class="ban-top">
        <div class="container">
            <div class="top_nav_left">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed"
                                    data-toggle="collapse"
                                    data-target="#bs-example-navbar-collapse-1"
                                    aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                            </button>
                        </div>
                        <jsp:include page="header.jsp"></jsp:include>
                        </div>
                    </nav>
                </div>
                <div class="top_nav_right">
                    <div class="cart box_1">
                        <a href="checkout"> 
                        <%
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
    <div class="banner-grid">
        <div id="visual">
            <div class="slide-visual">
                <ul class="slide-group">
                    <li><img class="img-responsive" src="images/ba1.jpg" alt="Dummy Image" /></li>
                    <li><img class="img-responsive" src="images/ba2.jpg" alt="Dummy Image" /></li>
                    <li><img class="img-responsive" src="images/ba3.jpg" alt="Dummy Image" /></li>
                </ul>
                <div class="script-wrap">
                    <ul class="script-group">
                        <li><div class="inner-script">
                                <img class="img-responsive" src="images/baa1.jpg" alt="Dummy Image" />
                            </div></li>
                        <li><div class="inner-script">
                                <img class="img-responsive" src="images/baa2.jpg" alt="Dummy Image" />
                            </div></li>
                        <li><div class="inner-script">
                                <img class="img-responsive" src="images/baa3.jpg" alt="Dummy Image" />
                            </div></li>
                    </ul>
                    <div class="slide-controller">
                        <a href="#" class="btn-prev"><img src="images/btn_prev.png"
                                                          alt="Prev Slide" /></a> <a href="#" class="btn-play"><img
                                src="images/btn_play.png" alt="Start Slide" /></a> <a href="#"
                                                                              class="btn-pause"><img src="images/btn_pause.png"
                                               alt="Pause Slide" /></a> <a href="#" class="btn-next"><img
                                src="images/btn_next.png" alt="Next Slide" /></a>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
        <script type="text/javascript" src="js/pignose.layerslider.js"></script>
        <script type="text/javascript">
            $(window).load(function () {
                $('#visual').pignoseLayerSlider({
                    play: '.btn-play',
                    pause: '.btn-pause',
                    next: '.btn-next',
                    prev: '.btn-prev'
                });
            });
        </script>
    </div>
    <br/>
    <div class="product-easy">
        <div class="container">
            <div class="container">
                <h2>
                    <span><center>Our Products</center></span>
                </h2>
            </div>
            <%
               // ResultSet retriveProduct = DatabaseConnection.getResultFromSqlQuery("select * from tblproduct");
            List ll=(List)request.getAttribute("allproduct");
            
            for (Object ss:ll) {
            	LinkedHashMap retriveProduct=(LinkedHashMap)ss;
            %>
            <form action="AddToCart" method="post">
                <div class="single-pro">
                    <div class="col-md-3 product-men">
                        <div class="men-pro-item simpleCart_shelfItem">
                            <div class="men-thumb-item">
                                <input type="hidden" name="productId"
                                       value="<%=retriveProduct.get("id")%>"> <img
                                       src="uploads/<%=retriveProduct.get("image_name")%>"
                                       alt="" class="pro-image-front"> <img
                                       src="uploads/<%=retriveProduct.get("image_name")%>"
                                       alt="" class="pro-image-back"> <span
                                       class="product-new-top">New</span>
                            </div>
                            <div class="item-info-product ">
                                <h4>
                                    <a href=""><%=retriveProduct.get("name")%></a>
                                </h4>
                                <h5>
                                    Category: <%=retriveProduct.get("product_category")%>
                                </h5>
                                <div class="info-product-price">
                                    <input type="hidden" name="price"
                                           value="<%=retriveProduct.get("price")%>"> <input
                                           type="hidden" name="mrp_price"
                                           value="<%=retriveProduct.get("mrp_price")%>"> <span
                                           class="item_price"><%=retriveProduct.get("price")%> Rs.</span>
                                    <del><%=retriveProduct.get("mrp_price")%> Rs.</del>
                                </div>
                                <input type="submit" value="Add to cart" class="btn btn-warning" onclick="return confirm('Are you sure Do you want to add this item in cart?');">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <%
                }
            %>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>