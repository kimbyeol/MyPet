<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#notice_list{
	height: 600px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="notice_list">
<h1 style="margin-top: 60px; margin-bottom: 50px;">공지사항</h1>

<table border="1" style="width: 60%; ">
<tr style="font-size: 20px; height: 40px; background-color: #e1e3e8; font-style: normal;"><th style="width:70px;">No</th><th>제목</th>
	<th style="width:15%;">작성자</th><th style="width:15%;">날짜</th>
</tr>
	
<c:forEach items="${page.list}" var="vo">
	<tr style="height: 30px;">
		<td>${vo.no}</td>
		<td class="left" style="padding: 10px;">
		<a onclick="location='detail.no?no_id=${vo.no_id}'">${vo.title }</a></td>
		<td>${vo.writer }</td>
		<td><fmt:formatDate value="${vo.writedate }" pattern="yy/MM/dd"/></td>
		
	</tr>
</c:forEach>
</table><br>

<!-- 관리자로 로그인된 경우만 글쓰기버튼이 보이게 -->
<c:if test="${login_info.admin eq 'Y' }">
<div style="width: 80%">
<a onclick="location='new.no'" class="btn-fill" style="float: right; overflow: hidden;">글쓰기</a>
</div>
</c:if>

<br/><br/>
<form method="post" action="list.no" id="list">
<input type="hidden" name="curPage"/>
<p id="list-top">
<span style="float:left;">
</span>
</p>
</form>
<div style="margin: 0 auto; overflow: hidden;"><jsp:include page="/WEB-INF/views/include/page.jsp"/></div>
</div>
</body>
</html>