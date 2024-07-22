function loginChk(SessionId){
		if(!SessionId){
			alert("게시판은 회원 로그인 후 이용가능합니다.");
			return false;
		}
	}
	
function changeMode(mode){
	$("#mode").val(mode);
}	

function fnAlert(msg){
	if(msg!=null&&msg!=""){
		alert(msg);
	}
}

