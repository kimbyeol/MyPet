<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#board_modify{
	height: 600px;
}
</style>
</head>
<body>


<h3 style="font-size: 25px; margin-top: 60px; margin-bottom: 50px;">게시판 글 변경</h3>`
<div id="board_modify">
<form method="post" action="update.bo" enctype="multipart/form-data">
<input type="hidden" name="bo_id" value="${vo.bo_id}"/>
<table border="1" style="width: 40%;">
<tr><th style="background-color: #e1e3e8; font-size: 20px; height: 30px;">제목</th>
	<td><input value="${vo.title }" class="need" style="width: 98.5%;" type="text" name="title"/></td>
</tr>	
<tr><th style="background-color: #e1e3e8; font-size: 20px; height: 30px;">작성자</th>
	<td class="left" style="padding-left: 20px; ">${login_info.nickname }</td>
</tr>	
<tr><th style="background-color: #e1e3e8; font-size: 20px; ">내용</th>
	<td><textarea class="need" title="내용" style="width: 99%; height: 200px;" name="content"> ${vo.content }</textarea></td>
</tr>
<tr><th style="background-color: #e1e3e8; font-size: 20px; ">첨부파일</th>
	<td class="left">
	<c:if test="${ !empty vo.imagename }">
	<original>
	<a><img id="delete" style="vertical-align: middle;"
	src="img/delete.png" /></a>&nbsp;&nbsp;${vo.imagename }</original>
	</c:if>
	<input name="file" type="file" onchange="file_change( this )" /></td>
</tr>
</table><br>
<a onclick="if( necessary() ) { $('form').submit() }" class="btn-fill">저장</a>
<a onclick="history.back()" class="btn-empty">취소</a>
<input type="hidden" name="attach" /> <!-- 첨부파일삭제여부 -->
</form>
</div>

<script type="text/javascript">
function file_change(f){
	//새로운 파일을 선택하면 원래있던 파일명 안보이게
	if( $(f).val() != '' )
		$('original').html('');
	else{
		//취소를 선택하면 원래 파일명 보이게
		//삭제이미지도 보이게
		var tag = '<a><img id="delete" style="vertical-align: middle;" ' 
		    + 'src="img/delete.png" /></a>&nbsp;&nbsp;';
		$('original').html(tag + '${vo.imagename}');
	}
}
</script>
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