package com.company.service;

import java.util.List;

import com.company.domain.CartListVO;
import com.company.domain.CartVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoDetailVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
import com.company.domain.ReplyVO;

public interface shopService {
	
	public List<GoodsViewVO> getList(int cateCode, int level) throws Exception;


	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	
	public void registReply(ReplyVO reply) throws Exception;
	
	
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;

	
	public void deleteReply(ReplyVO reply) throws Exception;
	
	public String idCheck(int repNum) throws Exception;

	// 상품 수정 
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//카트 담기
	public void addCart(CartVO cart) throws Exception;
	
	//카트 리스트
	public List<CartListVO> cartList(String userId) throws Exception;

	public void deleteCart(CartVO cart) throws Exception;
	
	
	public void orderInfo(OrderInfoVO vo) throws Exception;
	
	public void orderInfoDetails(OrderInfoDetailVO vo) throws Exception;
	
	public void orderInfoDelete(String userId) throws Exception;
	
	//주문 목록
	public List<OrderInfoVO> orderList(OrderInfoVO order) throws Exception;
	
	//특정 주문목록 
	public List<OrderListVO> orderView(OrderInfoVO vo) throws Exception;
	
	public void delivery(OrderInfoVO vo) throws Exception;
	
}
