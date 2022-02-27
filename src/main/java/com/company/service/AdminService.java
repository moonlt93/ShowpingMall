package com.company.service;

import java.util.List;

import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	//상품등록
	public void register(GoodsVO vo)throws Exception;
	
	
	//리스트 조회
	public List<GoodsViewVO> getList() throws Exception;
	
	//상품조회
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품수정
	
	public void goodsModify(GoodsVO vo) throws Exception;
	
	
	//상품삭제
	
	public void goodsDelete(int gdsNum) throws Exception;
	
	
	public void delivery(OrderInfoVO vo) throws Exception;
	
	
	
	//리스트 조회
	public List<OrderInfoVO> OrderList() throws Exception;
	
	//특정리스트 조회
	public List<OrderListVO> OrderView(OrderInfoVO vo) throws Exception;

	
	public void changeStock(GoodsVO vo)throws Exception;
	
	//모든 댓글 조회
	public List<ReplyListVO> allReply() throws Exception;
	
	//댓글 삭제
	public void deleteReply(int repNum) throws Exception;
	
}
