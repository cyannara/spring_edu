<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href="updateEmp/${emp.employeeId}">수정</a>
<a href="deleteEmp/${emp.employeeId}">삭제</a>
    <div class="row">
        <div class="col">${emp.employeeId}</div>
        <div class="col">${emp.firstName} ${emp.lastName}</div>
        <div class="col">${emp.email}</div>
        <div class="col">${emp.hireDate}</div>
    </div>
