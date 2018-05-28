package com.liuxc.microcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxc.microcloud.api.Dept;
import com.liuxc.microcloud.dao.IDeptMapper;
import com.liuxc.microcloud.service.IDeptService;

@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptMapper dao;

	@Override
	public boolean insert(Dept dept) {

		return dao.insert(dept);
	}

	@Override
	public Dept findById(Long id) {

		return dao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		
		return dao.findAll();
	}

}
