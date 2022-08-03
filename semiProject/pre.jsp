<%@page import="com.score.CustomInfo"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp= request.getContextPath(); 
	
	//세션 정보 읽어오기
	////MemberInfo info=(MemberInfo)session.getAttribute("memberinfo");
%>

<!DOCTYPE html>
<html lang="en">

<script type="text/javascript">

function sendCoupon(){
	
	var f=document.myForm;
	
		f.action="<%=cp%>/shopmoody/cart_coupon.do";
		f.submit();
	
}
</script>


<head>
    <meta charset="utf-8">
    <title>장바구니</title>
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
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="<%=cp %>/moody/css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark" href="">FAQs</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Help</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Support</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a class="text-dark pl-2" href="">
                        <i class="fab fa-youtube"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">#</span>MOODY</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
<!-- 찜기능 -->
            <div class="col-lg-3 col-6 text-right">
                <a href="" class="btn border">
                    <i class="fas fa-heart text-primary"></i>
                    <span class="badge">0</span>
                </a>
<!-- 장바구니 기능 :장바구니cnt 불러오기 -->
                <a href="<%=cp %>/shopmoody/cart_list.do" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">${countCart}</span>
                </a>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <a href="" class="nav-item nav-link">Top</a>
                        <a href="" class="nav-item nav-link">Bottom</a>
                        <a href="" class="nav-item nav-link">Outer</a>
                        <a href="" class="nav-item nav-link">etc.</a>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
            <!-- 여기 코드 3줄 자름.. 필요없어보여서 ㅋㅎ -->
                   
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="index.html" class="nav-item nav-link">Home</a>
                            <a href="shop.html" class="nav-item nav-link">Shop</a>
                            <a href="detail.html" class="nav-item nav-link">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle active" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="cart.html" class="dropdown-item">Shopping Cart</a>
                                    <a href="checkout.html" class="dropdown-item">Checkout</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                        
                        <c:choose>
						<c:when test="${empty sessionScope.memberInfo.id }">
                        
                        <div class="navbar-nav ml-auto py-0">
                            <a href="<%=cp %>/shopmoody/login.do" class="nav-item nav-link">Login</a>
                            <a href="" class="nav-item nav-link">Join</a>
                        </c:when>
						<c:otherwise>
                            <a href="<%=cp %>/shopmoody/cart_list.do" class="nav-item nav-link">MyPage</a>
                            <a href="<%=cp %>/shopmoody/logout.do" class="nav-item nav-link">Logout</a>
                        </div>
                        
                        </c:otherwise>
                        </c:choose>
                        
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Shopping Cart</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                         	<th>Serial NO.</th>
                            <th>Products</th>
                            <th>Size</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <!-- 201라인까지 하나의 세트-->
                    <c:set var="subtotal" value="0" />
                    <c:forEach var="dto" items="${lists }" varStatus="status">
                    <c:set var="subtotal" value="${subtotal+( dto.cnt * dto.price) }" />
                        <tr>
                        	<td class="align-middle">${dto.pnum }</td>
                            <td class="align-middle">${dto.pname }</td>
                            <td class="align-middle">${dto.psize }</td>
                            <td class="align-middle"><fmt:formatNumber value="${dto.price }" type="number"/></td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus" onclick="location='<%=cp%>/shopmoody/cart_minus.do?num=${dto.num }&cnt=${dto.cnt }';">
                                        <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center" value="${dto.cnt }">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus" onclick="location='<%=cp%>/shopmoody/cart_plus.do?num=${dto.num }&cnt=${dto.cnt }';">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle"><fmt:formatNumber value="${dto.cnt * dto.price }" type="number"/></td>
                            <td class="align-middle"><button class="btn btn-sm btn-primary"  onclick="location='<%=cp%>/shopmoody/cart_delete.do?num=${dto.num }';"><i class="fa fa-times"></i></button></td>
                        	
                        </tr>
                      </c:forEach>
                      </tbody>
                      </table>
                      </div>
            <!-- 여기 쿠폰적용 삭제함. 나중에 추가하고싶음 하셔요 -->
            <div class="col-lg-4">
                <form class="mb-5" action=" " name="myForm">
                <div class="input-group">
                        <input type="text" class="form-control p-4" name="coupon" placeholder="Coupon Code">
                        <div class="input-group-append">
                            <button class="btn btn-primary" onclick="sendCoupon();">Apply Coupon</button>
                       </div>
                    </div>
                    <div class="input-group-append">
                           <td >${message }</td>
                        </div>
                </form>
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Subtotal</h6>
                            <h6 class="font-weight-medium">
                            <fmt:parseNumber var="pages" integerOnly="true" value="${subtotal*discount }"/>
                            <fmt:formatNumber value="${pages}" type="number"/>원</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                        <c:choose>
						<c:when test="${subtotal*discount < 300000}">
							<h6 class="font-weight-medium">2500원(30만원이상 구매시 무료)</h6>
						</c:when>
						<c:otherwise>
							<h6 class="font-weight-medium">free</h6>
						</c:otherwise>
						</c:choose>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                        <c:choose>
						<c:when test="${subtotal*discount < 300000}">
							<h5 class="font-weight-bold">${pages +2500}원</h5>
						</c:when>
						<c:otherwise>
							<h5 class="font-weight-bold">
							<fmt:formatNumber value="${pages}" type="number"/>원</h5>
						</c:otherwise>
						</c:choose>
                            
                        </div>
                        <button class="btn btn-block btn-primary my-3 py-3"><b>결 제 하 기</b></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Cart End -->


    <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">#</span>MOODY</h1>
                </a>
                <p>creating a certain mood or feeling. having moods that change often. </p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                            <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
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