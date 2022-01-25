<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<h3>사원목록</h3>
<div>
<a href="insertEmp">등록</a>
</div>
<c:forEach items="${empList}" var="emp">        
        <a href="updateEmp?employeeId=${emp.employeeId}">${emp.employeeId}</a>
        ${emp.firstName}  ${emp.lastName} 
        ${emp.email} <br>
</c:forEach>