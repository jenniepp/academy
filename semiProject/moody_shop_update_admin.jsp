<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>EShopper - Bootstrap Shop Template</title>
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
                <a href="" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
          
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="상품 검색">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
         
            </div>
            <div class="col-lg-3 col-6 text-right">
                <a href="" class="btn border">
                    <i class="fas fa-heart text-primary"></i>
                    <span class="badge">0</span>
                </a>
                <a href="" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">0</span>
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
                   <div class="navbar-nav w-100 overflow-hidden" style="height: 245px;">
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
                    <a href="<%=cp %>/shopmoody2/moody_main.do" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">#</span>MOODY</h1>
                    </a>
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
                                    <a href="cart.html" class="dropdown-item">Shopping Cart</a>
                                    <a href="checkout.html" class="dropdown-item">Checkout</a>
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
                     
                            <a href="<%=cp %>/shopmoody2/login.do" class="nav-item nav-link">Login</a>
                            <a href="<%=cp %>/shopmoody2/created.do" class="nav-item nav-link">SingIn</a>
                        </div>
                    
	</c:when>
	<c:when test="${! empty sessionScope.memberInfo.id && sessionScope.memberInfo.id ne 'admin'}">
		 <div class="navbar-nav ml-auto py-0">
               <b class="nav-item nav-link"> Hello [ ${sessionScope.memberInfo.name} ] !</b>          
                            <a href="<%=cp %>/shopmoody2/updated.do" class="nav-item nav-link">My Info</a>
                            <a href="<%=cp %>/shopmoody2/logout.do" class="nav-item nav-link">Logout</a>
                        </div>
                    
	</c:when>
	<c:when test="${sessionScope.memberInfo.id eq 'admin' }">
	
	<div class="navbar-nav ml-auto py-0">
     <b class="nav-item nav-link"> Hello [ ${sessionScope.memberInfo.name} ] !</b>                    
    <a href="<%=cp %>/shopmoody2/go_updated_admin.do" class="nav-item nav-link">Set Product</a>
    <a href="<%=cp %>/shopmoody2/logout.do" class="nav-item nav-link">Logout</a>
    </div>
	
	</c:when>
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
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Update Product</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="location='<%=cp%>/shopmoody2/main.do'">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Update Product</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Checkout Start -->
    <form method="post" name="updateForm" action="<%=cp%>/shopmoody2/uploaded_ok.do"
    enctype="multipart/form-data">
    <div class="container-fluid pt-5">
                <div class="row px-xl-5" style="display: flex;justify-content: center;align-items: center">
            <div class="col-lg-8" >
           
                <div class="mb-4" >
                    <h4 class="font-weight-semi-bold mb-4" align="center">Update Product</h4>
                    <div class="" >
                    <div class="col-md-6 form-group" style="margin: auto;">
                            <label>상품번호</label>
                            <input class="form-control" type="text" name="pnum" >
                        </div>
                       
                        <br/>
                        
                        <div class="col-md-6 form-group" style="margin: auto;">
                            <label>상품 상세 설명</label>
                            <input class="form-control" type="file" name="description" >
                      <br/>
                        </div>
                        <div class="col-md-6 form-group" style="margin: auto;">
                            <label>상품명</label>
                            <input class="form-control" type="text" name="pname" >
                        <br/>
                        </div>
                        
                       
                         <div class="col-md-6 form-group" style="margin: auto;">
                            <label>상품 가격</label>
                            <input class="form-control" type="text" name="price" >
                       <br/>
                        </div>
                        
                       <div class="col-md-6 form-group" style="margin: auto;">
                            <label>상품 썸네일</label>
                            <input class="form-control" type="file" name="preview" >
                      <br/>
                        </div>
                            
				  </div>
				 
                       
                       
                       
                       
                       
                        
                         
                        
                       </div>
               </div>        
              
            
                    <div class="card-footer border-secondary bg-transparent" style="display: flex;justify-content: center;">
                        <button class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3"
                        type="submit" >Update</button>&nbsp;
                         <button class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3" 
                        type="button" onclick="location='<%=cp%>/shopmoody2/main.do';"
                         >Cancel</button>&nbsp;
                    </div>
                  
                 </div>
            </div> 
       
    </form>
    
   
    <!-- Checkout End -->


    <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper</h1>
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
                        <form >
                            <div class="form-group">
                                <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
                                    required="required" />
                            </div>
                            <div>
                                <button class="btn btn-primary btn-block border-0 py-3" type="button">Subscribe Now</button>
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