package com.company.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.company.domain.productVO;

@Service
public interface productService {

	public List<productVO> list() throws Exception;
	
	
	public void write(productVO vo) throws Exception;
	
	public productVO click(int showNo) throws Exception;

	public void modify(productVO vo) throws Exception;
	
	//게시글 삭제
	public void delete (int showNo) throws Exception;
	
	public int count() throws Exception;
	
	public List listPage(int displayPost,int postNum) throws Exception;
	
	
	
}