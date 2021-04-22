package com.example.demo.mapper.index;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Index;

@Repository
@Mapper
public interface IndexMapper {
	List<Index>findAll();
}
