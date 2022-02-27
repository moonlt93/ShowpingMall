package com.company.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.domain.productVO;


@Repository
public class productDAOImpl implements productDAO {

	@Inject
	private SqlSession sql;
	
	@Inject
	private static String namespace = "com.company.mappers.product";
	
	
	//게시물 목록
	@Override
	public List<productVO> list() throws Exception {
		
		
		
		return sql.selectList(namespace+".list");
	}

	
	//게시물 작성
	@Override
	public void write(productVO vo) throws Exception {
		
		 sql.insert(namespace+".write",vo);
		
	}
	
	
	
	//게시물 조회
	@Override
	public productVO click(int showNo) throws Exception {
		
		return sql.selectOne(namespace +".click",showNo);
	}
	
	
	@Override
	public void modify(productVO vo) throws Exception {
	
		
		sql.update(namespace + ".modify",vo);
	}
	
	@Override
	public void delete(int showNo) throws Exception {
		
		sql.delete(namespace +".delete",showNo);
		
	}
	
	@Override
	public int count() throws Exception {
		
		return sql.selectOne(namespace+".count");
	}
	
	
	// 게시물 목록 + 페이징
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {

	 HashMap data = new HashMap();
	  
	 data.put("displayPost", displayPost);
	 data.put("postNum", postNum);
	  
	 return sql.selectList(namespace + ".listPage", data);
	}
	
	
	
}
