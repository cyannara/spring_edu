package com.dbal.app.insa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
    
    String employeeId;    
	String firstName;
	String lastName;
	String email;
	String managerId;

	
	//@JsonFormat(pattern = "yyyy-MM-dd HH")
	String hireDate;   //LocalDateTime  , Date
	String jobId;
	String departmentId;
	Integer salary;

}
