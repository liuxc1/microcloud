package com.liuxc.microcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.liuxc.microcloud.api.Dept;

@Mapper
public interface IDeptMapper {
	
	public boolean insert(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
