package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Book;

@Mapper
public interface AdminMapper {

	void save(Book book);

	List<Book> findAll();

}
