<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.member_table{
	width: 60%;
	line-height: 35px;
	margin-top: 50px;
}
.ic_delete{
	display: inline;
}
.ic_delete:hover{
	cursor: pointer;
}

</style>
<script type="text/javascript">
function delete_mem(data){
	var admin_ch="${login_info.admin}";
	var user=data;
	if(confirm('탈퇴시키겠습니까?')){
		if(admin_ch=='Y'){
			$.ajax({
				url:'delete_mem',
				data:{userid:user},
				type:'GET',
				success:function(data){
					if(data=='succ'){
						alert('회원탈퇴에 실패하였습니다');
					}else{
						alert('회원이 탈퇴처리되었습니다');
						location.reload();
					}
				},
				error:function(req){
					alert(req.status);
				}
			});
		}else{
			alert('관리자가아닙니다.');
		}
	}else{
		return false;
	}
}
</script>
</head>
<body>
<h1>관리자 페이지</h1>
<table border="1" class="member_table">
<tr style="background-color: orange;">
	<td>아이디</td>
	<td>닉네임</td>
	<td>이메일</td>
	<td>삭제</td>
</tr>
<c:forEach items="${admin}" var="admin">
<tr>
<td>${admin.userid}</td>
<td>${admin.nickname}</td>
<td>${admin.mail}</td>
<td><img class="ic_delete" src="img/delete.png" onclick="return delete_mem('${admin.userid}')"/></td>
</tr>
</c:forEach>
</table>
<br/><br/><br/>
</body>
</html>