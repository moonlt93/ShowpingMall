package com.company.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.dao.productDAO;
import com.company.domain.productVO;

@Service
public class productServiceImpl implements productService {
	
	@Inject
	private productDAO dao;
	
	
	
	@Override
	public List<productVO> list() throws Exception {
		
		  return dao.list();
	}
	
	
	//게시물 작성
	@Override
	public void write(productVO vo) throws Exception {
		
		dao.write(vo);
		
	}
	
	@Override
	public productVO click(int showNo) throws Exception {
	
		
		
		return dao.click(showNo);
	}
	
	@Override
	public void modify(productVO vo) throws Exception {
	
		dao.modify(vo);
	}
	
	@Override
	public void delete(int showNo) throws Exception {
		
		dao.delete(showNo);
		
	}

	
	@Override
	public int count() throws Exception {
	
		return dao.count();
	}
	
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		
		return dao.listPage(displayPost, postNum);
	}
	
		
}
