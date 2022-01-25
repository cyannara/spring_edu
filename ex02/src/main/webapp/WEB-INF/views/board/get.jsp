<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">게시글 상세보기/수정</h1>
	    </div>
	    
	<table>
		<tr><td>제목</td>
		    <td>${board.title}</td>
		</tr>
		
	</table>
	<form action="modify" method="post">
	<%-- 	<input type="hidden" name="pageNum" value="${cri.pageNum}">
		<input type="hidden" name="amount" value="${cri.amount}">	 --%>
		<input name="bno" value="${board.bno}"/>
		<input name="writer" value="${board.writer}"/>
		<input name="title" value="${board.title}"/>
		<input name="content" value="${board.content}"/>
		<button>수정</button>
		<button >삭제</button>
		<a class="btn btn-success" href="list?pageNum=${cri.pageNum}&amount=${cri.amount}">목록으로</a>
	</form>
	
	<!--  첨부파일  -->
	<div>
		<c:forEach items="${board.attachList}" var="attach"> 
			<a href="download?uuid=${attach.uuid}">${attach.fileName}</a>
		</c:forEach>
	</div>
	
</div>


<!-- 댓글 목록 -->
<div class="panel panel-default">
	<div class="panel-heading">댓글</div>
	<div class="paenl-body">
		<!--  댓글등록 -->
		<div>
		<form id="replyForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<input name="replyer" value="user10">
			<input name="reply">
			<button type="button" id="saveReply">댓글등록</button>
		</form><br>
		</div>
		<!-- 댓글목록 -->
		<ul class="chat"></ul>
	</div>
   	<div class="panel-footer"></div>
</div>
<script>
	let bno = "${board.bno}";
	
	$(function(){
		//등록처리
		$("#saveReply").on("click", function(){
			$.ajax({
				url: "../reply/",
				method : "post",
				data:  $("#replyForm").serialize(),
				dataType : "json" ,
				success : function(data){
					$(".chat").append ( makeLi(data)  );
				}
			});
		});
		
		function makeLi(data){
			return '<li class="left clearfix">'
			+ '	<div>'
			+ '	 <div class="header">'
			+ '	 <strong class="primary-font">'+ data.replyer +'</strong>'
			+ '	  <small class="pull-right text-muted">'+data.replydate+'</small>'
			+ '	 </div>'
			+ '	 <p>'+ data.reply +'</p>'
			+ '  <button type="button" class="btnreplyUpdate">수정</bytton>'
			+ '  <button type="button" class="btnreplyDelete">삭제</bytton>'
			+ '	</div>'
			+ ' </li>';
		}
		
		//목록조회
		$.ajax({
			url : "../reply/",    //method(or type):"get"
			data : {bno:bno}  ,   //"bno=377"
			dataType : "json" ,   //응답결과가 json
			success : function(datas){
				str = "";
				for(i=0; i<datas.length; i++){
					str += makeLi(datas[i]);
				}
				$(".chat").html(str);
			}
		});
		
		//삭제
		
		
		//수정
		
		
		
	})

</script>

