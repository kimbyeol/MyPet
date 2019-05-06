(function(){
	var current = 0;
	var max = 0;
	var container;
	var interval;
	var xml;
	var interval;
	function init(){
		container = jQuery(".slide ul");
		max = container.children().length;
		events();
		
		interval = setInterval(next, 1500);
		
	}
	function events() {
		jQuery("button.prev").on("click", prev);
		jQuery("button.next").on("click", next);
		
		jQuery(window).on("keydown", keydown);
	}
	
	function prev( e ) {
		current--;
		if(current < 0) current = max-1;
		animate();
	}
	function next( e ) {
		current++;
		if(current> max-1)current = 0;
		animate();
	}
	function animate($direction) {
	var moveX = current * 1500; /* 이미지 가로사이즈*/
		TweenMax.to(container, 0.7,{marginLeft:-moveX, ease: Expo.easeOut});
	
		clearInterval(interval);
		interval = setInterval(next,6000);
		if($direction =="next"){
			
		} else if ($direction =="prev"){
			
		}
	}
	function keydown( e ) {
		if( e.which == 39 /*오른쪽 방향키*/){
			next();
		}else if(e.which == 37 /*왼쪽 방향키*/){
			prev();
		}
			
	}
	jQuery(document).ready(init);
})();