<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="#" data-code="c">등록</a>
<a href="#" data-code="u">수정</a>
<a href="#" data-code="d">삭제</a>
업체검색
<a href="#" data-code="lg">LG</a>
<a href="#" data-code="sm">삼성</a>
<script>
	$("a").on("click", function(){
		var co = $(this).data("code");
		selectCo(co);
	})
</script>
</body>
</html>