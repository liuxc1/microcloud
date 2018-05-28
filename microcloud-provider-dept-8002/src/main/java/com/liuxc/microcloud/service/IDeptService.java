package com.liuxc.microcloud.service;

import java.util.List;

import com.liuxc.microcloud.api.Dept;

public interface IDeptService {
	public boolean insert(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
