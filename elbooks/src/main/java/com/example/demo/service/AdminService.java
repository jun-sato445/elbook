package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.AdminMapper;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper adminMapper;

	public void save(Book book) {
		adminMapper.save(book);

	}

	public List<Book> findAll() {
		
		return adminMapper.findAll();
	}

}
