<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp" %>

<body>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="../main/index.do" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="../assets/images/logos/dark-logo.svg" width="180" alt="">
                </a>
                <p class="text-center">Your Social Campaigns</p>
 <script>
 function formValidate(f){
  if(f.id.value==""){
	  alert("id를 다시 확인해주세요");
	  f.id.focus();
	  return false;
  }
  if(f.pass.value!=f.re_pass.value){
	  alert("비밀번호를 다시 확인해주세요");
	  f.pass.value="";
	  f.re_pass.value="";
	  f.pass.focus();
	  return false;
  }
 }
 </script> 
 <input type="hidden" id ="msg" value="${msg}">
 <input type="hidden" id ="wNum" value="${wNum}">
	
	<script>
	var wNum = $('#wNum').val();
	var msg = $('#msg').val();
	if(wNum =="Y"){
		if(confirm(msg)){
			
			location.href="../board/deleteAll.do?id=${dto.id}";
		
		}else{
			alert("아무일도일어나지 않습니다..");
		}
	}
	</script>
        <% session.removeAttribute("msg");  %>      
<form name="registForm" method="post" action="joinMod.do" onsubmit="return formValidate(this);" >
<input type="hidden" id = "mode" name="mode" value="U">
                  <div class="mb-3">
<label for="exampleInputtext1" class="form-label">아이디</label>
<input type="text" class="form-control" id="exampleInputtext1" 
 	aria-describedby="textHelp" name="id" value= "${dto.id}" readonly= "readonly">
                  </div>
                  <div class="mb-3">
<label for="exampleInputEmail1" class="form-label">비밀번호</label>
<input type="password" class="form-control" id="exampleInputEmail1" 
aria-describedby="emailHelp" name="pass" value= "${dto.pass}">
                  </div>
                  <div class="mb-4">
<label for="exampleInputPassword1" class="form-label">비밀번호확인</label>
<input type="password" class="form-control" id="exampleInputPassword1" name="re_pass" value= "${dto.pass}">
                  </div>
                   <div class="mb-4">
<label for="exampleInputPassword1" class="form-label">이름</label>
<input type="text" class="form-control" id="exampleInputPassword1" name="name" value= "${dto.name}">
                  </div>
                   <div class="mb-4">
<label for="exampleInputPassword1" class="form-label">이메일</label>
<input type="text" class="form-control" id="exampleInputPassword1" name="email" value= "${dto.email}">
                  </div>
                   <div class="mb-4">
<label for="exampleInputPassword1" class="form-label">전화번호</label>
<input type="text" class="form-control" id="exampleInputPassword1" name="phone" value= "${dto.phone}">
                  </div>
 <input type="submit" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2"
 value="회원정보 수정" />
                  <div class="d-flex align-items-center justify-content-center">
                   <button type = "submit" onclick="changeMode('D')" >회원탈퇴</button>
                  </div>
</form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="../assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="../assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>