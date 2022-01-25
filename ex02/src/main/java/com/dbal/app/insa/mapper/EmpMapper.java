package com.dbal.app.insa.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dbal.app.insa.domain.EmpVO;

public interface EmpMapper {

	List<Map> findTemp(@Param("seq") Integer seq);
	
	List<Map<String,Object>> findEmployeesMap();		//사원검색
	
	public EmpVO getEmp(EmpVO empVO);
	public List<EmpVO> getEmpList(EmpVO empVO);
	public void empInsert(EmpVO empVO);
	public void insertEmpProc(EmpVO empVO);
	public String getName(Integer id);
	public List<Map<String, Object>> getEmpMap();
	public List<Map<String, Object>> getDeptEmpCnt();
}

