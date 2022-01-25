package com.dbal.app.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.insa.domain.DepartmentsVO;
import com.dbal.app.insa.mapper.DepartmentsMapper;
import com.dbal.app.insa.service.DepartmentsService;
@Service
public class DepartmentsServiceImpl  implements DepartmentsService{

	@Autowired DepartmentsMapper departmentsMapper;
	@Override
	public List<DepartmentsVO> getDeptList() {
		return departmentsMapper.getDeptList();
	}

}
