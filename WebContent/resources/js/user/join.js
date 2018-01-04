/**
 * 
 */
function init(){
	document.getElementById('datepicker').valueAsDate = new Date();
	document.querySelector('#check_dupl_btn').addEventListener("click", checkDuplicate, false);
	document.querySelector('#join_confirm_btn').addEventListener("click", joinConfirm, false);
}

function checkDuplicate(e){
	alert('중복체크 클릭');
	e.preventDefault();
}

function joinConfirm(){
	document.querySelector('#member_form').submit();
}

window.addEventListener("load", init, false);
