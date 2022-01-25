<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서관리</title>
</head>
<body>
<h3>부서관리</h3>
<div id="list">  </div>

<div class="modal" tabindex="-1" id="empModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>   </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(function(){
	deptList();
	
	//등록
	
	//수정
	
	//목록조회
	function deptList(){
		$.ajax({
			url:"deptList",
			dataType: "json",
			success : function(datas){
				$.each( datas , function(i, data){
					$("<div>").append( $("<span>").html(data.departmentId))
					          .append( $("<span>").html(data.departmentName))
					          .appendTo($("#list"));
				} )
			}
		});
	}
})
	
	
	
</script>
</body>
</html>