package com.company.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.dao.shopDAO;
import com.company.domain.CartListVO;
import com.company.domain.CartVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoDetailVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
import com.company.domain.ReplyVO;

@Service
public class shopServiceImpl implements shopService {

	@Inject
	private shopDAO dao;
	
	
	@Override
	public List<GoodsViewVO> getList(int cateCode, int level) throws Exception {
		
		int cateCodeRef =0;
		
		if(level == 1) {
			cateCodeRef =cateCode;
			return dao.getList(cateCode,cateCodeRef);
			
		}else {
			
			return dao.getList(cateCode);
		}
		

	
}
	
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
	
	return dao.goodsView(gdsNum);
	
	}
	
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		
		dao.registReply(reply);
		
	}
	
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		
		return dao.replyList(gdsNum);
	}
	
	
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
	
		dao.deleteReply(reply);
	}
	@Override
	public String idCheck(int repNum) throws Exception {
		
		return dao.idCheck(repNum);
	} 
	
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
	
		dao.modifyReply(reply);
		
	}
	
	@Override
	public void addCart(CartVO cart) throws Exception {
		
		dao.addCart(cart);
		
	}
	
	@Override
	public List<CartListVO> cartList(String userId) throws Exception{
		
		return dao.cartList(userId);
	}
	//카트 삭제
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		
		dao.deleteCart(cart);
	}
	
	@Override
	public void orderInfo(OrderInfoVO vo) throws Exception {
		
		dao.orderInfo(vo);
		
	}
	@Override
	public void orderInfoDetails(OrderInfoDetailVO vo) throws Exception {
	
		dao.orderInfoDetails(vo);
		
	}
	
	//장바구니 삭제
	@Override
	public void orderInfoDelete(String userId) throws Exception {
	
		dao.deleteOrder(userId);
	}
	
	//배송상태 표현
	@Override
	public void delivery(OrderInfoVO vo) throws Exception {
		 
		 dao.delivery(vo);
	
	}
	
	@Override
	public List<OrderInfoVO> orderList(OrderInfoVO order) throws Exception {
		
		return dao.orderList(order);
	}
	@Override
	public List<OrderListVO> orderView(OrderInfoVO vo) throws Exception {
		
		return dao.orderView(vo);
		
	}
	
}
