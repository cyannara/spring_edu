<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시판</h1>
    </div>
    <!-- /.col-lg-12 -->
    
	<table class="table" id="board">
	<thead>
		<tr><th>번호</th><th>제목</th><th>작성일</th></tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="board">
		<tr><td>${board.bno}</td>
			<td><a class="move" href="${board.bno}">${board.title} [${board.replycnt}]</a></td>
			<td><fmt:formatDate value="${board.regdt}" pattern="yy-MM-dd"/></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<form id="actionForm" action="list" method="get">
		<select name="type">
			<option value="" ${empty pageMaker.cri.type ? selected : "" }  >선택</option>
			<option value="T" ${pageMaker.cri.type=='T' ? selected : "" } >제목</option>
			<option value="C" ${pageMaker.cri.type=='C' ? selected : "" } >내용</option>
			<option value="W" <c:out value="${pageMaker.cri.type=='W' ? 'selected' : '' }"/> >작성자</option>
			<option value="TC"<c:out value="${pageMaker.cri.type=='TC' ? 'selected' : '' }"/> >제목 or 내용</option>
			<option value="TW"<c:out value="${pageMaker.cri.type=='TW' ? 'selected' : '' }"/> >제목 or 작성자</option>
			<option value="TWC"<c:out value="${pageMaker.cri.type=='TWC' ? 'selected' : '' }"/> >제목 or 내용 or 작성자</option>
		</select>
		<input name="keyword" value="${pageMaker.cri.keyword}">
		<input type="hidden" name="pageNum" value="1">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		<button class="btn btn-default">Search</button>
	</form>
<div id="pageButton">	
	<c:if test="${pageMaker.prev}"><a href="${pageMaker.startPage-1}">이전</a></c:if>
	<c:forEach begin="${pageMaker.startPage}" 
	           end="${pageMaker.endPage}" 
	           var="num"><a href="${num}">${num}</a></c:forEach>
	<c:if test="${pageMaker.next}"><a href="${pageMaker.endPage+1}">다음</a></c:if>
</div>	
</div>
<script>
$(function(){
	var actionForm = $("#actionForm")
	
	$(".move").on("click", function(e){
		e.preventDefault();
		var bno = $(this).attr("href")
		actionForm.append('<input type="hidden" name="bno" value="'+ bno +'">')
		actionForm.attr("action", "get")
		actionForm.submit();
	});
	
	$("#pageButton a").on("click", function(e){
		e.preventDefault();   //a, submit
		var p = $(this).attr("href")
		$('[name="pageNum"]').val(p)
		actionForm.submit();
	})
	//$("#board").DataTable();	
})
</script>

