package com.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.domain.productVO;

@Repository
public interface productDAO {
	
	public List<productVO> list() throws Exception;
	
	public void write(productVO vo) throws Exception;
	
	public productVO click(int showNo) throws Exception;
	
	public void modify(productVO vo) throws Exception;
	
	public void delete(int showNo) throws Exception;
	

	public int count() throws Exception;
	
	// 게시물 목록 + 페이징
	public List listPage(int displayPost, int postNum) throws Exception;
	
}
