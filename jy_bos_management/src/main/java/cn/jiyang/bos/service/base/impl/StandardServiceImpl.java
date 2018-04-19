package cn.jiyang.bos.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jiyang.bos.dao.base.StandardRepository;
import cn.jiyang.bos.domain.base.Standard;
import cn.jiyang.bos.service.base.StandardService;

@Service
@Transactional
public class StandardServiceImpl implements StandardService{
	
	@Autowired
	public StandardRepository standardRepository;
	
	@Override
	public void save(Standard standard) {
		// TODO Auto-generated method stub
		standardRepository.save(standard);
	}

	@Override
	public Page<Standard> pageQuery(Pageable pageable) {
		
		return standardRepository.findAll(pageable);
	}

}
