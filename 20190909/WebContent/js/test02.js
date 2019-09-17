$(function(){
	$(".classUp + li,.classDown +li").hide();
	
	$(".classUp").mouseenter(function(){
		$(this).css("background-color","blue");
	});
	$(".classUp").mouseleave(function(){
		$(this).css("background-color","red");
	});

	
	$(".classUp").click(function(){
		$(".classUp + li").toggle();
		
	});
	
	
});