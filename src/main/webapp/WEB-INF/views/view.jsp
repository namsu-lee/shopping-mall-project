<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>ìì¸ë³´ê¸° ì°ìµ</title>
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
		<!-- ìë¨ ë¤ë¹ë° ìë¦¬ -->
		<center>
			<h1>ìë¨ ë¤ë¹ë° ìë¦¬</h1>
			<br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/>
		</center>
		
		<!-- ì¬ì§ -->
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
		
		<!-- ìí ì ë³´ -->
		<table  width="556px" style="position:absolute; left:950px; top:265px;">
			<thead>
				<tr>
					<td text-align="center" colspan="2"><strong><h2>sgd365 ë´ì ì ë¡ì ì¤íì´ ëì ê°ëê±´ì¸í¸(G)</h2></strong></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><span><strike>17,000ì</strike></span></td>
				</tr>
				<tr>
					<td colspan="2">
						<span><font color="pink" size="5px;">22%</font></span>&nbsp;
						<span><font size="5px;">23,500ì</font></span>
					</td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td colspan="2"><span><strong><br/>ìì</span></strong></td>
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
					<td><span><strong>ì¬ì´ì¦ : free</span></strong></td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td><br/>
						<strong>ìë</strong>&nbsp;<span><input type="text" value="1" name="count" id="count" size="1px;" readonly></span>
						 &nbsp;<button type="button" onclick="Count_Plus()">ì¦ê°</button>
							   <button type="button" onclick="Count_Minus()">ê°ì</button>
					</td>
				</tr>
				<tr>
					<td colspan="2"><br/><hr></td>
				</tr>
				<tr>
					<td><font size="5px;">ì´ ê²°ì ê¸ì¡ : </font><font size="6px;" color="pink" id="total">23,500</font><font size="6px;" color="pink">ì</font></td>
				</tr>
				<tr>
					<td><button type="button" onclick="Shopping_Basket()" style="background-color:#39373A; width:270px; height:80px;"><font size="5px;" color="white">ì¥ë°êµ¬ë</font></button>&nbsp<button type="button" onclick="#" style="background-color:#FF7D9E; width:270px; height:80px;"><font size="5px" color="white">êµ¬ë§¤íê¸°</font></button></td>                                                        			
				</tr><!-- 304x78  270-->
			</tbody>
		</table>

		<script>
			//ìë ë° ê°ê²© ì¦ê°
			function Count_Plus() {
				var num   = document.getElementById("count").value;
				var price = document.getElementById("total").innerText;
				
				
				price = Number(price.replace(",", ""));
				var pri = 23500;	// priìë ëë¹ì ì ì¥ëì´ìë ìíì ê°ê²©ì´ ë¤ì´ìì¼íë¤. ì§ê¸ì ììë¡ ì
				price = pri + price;
				
				var result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

				
				num = Number(num) + 1;
				if(num == 101) {
					alert("ìµë ìëì ì´ê³¼íììµëë¤.");
					return;
				}
				
				document.getElementById("count").value = num;
				document.getElementById("total").innerText = result;
			}
			
			//ìë ë° ê°ê²© ê°ì
			function Count_Minus() {
				var num = document.getElementById("count").value;			//ìë
				var price = document.getElementById("total").innerText;		//ê°ê²©
				
				
				price = Number(price.replace(",", ""));				
				var pri = 23500;	// priìë ëë¹ì ì ì¥ëì´ìë ìíì ê°ê²©ì´ ë¤ì´ìì¼íë¤. ì§ê¸ì ììë¡ ì
				price = price - pri;
				
				var result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

				num = Number(num) - 1;
				if(num == 0) {
					return;
				}
				document.getElementById("count").value = num;
				document.getElementById("total").innerText = result;
			}
			
			//ì¥ë°êµ¬ë ì¶ê°
			function Shopping_Basket() {
				var count = document.getElementById("count").value;				//ì´ ìë
				var price = document.getElementById("total").innerText;			//ì´ ê²°ì  ê¸ì¡
				
				price = Number(price.replace(",", ""));
				
				if(!(confirm("ì¥ë°êµ¬ëì ì¶ê°íìê² ìµëê¹?"))) {
					return;
				}
					
				var data = {"count":count, "price":price};
				
				//ì¿ í¤ì ì¥ë°êµ¬ëì ì¶ê° í  ìí ì ë³´ ì¶ê°
				$.ajax({
					url: "#",
					data: data,
					type: "POST",
					success: function(result, status, xhr) {
						if(result.flag == true) {
							alert("ì¶ê°íìµëë¤.");
							//ajaxë¡ ì¿ í¤ì í´ë¹ ì ë³´ ì¶ê° í ë¬¼ì´ë³¸ë¤.
							if(confirm("ì¥ë°êµ¬ëë¡ ì´ëíìê² ìµëê¹?")) {
								alert("ì¥ë°êµ¬ëë¡ ì´ë");
								//location.href="#";
							}
							else {
								return;
							}
						}
					}
				});				
			}

			//ì¬ë¼ì´ë ì´ë¯¸ì§
			var slideIndex = 0; //ì¬ë¼ì¸ë ì¸ë±ì¤

			// HTML ë¡ëê° ëë í ëì
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