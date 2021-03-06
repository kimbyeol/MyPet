<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:forEach items="${list }" var="vo" varStatus="status">
${status.index==0 ? '<hr>' : '' }
<div>${vo.writer} [ <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${vo.writedate}"/> ]
<!-- 로그인한 사용자가 작성한 댓글인 경우 수정,삭제 권한을 갖는다. -->
<c:if test="${vo.writer eq login_info.nickname }">
<span style="float: right;">
	<a onclick="go_modify_save(${vo.comm_id})" id="btn-modify-save-${vo.comm_id}" class="btn-fill-small">수정</a>
	<a onclick="go_delete_cancel(${vo.comm_id})" id="btn-delete-cancel-${vo.comm_id}" class="btn-fill-small">삭제</a>
</span>
</c:if>
</div>

<div id="original-${vo.comm_id}">
${fn:replace( fn:replace(vo.content, lf, '<br>'), crlf,'<br>') }</div>
<div id="modify-${vo.comm_id}" style="display:none;"></div>
<hr>
</c:forEach>

<!-- 수정,삭제버튼
수정버튼 클릭시: 원글내용이 변경입력할 textarea에 표현되어야 하고
                          수정-> 저장, 삭제->취소 버튼이 된다.
저장,취소 버튼 클릭시: 
                          저장->수정, 취소->삭제 버튼이 된다.                            
-->
<script type="text/javascript">
function go_delete_cancel(id){
	if( $('#btn-delete-cancel-'+id).text() == '취소' )
		display_mode(id, 'd');
	else{
		//삭제처리
		if( confirm('정말 삭제??') ){
			$.ajax({
				url: 'board/comment/delete/'+id,
				success: function(){
					comment_list();
				},error :function(req){
					alert(req.status)
				}
			});
		}
	}
	
}

function go_modify_save(id){
	//저장클릭한 경우
	if( $('#btn-modify-save-'+id).text() == '저장' ){
		//변경입력한 textarea 의 내용을 DB에 저장한 후
		var comment = new Object();
		comment.comm_id = id;
		comment.content = $('#modify-editor-'+id).val();
		$.ajax({
			type: 'post',
			data: JSON.stringify(comment),
			contentType: 'application/json; charset=utf-8',
			url: 'board/comment/update',
			success: function(data){
				alert("댓글변경 "+data);
				//댓글을 조회한다.
				comment_list();
			},error: function(req){
				alert( req.status );
			}
		});
		
		
		
	//수정클릭한 경우
	}else if( $('#btn-modify-save-'+id).text() == '수정' ){
		var tag = "<textarea id='modify-editor-"+ id +"' style='margin-top:5px; width:99%; height:40px;'>" 
	+ $('#original-'+id).html().replace(/<br>/g, '\n') + "</textarea>";
		
		$('#modify-'+id).html(tag);
		display_mode(id, 'm');
	}
}
function display_mode(id, mode){
	$('#btn-modify-save-'+id).text( mode == 'm' ? '저장' : '수정');
	$('#btn-delete-cancel-'+id).text( mode=='m' ? '취소' : '삭제');
	//원래 댓글은 안보이고, 변경 댓글만 보이게
	$('#original-'+id).css('display', mode=='m' ? 'none' : 'block');
	$('#modify-'+id).css('display', mode=='m' ? 'block' : 'none');
}
</script>

