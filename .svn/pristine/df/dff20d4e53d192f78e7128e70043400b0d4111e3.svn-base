<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
ul li{
	list-style: none;
	text-align: left;
}

.text{

	text-align: center;

	font-size: .8em;

	padding: 10px;

	border-bottom: 1px solid #d6d5d2;

}

.join_box{

	width: 250px;

	line-height:35px;

	margin: 0 auto;

	margin-top: 30px;

}

.join_button{

	margin-top: 20px;

}

.join_button input{

	width: 254px;

	height: 30px;

	margin-bottom: 5px;

	background-color: #6c6a68;

	border: 1px;
	
	color: #fff;

}

input[type=button]{

	width: 254px;

	height: 30px;

	line-height:30px;

	background-color: #6c6a68;

	border: 1px;
	
	color: #fff;

}

 

input{

	width:250px;

	height: 30px;

}

 

.reverse{

	color:pink;

	cursor:pointer;

	}

.succ{

	color: green;

	font-size: .8em;

}

.fail, #id_ck{

	color:red;

	font-size: .8em;

}

</style>

<script type="text/javascript">
$('input[type="button"], input[type="reset"], input[type="submit"]').css('cursor','pointer');
</script>
<script type="text/javascript">
$(document).ready(function(){
	$('form').on('reset', function(e){
		$('#fail2').css('display','none');
		$('#succ2').css('display','none');
	});
	
});
function check_nnic(){
	var nick=$('#newnickname').val();
	$.ajax({
		url:'check.mem',
		data:{nickname:nick},
		type:'POST',
		success:function(dae){
			if(dae=='succ'){
				alert('이미 존재하는 닉네임입니다!');
				
			}else{
				alert('사용할 수있는 닉네임입니다.');
				$('#nck_nic').val('1');
			}
		},
		error:function(req){
			alert(req.status);
		}
		
	});
}
function change(){
	 if($('#nck_nic').val()!='1'){
		alert('닉네임 중복확인을 해주세요');
		return;
	}else{
		$('#new_form').submit();
		
		
	}
}

function check_newrepw(){
	if($('#newpw1').val()==$('#newpw2').val()){
		$('#fail2').css('display','none');
		$('#succ2').css('display','block');
		
	}else{
		$('#succ2').css('display','none');
		$('#fail2').css('display','block');
	}
}
function resetform(element){
	$('#fail2').css('display','none');
	$('#succ2').css('display','none');
	
}
</script>

</head>

<body>
	<br/><br/><br/>
	<h1 style="text-align: center;	font-size: 2em;	color: #5b5957;">회원정보 수정</h1>
	
	<input type="hidden" value="0" id="nck_nic"/>
	
	<div class="text">

	회원정보를 입력해주세요.<br/>

	</div>

	<form id="new_form" action="update_mem" method="post" >
	<input type="hidden" name="userid" value="${login_info.userid }">
	<div class="join_box">

		<ul>
		
		<li>닉네임</li>
		<li><input type="text" id="newnickname" required="required" 

			placeholder="닉네임를 입력해 주세요 (6~15자리)" maxlength="15" name="nickname" value="${login_info.nickname }"/></li>

		<li><input style="margin-top: 10px" id="nickname_check" type="button" value="닉네임 중복확인" onclick="check_nnic()"/></li>

		<li>비밀번호</li>

		<li><input type="password" id="newpw1" required="required" 

			placeholder="새비밀번호를 입력해 주세요 (6~20자리)" maxlength="20" name="pwd" /></li>
		<li><div class="succ" id="succ_pw" style="display: none;">*비밀번호가 일치합니다</div></li>
		<li><div class="fail" id="fail_pw" style="display: none;">*사용할수있는 비밀번호입니다.</div></li>
		<li>비밀번호 확인</li>

		<li><input type="password" id="newpw2" required="required" 

			placeholder="새비밀번호를 다시 한번 입력해 주세요" maxlength="20" onkeyup="check_newrepw()"/></li>

		<li><div class="succ" id="succ2" style="display: none;">*비밀번호가 일치합니다</div></li>

		<li><div class="fail" id="fail2" style="display: none;">*비밀번호가 일치하지 않습니다</div></li>

		

		<li>이메일</li>

		<li><input type="text" id="newemail" required="required" 

			placeholder="이메일을 입력해 주세요" name="mail" value="${login_info.mail }"/></li>

		</ul>
			<div class="join_button">

				<input type="reset" id="reset" value="RESET" /><br/>

				<input type="button" id="sub" value="수정" onclick="change()"/><br/>
				<input type="button"  value="취소" onclick="history.go(-1)"/><br/>

			</div>

		</div>

</form>
		
</body>
</html>