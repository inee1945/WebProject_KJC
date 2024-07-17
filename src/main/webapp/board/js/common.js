

function validateForm_login(form){
		if(!form.user_id.value){
			alert("아이디를 입력하세요..");
			form.user_id.focus();
			return false;
		}
		if(!form.user_pwd.value){
			alert("패스워드를 입력하세요")
			form.user_pwd.focus();
			return false;
		}
	}

	
	function validateForm_join(form){
		if(!form.user_id.value){
			alert("아이디를 입력하세요..");
			form.user_id.focus();
			return false;
		}
		if(!form.user_pwd.value){
			alert("패스워드를 입력하세요");
			form.user_pwd.focus();
			return false;
		}
		if(!form.user_name.value){
			alert("이름 입력하세요");
			form.user_name.focus();
			return false;
		}
	}
