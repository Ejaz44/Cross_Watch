<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Cross Watches</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="resources/jq/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="resources/jq/simpleCart.min.js"> </script>
<link href="resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="resources/jq/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="resources/jq/jquery.easydropdown.js"></script>			
</head>
<body> 
	<!--top-header-->

	<!--bottom-header-->
	<!--banner-starts-->
	<div class="bnr" id="home">
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider4">
			    <li>
					<img src="resources/images/bnr-1.jpg" alt=""/>
				</li>
				<li>
					<img src="resources/images/bnr-2.jpg" alt=""/>
				</li>
				<li>
					<img src="resources/images/bnr-3.jpg" alt=""/>
				</li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!--banner-ends--> 
	<!--Slider-Starts-Here-->
				<script src="resources/jq/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			        auto: true,
			        pager: true,
			        nav: true,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			<!--End-slider-script-->
	<!--about-starts-->
	<div class="about"> 
		<div class="container">
			<div class="about-top grid-1">
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="resources/images/abt-1.jpg" alt=""/>
						<figcaption>
							<h2>Rolex</h2>
							<p>The first wristwatch with an automatically changing date on the dial</p>	
						</figcaption>			
				        </figure>
				</div>
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="resources/images/abt-2.jpg" alt=""/>
						<figcaption>
							<h4>Breitling</h4>
							<p>It was the Breitling Chronomat B01 with the in-house made and designed caliber 01 movement</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="resources/images/abt-3.jpg" alt=""/>
						<figcaption>
							<h4>Cras elit mauris</h4>
							<p>In sit amet sapien eros Integer dolore magna aliqua</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--about-end-->
	<!--product-starts-->
	<div class="product"> 
		<div class="container">
			<div class="product-top">
				<div class="product-one">
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/watch image2.jpg" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-2.png" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-3.png"  alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-4.png" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="product-one">
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-5.png" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-6.png" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-7.png" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="col-md-3 product-left">
						<div class="product-main simpleCart_shelfItem">
							<a href="single.html" class="mask"><img class="img-responsive zoom-img" src="resources/images/p-8.png" alt="" /></a>
							<div class="product-bottom">
								<h3>Smart Watches</h3>
								<p>Explore Now</p>
								<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">Rs 329</span></h4>
							</div>
							<div class="srch">
								<span>-50%</span>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>					
			</div>
		</div>
	</div>
	<!--product-end-->
	<!--information-starts-->

	<!--footer-end-->	
</body>
</html>
<%@include file="footer.jsp" %>