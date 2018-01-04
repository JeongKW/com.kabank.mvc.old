/**
 * 
 */
function init(){
	document.querySelector('#member_register_btn').addEventListener("click", memberRegister, false);
}

function memberRegister(){
	document.querySelector('#member_register_form').submit();
}

window.addEventLister("load", init, false);