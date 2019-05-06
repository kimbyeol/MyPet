<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#login_h1{

	text-align: center;

	font-size: 2em;

	border-bottom: 1px solid #d6d5d2;

	color: #6c6a68;

}

 

.login_box{

	line-height:40px;

}

.input_login{

	height: 25px;

}

 

.log_button{

	margin-top: 20px;

}

.log_button input{

	width: 173px;

	height: 30px;

	margin-bottom: 5px;

	background-color: #6c6a68;

	border: 1px;

}


</style>
<script type="text/javascript">
function login_main(){
	var userid=$('#userid').val();
	var pwd=$('#pwd').val();
	
	$.ajax({
		url:'login',
		type:'POST',
		data:{userid:userid,pwd:pwd},
		success:function(result){
			if(result=='true'){
				location.reload();
			}else{
				alert('ID나 비밀번호가 일치하지않습니다!');
			}
		},
		error:function(req){
			alert(req.status);
		}
	});
}
</script>
</head>

<body>
	<h1 id="login_h1">LOGIN</h1>
		<div class="login_box">
			ID<br /> <input id="userid" class="input_login" type="text" required="required" placeholder="ID" maxlength="10" /><br /> Password<br />
				 <input id="pwd" class="input_login" type="password" required="required" placeholder="Password" maxlength="16" onkeypress="if(event.keyCode==13) login_main()"/><br />

			<div class="log_button">

				<input id="log" type="button" value="LOGIN" onclick="login_main()"/><br /><br/>
			</div>
		</div>
</body>
</html>