/**
 * 
 */
function init(){
	document.querySelector("#member_mgmt_link").addEventListener("click", adminManagement, false);
}

function adminManagement(){
	location.href="member_list.jsp";
}

window.addEventListener("load", init, false);