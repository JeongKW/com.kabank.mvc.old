
function init(){
	var arr = ['burgerking', 'kakao', 'bitcamp', 'sktelecom', 'lotto'];
	document.querySelector('#attend_result').addEventListener('click', bitResult, false);
	for(var i = 0; i < arr.length; i++){
		document.querySelector('#'+arr[i]).addEventListener('click',
				function(e){ location.href="../" + this.id + "/main.jsp"}, false);
	}
}
function bitResult(){
	document.querySelector('#bit_main_form').submit();
}

window.addEventListener("load", init, false);