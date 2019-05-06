<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#notice_midify{
	height: 500px;
}
</style>
</head>
<body>


<h3 style="font-size: 25px; margin-top: 60px; margin-bottom: 50px;">공 지 사 항 변경</h3>
<div id="notice_midify">
<form method="post" action="update.no">
<input type="hidden" name="no_id" value="${vo.no_id}"/>
<table border="1" style="width: 50%;">
<tr><th style="font-size:20px; background-color: #e1e3e8;">제목</th>
	<td><input  value="${vo.title }" class="need" title="제목" style="width: 98.5%; font-size: 18px; padding-left: 10px;" type="text" name="title"/></td>
</tr>	
<tr><th style="font-size: 20px; height: 40px; background-color: #e1e3e8; ">작성자</th>
	<td class="left" style="font-size: 18px; padding-left: 10px;">${vo.writer }</td>
</tr>	
<tr><th style="font-size: 20px; height: 40px; background-color: #e1e3e8;">내용</th>
	<td style="width: 80%;"><textarea class="need" title="내용" name="content" 
	style="width: 99%; height: 200px; font-size: 18px; padding-left: 10px;">${vo.content }</textarea></td>
</tr>	

</table><br>
<a onclick="if( necessary() ) { $('form').submit() }" class="btn-fill">저장</a>
<a onclick="location='list.no'" class="btn-empty">취소</a>

</form>
</div>

<script type="text/javascript">
$(function(){
	$(document).on('click', '#delete', function(){
		$('original').html('');
		$('[name=attach]').val('n');
	});
});
</script>
<script type="text/javascript" src="js/need_check.js"></script>

</body>
</html>