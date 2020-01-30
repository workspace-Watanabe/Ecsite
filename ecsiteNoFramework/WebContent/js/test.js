$(function() {
	$("#buyItemButton").click(function() {
		$("#form1").submit();
	});

	$("#buyItemCompleteButton").click(function(){
		$("#form2").submit();
	})

	$("#myPage").click(function(){
		$("#form3").submit();
		return false;
	});

	$("#logout").click(function(){
		$("#form4").submit();
		return false;
	});

	$("#home").click(function(){
		$("#form5").submit();
		return false;
	});
});