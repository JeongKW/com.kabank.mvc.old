/**
 * 
 */

window.onload = function() {
	var arr = ['burgerking', 'kakao', 'bitcamp', 'sktelecom', 'lotto'];
	for(var i = 0; i < arr.length; i++){
		document.querySelector('#'+arr[i]).addEventListener('click', function(e){ location.href="../" + this.id + "/main.jsp"}, false);
	}
}