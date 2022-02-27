package com.company.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.domain.CartListVO;
import com.company.domain.CartVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoDetailVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
import com.company.domain.ReplyVO;

@Repository
public class shopDAOImpl implements shopDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace ="com.company.mappers.shopMapper";
	
	
	@Override
	public List<GoodsViewVO> getList(int cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 
		 map.put("cateCode", cateCode);
		 map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace+".getList",map);
		
	}
	
	
	
	@Override
	public List<GoodsViewVO> getList(int cateCode) throws Exception {
	
	return sql.selectList(namespace+".getList2",cateCode);
	}
	
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		
		return sql.selectOne("com.company.mappers.adminMapper"
							 +".goodsView",gdsNum);
	}
	
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		
		 sql.insert(namespace+".registReply",reply);
		
	}
	
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
			
		return sql.selectList(namespace + ".replyList",gdsNum);
	}
	
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		
		sql.delete(namespace+".deleteReply",reply);
		
	}
	@Override
	public String idCheck(int repNum) throws Exception {
		
		return sql.selectOne(namespace+".replyUserIdCheck",repNum);
	}
	@Override
	public void modifyReply(ReplyVO reply) throws Exception{
	  sql.update(namespace+".modifyReply",reply);
	}
	
	@Override
	public void addCart(CartVO cart) throws Exception {
	
		sql.insert(namespace + ".addCart",cart);
	}
	
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		
		return sql.selectList(namespace + ".cartList", userId);
	}
	
	@Override
	public void deleteCart(CartVO cart) throws Exception{
		sql.delete(namespace + ".deleteCart",cart);
	}
	
	@Override
	public void orderInfo(OrderInfoVO orderInfo) throws Exception {
		
		sql.insert(namespace + ".addOrderInfo",orderInfo);
		
	}
	
	 @Override
	public void orderInfoDetails(OrderInfoDetailVO orderDetail) throws Exception {
	
		 
		 sql.insert(namespace + ".addOrderDetail",orderDetail);
	}
	 
	 @Override
	public void deleteOrder(String userId) throws Exception {
	
		 sql.delete(namespace + ".cartAllDelete",userId);
	}
	
	 
	 @Override
	public List<OrderInfoVO> orderList(OrderInfoVO order) throws Exception {
	
	 return sql.selectList(namespace + ".orderList",order);
	 
	 }
	 
	 @Override
	public List<OrderListVO> orderView(OrderInfoVO order) throws Exception {
		
		return sql.selectList(namespace+".orderView", order);
	}
	 
	
	 @Override
	public void delivery(OrderInfoVO order) throws Exception {
		 sql.update(namespace + ".delivery" , order);
		 
	}
}
