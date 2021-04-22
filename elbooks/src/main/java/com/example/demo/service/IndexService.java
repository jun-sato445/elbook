package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Index;
import com.example.demo.mapper.index.IndexMapper;

@Service
public class IndexService {

	@Autowired
	IndexMapper Index;

	public List<Index> findAll(){		
		return Index.findAll();
	}
}
