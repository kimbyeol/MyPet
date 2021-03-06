<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table{
width: 60%;
margin: 0 auto;
top: :10%;
border: 1px solid #ccced1;
border-collapse: collapse;
}
 th, td {
    border-bottom: 1px solid #ccced1;
    padding: 7px;
  }
  td{
  border-right: 1px solid #ccced1;
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	window.resizeTo(600,400);
});
$(window).resize(function(){
	window.resizeTo(600,400);
});
</script>
</head>
<body>
<br/>
<table>
<c:if test="${flag eq '1'}">
<tr><td width="30%">보내는사람</td><td>${dto.sender }</td></tr></c:if>
<c:if test="${flag eq '0' }">
<tr><td width="30%">받는사람</td><td>${dto.receiver }</td></tr></c:if>
<tr><td width="30%">제목</td><td>${dto.title }</td></tr>
<tr><td colspan="2" style="width: 150px; height: 170px; text-align:left;">${fn:replace(dto.content,crlf,'<br/>') }</td></tr>
</table><br/>
<div style="margin: 0 auto; text-align: center;">
<c:if test="${flag eq '1'}">
<input type="button"  class="btn-fill" value="답장" width="10%" onclick="location='postinsert?receiver=${dto.receiver }'" /> </c:if><input type="button" class="btn-fill" value="삭제" onclick="if(confirm('정말삭제하시겠습니까?'))location='delete.post?po_id=${dto.po_id}&flag=${flag }&nickname=${login_info.nickname }'"/> <input type="button" class="btn-fill" value="취소" onclick="history.go(-1)"/>
</div>
</body>
</html>