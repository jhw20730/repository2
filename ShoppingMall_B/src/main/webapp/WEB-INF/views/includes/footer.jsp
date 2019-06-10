<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<!-- FOOTER -->
	<footer id="footer" class="section section-grey">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<!-- footer logo -->
						<div class="footer-logo">
							<a class="logo" href="#">
		            <img src="" alt=""> <!-- 쇼핑몰 로고 img -->
		          </a>
						</div>
						<!-- /footer logo -->

						<p>PC를 판매하는 쇼핑몰 설명설명설명</p>

					</div>
				</div>
				<!-- /footer widget -->

				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<h3 class="footer-header">My Account</h3>
						<ul class="list-links">
							<li><a href="/aboutUs">My Account</a></li> <!-- 회원 정보 조회 -->
							<li><a href="#">My Cart</a></li> <!--  장바구니 -->
							<sec:authorize access="isAuthenticated()">
								<li><a href="/customLogout">Logout</a></li>
							</sec:authorize>
							<sec:authorize access="isAnonymous()">
								<li><a href="/customLogin">Login</a></li>
							</sec:authorize>
						</ul>
					</div>
				</div>
				<!-- /footer widget -->

				<div class="clearfix visible-sm visible-xs"></div>

				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<h3 class="footer-header">Customer Service</h3>
						<ul class="list-links">
							<li><a href="/aboutUs">About Us</a></li> <!-- 쇼핑몰 설명 페이지 -->
							<li><a href="inquiry/list">Inquiry</a></li> <!-- 문의 게시판 페이지 -->
							<li><a href="#">Shiping Guide</a></li> <!-- 배송 가이드 페이지 -->
						</ul>
					</div>
				</div>
				<!-- /footer widget -->

			</div>
			<!-- /row -->
			<hr>
			<!-- row -->
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<!-- footer copyright -->
					<div class="footer-copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This web page is made with Team 2
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
					<!-- /footer copyright -->
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</footer>
	<!-- /FOOTER -->


</body>

</html>
