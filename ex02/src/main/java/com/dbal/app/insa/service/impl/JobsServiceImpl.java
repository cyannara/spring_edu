package com.dbal.app.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.insa.domain.JobsVO;
import com.dbal.app.insa.mapper.JobsMapper;
import com.dbal.app.insa.service.JobsService;
@Service
public class JobsServiceImpl  implements JobsService{
	@Autowired JobsMapper jobsMapper;
	@Override
	public List<JobsVO> getJobList() {
		return jobsMapper.getJobList();
	}

}
