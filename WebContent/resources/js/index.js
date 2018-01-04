/**
 * 
 */
function init(){
	var goAdminLink = document.querySelector('#go_admin_link');
	var goJoinLink = document.querySelector('#go_join_link');
	var indexLoginBtn = document.querySelector('#index_login_btn');
	goAdminLink.addEventListener("click", goAdmin, false);
	goJoinLink.addEventListener("click", goJoin, false);
	indexLoginBtn.addEventListener("click", indexLogin, false);
}

function goAdmin(){
	if(confirm('관리자?')){
		location.href = "../admin/main.jsp";
	} else {
		alert('관리자만 접근가능 합니다');
	}
}

function goJoin(){
	location.href = "../user/join.jsp";
}

function indexLogin(e){
	var loginId = document.querySelector('#index_input_id').value;
	var loginPw = document.querySelector('#index_input_pw').value;
	var joinId = sessionStorage.getItem('id');
	var joinPw = sessionStorage.getItem('pw');
	if(!(loginId === joinId) || !(loginPw === joinPw)){
		
		alert('입력하신 ' + loginId + '나 ' + loginPw + ' 는 틀립니다');
	}
}

window.addEventListener("load", init, false);