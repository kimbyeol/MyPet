<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
margin: 0 auto;
}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	window.resizeTo(600,400);
});
$(window).resize(function(){
	window.resizeTo(600,400);
});

function send(){
	var name=$('#receiver').val();
	
	
	$.ajax({
		type: "POST",
		url:'check.mem',
		data: {nickname:name},
		success:function(response){
		console.log(response);
			if(response=='succ'){
				if(confirm('메세지를 보내시겠습니까?')){
	
					$('form').submit();
				}
				
			}else{
				alert('존재하지않는 집사입니다');
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
<br/>
<form method="post" action="insert.post" >
<input type="hidden" value="${login_info.nickname }" name="sender"/>
<table style="width: 300px;">
<tr><td>보내는사람</td><td>${login_info.nickname }</td></tr>
<tr><td>받는사람</td><td><c:if test="${!empty receiver }"><input type="text" name="receiver" id="receiver" value="${receiver }"/></c:if><c:if test="${empty receiver }"><input type="text" name="receiver" id="receiver"/></c:if></td></tr>
<tr><td>제목</td><td><input type="text" name="title"/></td></tr>
<tr><td colspan="2"><textarea name="content" style="width: 250px; height: 200px;resize: none;"></textarea></td></tr>

</table>
<div style="text-align: center; margin-top: 5px" >
<input type="button" class="btn-fill" value="보내기" onclick="send()"/> <input type="button" value="취소" class="btn-fill" onclick="document.referrer? history.go(-1) :window.close()" />
</div>
</form>
</body>
</html>