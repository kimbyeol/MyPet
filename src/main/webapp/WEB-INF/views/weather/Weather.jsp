<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGOVgSZuqIfEJJnu96TsMSHd8UZP-p9uM&callback=iniMap"></script>
		<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
		
		<style type="text/css">
			#map {
				height: 400px;
				width: 798px;
				border:1px solid #ccc;
			}
		</style>
	</head>
	
	<body style="background-color: linen;">
		<h2>위치를 지정해주세요!</h2>
		<div id="mapdiv" style="text-align: -webkit-center;">
			<div id="map"></div>
		</div>
		
		<input id="locationBtn" class="btn-fill" type="button" style="margin: 20px;" value="확인"/>
		
		<div class="weather-tc"></div>
		<div class="weather-tmin"></div>
		<div class="sky"></div>
		<div class="city"></div>
		
		<div class="dust_10"></div>
		<div class="dust_25"></div>
		<div class="O3"></div>
		<div class="all"></div>
	
	
	
		<input type="hidden"  class="lati" value=""/>
		<input type="hidden"  class="longi" value=""/>
		<input type="hidden"  class="city" value=""/>
	
		<script type="text/javascript">
			$(document).ready(function(){
				$("#locationBtn").click(function(){
					let temp_lati = $('.lati').val();
					let temp_longi = $('.longi').val();
					
					opener.getWeather(temp_lati, temp_longi);
				
					window.close();
// 					$("#id",opener.document).val("value"); // jQuery 방식 1
				});
			});
			
		
			function iniMap(){
				var markers;
				
				var mapProp={center:{lat:35.153535,lng:126.887924},
						zoom:10,mapTypeId:google.maps.MapTypeId.ROADMAP		
						};
				var map=new google.maps.Map(document.getElementById('map'),mapProp);
				google.maps.event.addListener(map, 'click', function(event){
					 var clickedLocation = new google.maps.LatLng(event.latLng.lat(),event.latLng.lng());
					 
					  if(markers != null) markers.setMap(null);
					  markers=new google.maps.Marker({
						  animation: google.maps.Animation.DROP,
							position:clickedLocation,
							map:map
					  });
					  
					  $('.lati').val(event.latLng.lat());
					  $('.longi').val(event.latLng.lng());
				});
			}
		</script>
	</body>
</html>