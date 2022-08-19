<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>#Moody</title>
    
    <script type="text/javascript">
	function loginCk() {
    
    	alert("로그인이 필요한 서비스입니다.");
   		location.href="<%=cp%>/shopmoody5/login.do";

 	}
</script>

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="<%=cp %>/moody/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="<%=cp %>/moody/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="<%=cp %>/moody/css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
	<div class="container-fluid">
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="<%=cp %>/2/moody_main.do" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">#</span>MOODY</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="상품 검색">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                <a href="" class="btn border">
                    <i class="fas fa-heart text-primary"></i>
                    <span class="badge">9999</span>
                </a>
<!-- 장바구니 숫자 코드 -->

               <c:choose>
							<c:when test="${empty sessionScope.memberInfo.id }">
						<a href="" class="btn border"> <i
					class="fas fa-shopping-cart text-primary" onclick="loginCk();"></i> <span class="badge">${countCart }</span></a>
								
							</c:when>
							<c:otherwise>
						<a href="<%=cp %>/shopmoody1/cart_list.do" class="btn border"> <i
					class="fas fa-shopping-cart text-primary" ></i> <span class="badge">${countCart }</span></a>
							
							</c:otherwise>
						
					</c:choose>
                
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid mb-5">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
             	      	 <a href="<%=cp %>/shopmoody4/best_list.do" class="nav-item nav-link">BEST50</a>
             	        <a href="<%=cp %>/shopmoody2/productlist.do" class="nav-item nav-link">NEW ITEMS</a>		
                        <a href="" class="nav-item nav-link">OUTER</a>
                        <a href="" class="nav-item nav-link">TOP</a>
                        <a href="" class="nav-item nav-link">BOTTOM</a>	
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="<%=cp %>/shopmoody2/moody_main.do" class="nav-item nav-link active">Home</a>
                            <a href="<%=cp %>/shopmoody2/productlist.do" class="nav-item nav-link">Shop</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">MyPage</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="<%=cp %>/shopmoody1/cart_list.do" class="dropdown-item">Shopping Cart</a>
                                    <a href="<%=cp %>/shopmoody1/checkout.do" class="dropdown-item">Checkout</a>
                                </div>
                            </div>
                            <div class="nav-item dropdown">
                           		 <a href="" class="nav-link dropdown-toggle" data-toggle="dropdown">Community</a>
                           		 <div class="dropdown-menu rounded-0 m-0">
                           		 	 <a href="cart.html" class="dropdown-item">Notice</a>
                                     <a href="checkout.html" class="dropdown-item">Q&A</a>
                                     <a href="<%=cp %>/shopmoody4/review_list.do" class="dropdown-item">Review</a>
                                 </div>
                            </div>
                        </div>
                       <c:choose>
							<c:when test="${empty sessionScope.memberInfo.id }">
								<div class="navbar-nav ml-auto py-0">

									<a href="<%=cp %>/shopmoody5/login.do" class="nav-item nav-link">Login</a>
									<a href="<%=cp %>/shopmoody5/join.do" class="nav-item nav-link">SingIn</a>
								</div>

							</c:when>
							<c:when
								test="${! empty sessionScope.memberInfo.id && sessionScope.memberInfo.id ne 'admin'}">
								<div class="navbar-nav ml-auto py-0">
									<b class="nav-item nav-link"> Hello [
										${sessionScope.memberInfo.name} ] !</b> <a
										href="<%=cp %>/shopmoody2/updated.do" class="nav-item nav-link">My
										Info</a> <a href="<%=cp %>/shopmoody5/logout.do"
										class="nav-item nav-link">Logout</a>
								</div>

							</c:when>
							<c:when test="${sessionScope.memberInfo.id eq 'admin' }">

								<div class="navbar-nav ml-auto py-0">
									<b class="nav-item nav-link"> Hello [
										${sessionScope.memberInfo.name} ] !</b> <a
										href="<%=cp %>/shopmoody2/go_updated_admin.do"
										class="nav-item nav-link">Set Product</a> <a
										href="<%=cp %>/shopmoody5/logout.do" class="nav-item nav-link">Logout</a>
								</div>

							</c:when>
						</c:choose>
                    </div>
                </nav>
                <div id="header-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
						<div class="carousel-item active" style="height: 410px;">
							<img class="img-fluid" src="<%=cp %>/moody/img/carousel-1.jpg"
								alt="Image">
							<div
								class="carousel-caption d-flex flex-column align-items-center justify-content-center">
								<div class="p-3" style="max-width: 700px;">
									<h4 class="text-light text-uppercase font-weight-medium mb-3">전고객 10%할인 코드 발행</h4>
									<h3 class="display-4 text-white font-weight-semi-bold mb-4">Fashionable
										Dress</h3>
									<a href="<%=cp %>/shopmoody2/productlist.do" class="btn btn-light py-2 px-3">Shop Now</a>
								</div>
							</div>
						</div>
						<div class="carousel-item" style="height: 410px;">
							<img class="img-fluid" src="<%=cp %>/moody/img/carousel-2.jpg"
								alt="Image">
							<div
								class="carousel-caption d-flex flex-column align-items-center justify-content-center">
								<div class="p-3" style="max-width: 700px;">
									<h4 class="text-light text-uppercase font-weight-medium mb-3">22 F/W시즌맞이 5% 할인</h4>
									<h3 class="display-4 text-white font-weight-semi-bold mb-4">Reasonable
										Price</h3>
									<a href="<%=cp %>/shopmoody2/productlist.do" class="btn btn-light py-2 px-3">Shop Now</a>
								</div>
							</div>
						</div>
					</div>
                    <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
                        <div class="btn btn-dark" style="width: 45px; height: 45px;">
                            <span class="carousel-control-prev-icon mb-n2"></span>
                        </div>
                    </a>
                    <a class="carousel-control-next" href="#header-carousel" data-slide="next">
                        <div class="btn btn-dark" style="width: 45px; height: 45px;">
                            <span class="carousel-control-next-icon mb-n2"></span>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Featured Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">고퀄리티<br/>자체제작</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                    <h5 class="font-weight-semi-bold m-0">조건부 무료 배송</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">14일 이내<br/>교환/환불</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center border mb-4" style="padding: 30px;">
                    <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0">24h 고객센터</h5>
                </div>
            </div>
        </div>
    </div>
    <!-- Featured End -->


    <!-- Categories Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            <div class="col-lg-4 col-md-6 pb-1">
                <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                    <p class="text-right">15 Products</p>
                    <a href="<%=cp %>/shopmoody4/best_list.do" class="cat-img position-relative overflow-hidden mb-3">
                        <img class="img-fluid" src="<%=cp %>/moody/img/cat-1.jpg" alt="">
                    </a>
                    <h5 class="font-weight-semi-bold m-0">Now, BEST!</h5>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 pb-1">
                <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                    <p class="text-right">15 Products</p>
                    <a href="" class="cat-img position-relative overflow-hidden mb-3">
                        <img class="img-fluid" src="<%=cp %>/moody/img/cat-2.jpg" alt="">
                    </a>
                    <h5 class="font-weight-semi-bold m-0">New Items!</h5>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 pb-1">
                <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                    <p class="text-right">15 Products</p>
                    <a href="" class="cat-img position-relative overflow-hidden mb-3">
                        <img class="img-fluid" src="<%=cp %>/moody/img/cat-3.jpg" alt="">
                    </a>
                    <h5 class="font-weight-semi-bold m-0">OUTER</h5>
                </div>
            </div>
        </div>
    </div>
    <!-- Categories End -->


    <!-- Offer Start -->
    <div class="container-fluid offer pt-5">
        <div class="row px-xl-5">
            <div class="col-md-6 pb-4">
                <div class="position-relative bg-secondary text-center text-md-right text-white mb-2 py-5 px-5">
                    <img src="<%=cp %>/moody/img/offer-1.png" alt="">
                    <div class="position-relative" style="z-index: 1;">
                        <h5 class="text-uppercase text-primary mb-3">20% off the all order</h5>
                        <h1 class="mb-4 font-weight-semi-bold">Early-Autumn</h1>
                        <a href="" class="btn btn-outline-primary py-md-2 px-md-3">Shop Now</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 pb-4">
                <div class="position-relative bg-secondary text-center text-md-left text-white mb-2 py-5 px-5">
                    <img src="<%=cp %>/moody/img/offer-2.png" alt="">
                    <div class="position-relative" style="z-index: 1;">
                        <h5 class="text-uppercase text-primary mb-3">20% off the all order</h5>
                        <h1 class="mb-4 font-weight-semi-bold">20-21 F/W</h1>
                        <a href="" class="btn btn-outline-primary py-md-2 px-md-3">Shop Now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Offer End -->


    <!-- Products Start -->
    <div class="container-fluid pt-5">
        <div class="text-center mb-4">
            <h2>Weekend BEST</h2>
        </div>
        <div class="row px-xl-5 pb-3">
        	<c:forEach var="prdto" items="${prlists }">
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
<!-- 여기 페이지넘 들고오는 수정필요 -->
                        <a href="${detailUrl }study/shopmoody2/product_detail_data.do?pageNum=1&pnum=${prdto.pnum}"><img class="img-fluid w-100" src="${imagePath}/${prdto.imageFile}"  alt=""></a>
                    </div>
                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                        <h6 class="text-truncate mb-3">${prdto.pname }</h6>
                        <div class="d-flex justify-content-center">
                            <h6><fmt:formatNumber value="${prdto.price*0.95}" type="number"/></h6>
                            <h6 class="text-muted ml-2"><del><fmt:formatNumber value="${prdto.price}" type="number"/></del></h6>
                        </div>
                    </div>
                    
                    <div class="card-footer d-flex justify-content-between bg-light border">
							<c:choose>
                                <c:when test="${sessionScope.memberInfo.id eq 'admin' }">
                                 <div>
								<h6>${prdto.hitCount }</h6>
							</div>
                                 </c:when>
                                <c:otherwise>
                                <a href="<%=cp %>/shopmoody2/product_detail_data.do?pnum=${prdto.pnum }" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i></a>
        						</c:otherwise>
                            </c:choose>
						</div>
                    
                </div>
            </div>
           </c:forEach>
        </div>
    </div>
    <!-- Products End -->


   

    <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">#</span>MOODY</h1>
                </a>
                <p>creating a certain mood or feeling. having moods that change often.</p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="<%=cp %>/shopmoody2/moody_main.do"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="<%=cp %>/shopmoody2/productlist.do"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="<%=cp %>/shopmoody4/best_list.do"><i class="fa fa-angle-right mr-2"></i>BEST50</a>
                            <a class="text-dark mb-2" href="<%=cp %>/shopmoody1/cart_list.do"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="<%=cp %>/shopmoody1/checkout.do"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                            <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
                        <form action="">
                            <div class="form-group">
                                <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
                                    required="required" />
                            </div>
                            <div>
                                <button class="btn btn-primary btn-block border-0 py-3" type="submit">Subscribe Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row border-top border-light mx-xl-5 py-4">
            <div class="col-md-6 px-xl-0">
                <p class="mb-md-0 text-center text-md-left text-dark">
                    &copy; <a class="text-dark font-weight-semi-bold" href="#">Your Site Name</a>. All Rights Reserved. Designed
                    by
                    <a class="text-dark font-weight-semi-bold" href="https://htmlcodex.com">HTML Codex</a>
                </p>
            </div>
            <div class="col-md-6 px-xl-0 text-center text-md-right">
                <img class="img-fluid" src="<%=cp %>/moody/img/payments.png" alt="">
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="<%=cp %>/moody/lib/easing/easing.min.js"></script>
    <script src="<%=cp %>/moody/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="<%=cp %>/moody/mail/jqBootstrapValidation.min.js"></script>
    <script src="<%=cp %>/moody/mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="<%=cp %>/moody/js/main.js"></script>
</body>

</html>