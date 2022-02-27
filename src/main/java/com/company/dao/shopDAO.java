package com.company.dao;

import java.util.List;

import com.company.domain.CartListVO;
import com.company.domain.CartVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoDetailVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
import com.company.domain.ReplyVO;

public interface shopDAO {
	
	
	//리스트
	public List<GoodsViewVO> getList(int cateCode, int cateCodeRef) throws Exception;
	
	
	//2차 리스트
	public List<GoodsViewVO> getList(int cateCode) throws Exception;
	
	//조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	
	//댓글 작성
	public void registReply(ReplyVO reply) throws Exception;

	
	//댓글 list
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	//reply 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	//상품 수정
	public void modifyReply(ReplyVO reply) throws Exception;

	//장바구니
	public void addCart(CartVO cart) throws Exception;

	//장바구니 가져오기
	public List<CartListVO> cartList(String userId)throws Exception;
	

	//카트 삭제
	public void deleteCart(CartVO cart) throws Exception;
	
	//오더 등록 
	public void orderInfo(OrderInfoVO orderInfo) throws Exception;
	//디테일 삽입
	public void orderInfoDetails(OrderInfoDetailVO orderDetail) throws Exception;
	
	//주문 삭제
	public void deleteOrder(String userId) throws Exception;
	
	//주문목록
	public List<OrderInfoVO> orderList(OrderInfoVO order) throws Exception;
	
	
	//특정주문 목록
	public List<OrderListVO> orderView(OrderInfoVO order) throws Exception;

	//배송상태
	public void delivery(OrderInfoVO order) throws Exception;
	

	
}
