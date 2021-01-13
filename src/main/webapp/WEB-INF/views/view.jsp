<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>상세보기 연습</title>
		<script src="jquery-3.5.1.min.js"></script>
		<style>
			/* Slideshow container */
			.slideshow-container {
			  max-width: 1200px;
			  max-height: 750px;
			  position: relative;
			  margin: auto;
			}
			.slideshow-container .mySlides img {
			  height: 750px;
			}

			/* Hide the images by default */
			.mySlides {
			  display: none;
			}

			/* Next & previous buttons */
			.prev, .next {
			  cursor: pointer;
			  position: absolute;
			  top: 50%;
			  width: auto;
			  margin-top: -22px;
			  padding: 16px;
			  color: white;
			  font-weight: bold;
			  font-size: 18px;
			  transition: 0.6s ease;
			  border-radius: 0 3px 3px 0;
			  user-select: none;
			}

			/* Position the "next button" to the right */
			.next {
			  right: 0;
			  border-radius: 3px 0 0 3px;
			}

			/* On hover, add a black background color with a little bit see-through */
			.prev:hover, .next:hover {
			  background-color: rgba(0,0,0,0.8);
			}

			/* Caption text */
			.text {
			  color: #f2f2f2;
			  font-size: 15px;
			  padding: 8px 12px;
			  position: absolute;
			  bottom: 8px;
			  width: 100%;
			  text-align: center;
			}

			/* Number text (1/3 etc) */
			.numbertext {
			  color: #f2f2f2;
			  font-size: 12px;
			  padding: 8px 12px;
			  position: absolute;
			  top: 0;
			}

			/* The dots/bullets/indicators */
			.dot {
			  cursor: pointer;
			  height: 15px;
			  width: 15px;
			  margin: 0 2px;
			  background-color: #bbb;
			  border-radius: 50%;
			  display: inline-block;
			  transition: background-color 0.6s ease;
			}

			.active, .dot:hover {
			  background-color: #717171;
			}

			/* Fading animation */
			.fade {
			  -webkit-animation-name: fade;
			  -webkit-animation-duration: 1.5s;
			  animation-name: fade;
			  animation-duration: 1.5s;
			}

			@-webkit-keyframes fade {
			  from {opacity: .4}
			  to {opacity: 1}
			}

			@keyframes fade {
			  from {opacity: .4}
			  to {opacity: 1}
			}
		</style>
	</head>
	<body>
		<!-- 상단 네비바 자리 -->
		<center>
			<h1>상단 네비바 자리</h1>
			<br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/>
		</center>
		
		<!-- 사진 -->
		<table style="position:absolute; left:300px;">
			<tbody>
				<tr>
					<td>
						<div class="slideshow-container">
						<!-- Full-width images with number and caption text -->
							<div class="mySlides fade">
								<div class="numbertext">1 / 4</div>
								<img src="pink.jpg" style="width:556px; height:556px;">
							</div>

							<div class="mySlides fade">
								<div class="numbertext">2 / 4</div>
								<img src="black.jpg" style="width:556px; height:556px;">
							</div>

							<div class="mySlides fade">
								<div class="numbertext">3 / 4</div>
								<img src="lightblue.jpg" style="width:556px; height:556px;">
							</div>

							<div class="mySlides fade">
								<div class="numbertext">4 / 4</div>
								<img src="pink.jpg" style="width:556px; height:556px;">
							</div>
							<!-- Next and previous buttons -->
							<a class="prev" onclick="moveSlides(-1)">&#10094;</a>
							<a class="next" onclick="moveSlides(1)">&#10095;</a>
						</div>
						
						<br/>

						<!-- The dots/circles -->
						<div style="text-align:center">
						  <span class="dot" onclick="currentSlide(0)"></span>
						  <span class="dot" onclick="currentSlide(1)"></span>
						  <span class="dot" onclick="currentSlide(2)"></span>
						  <span class="dot" onclick="currentSlide(3)"></span>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<!-- 상품 정보 -->
		<table  width="556px" style="position:absolute; left:950px; top:265px;">
			<thead>
				<tr>
					<td text-align="center" colspan="2"><strong><h2>sgd365 봄신상 로위 스퀘어 나시 가디건세트(G)</h2></strong></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><span><strike>17,000원</strike></span></td>
				</tr>
				<tr>
					<td colspan="2">
						<span><font color="pink" size="5px;">22%</font></span>&nbsp;
						<span><font size="5px;">23,500원</font></span>
					</td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td colspan="2"><span><strong><br/>색상</span></strong></td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="color-1">
							<span class="img">
								<img src="black.jpg" style="width:60px; height:60px;">
								<input type="radio" name="color" id="color-1" value="black">
							</span>
						</label>
						<label for="color-2">
							<span class="img">
								<img src="lightblue.jpg" style="width:60px; height:60px;">
								<input type="radio" name="color" id="color-2" value="lightblue">
							</span>
						</label>
						<label for="color-3">
							<span class="img">
								<img src="red.jpg" style="width:60px; height:60px;">
								<input type="radio" name="color" id="color-3" value="red">
							</span>
						</label>
						<label for="color-4">
							<span class="img">
								<img src="pink.jpg" style="width:60px; height:60px;">
								<input type="radio" name="color" id="color-4" value="pink">
							</span>
						</label>
					</td>
				</tr>
				<tr>
					<td><br/><br/></td>
				</tr>
				<tr>
					<td><span><strong>사이즈 : free</span></strong></td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td><br/>
						<strong>수량</strong>&nbsp;<span><input type="text" value="1" name="count" id="count" size="1px;" readonly></span>
						 &nbsp;<button type="button" onclick="Count_Plus()">증가</button>
							   <button type="button" onclick="Count_Minus()">감소</button>
					</td>
				</tr>
				<tr>
					<td colspan="2"><br/><hr></td>
				</tr>
				<tr>
					<td><font size="5px;">총 결제금액 : </font><font size="6px;" color="pink" id="total">23,500</font><font size="6px;" color="pink">원</font></td>
				</tr>
				<tr>
					<td><button type="button" onclick="Shopping_Basket()" style="background-color:#39373A; width:270px; height:80px;"><font size="5px;" color="white">장바구니</font></button>&nbsp<button type="button" onclick="#" style="background-color:#FF7D9E; width:270px; height:80px;"><font size="5px" color="white">구매하기</font></button></td>                                                        			
				</tr><!-- 304x78  270-->
			</tbody>
		</table>

		<script>
			//수량 및 가격 증가
			function Count_Plus() {
				var num   = document.getElementById("count").value;
				var price = document.getElementById("total").innerText;
				
				
				price = Number(price.replace(",", ""));
				var pri = 23500;	// pri에는 디비에 저장되어있는 상품의 가격이 들어와야한다. 지금은 임의로 씀
				price = pri + price;
				
				var result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

				
				num = Number(num) + 1;
				if(num == 101) {
					alert("최대 수량을 초과하였습니다.");
					return;
				}
				
				document.getElementById("count").value = num;
				document.getElementById("total").innerText = result;
			}
			
			//수량 및 가격 감소
			function Count_Minus() {
				var num = document.getElementById("count").value;			//수량
				var price = document.getElementById("total").innerText;		//가격
				
				
				price = Number(price.replace(",", ""));				
				var pri = 23500;	// pri에는 디비에 저장되어있는 상품의 가격이 들어와야한다. 지금은 임의로 씀
				price = price - pri;
				
				var result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

				num = Number(num) - 1;
				if(num == 0) {
					return;
				}
				document.getElementById("count").value = num;
				document.getElementById("total").innerText = result;
			}
			
			//장바구니 추가
			function Shopping_Basket() {
				var count = document.getElementById("count").value;				//총 수량
				var price = document.getElementById("total").innerText;			//총 결제 금액
				
				price = Number(price.replace(",", ""));
				
				if(!(confirm("장바구니에 추가하시겠습니까?"))) {
					return;
				}
					
				var data = {"count":count, "price":price};
				
				//쿠키에 장바구니에 추가 할 상품 정보 추가
				$.ajax({
					url: "#",
					data: data,
					type: "POST",
					success: function(result, status, xhr) {
						if(result.flag == true) {
							alert("추가했습니다.");
							//ajax로 쿠키에 해당 정보 추가 후 물어본다.
							if(confirm("장바구니로 이동하시겠습니까?")) {
								alert("장바구니로 이동");
								//location.href="#";
							}
							else {
								return;
							}
						}
					}
				});				
			}

			//슬라이드 이미지
			var slideIndex = 0; //슬라인드 인덱스

			// HTML 로드가 끝난 후 동작
			window.onload=function(){
				showSlides(slideIndex);

				// Auto Move Slide
				var sec = 3000;
				setInterval(function(){
				slideIndex++;
				showSlides(slideIndex);

				}, sec);
			}


			// Next/previous controls
			function moveSlides(n) {
				slideIndex = slideIndex + n
				showSlides(slideIndex);
			}

			// Thumbnail image controls
			function currentSlide(n) {
				slideIndex = n;
				showSlides(slideIndex);
			}

			function showSlides(n) {

				var slides = document.getElementsByClassName("mySlides");
				var dots = document.getElementsByClassName("dot");
				var size = slides.length;

				if ((n+1) > size) {
					slideIndex = 0; n = 0;
				}
				else if (n < 0) {
					slideIndex = (size-1);
					n = (size-1);
				}

				for (i = 0; i < slides.length; i++) {
					slides[i].style.display = "none";
				}
				for (i = 0; i < dots.length; i++) {
					dots[i].className = dots[i].className.replace(" active", "");
				}

				slides[n].style.display = "block";
				dots[n].className += " active";
			}
		</script>
	</body>
</html>