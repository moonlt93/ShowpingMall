package com.company.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace ="com.company.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		
		return sql.selectList(namespace+".category");
	}
	
	
	@Override
	public void register(GoodsVO vo) throws Exception {
	
		 sql.insert(namespace+".register",vo);
	}
	
	
	@Override
	public List<GoodsViewVO> getList() throws Exception {
		
		return sql.selectList(namespace+".getList");
	}
	
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception{
		return sql.selectOne(namespace +".goodsView",gdsNum);
	}
	
	
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		
		sql.update(namespace + ".goodsModify",vo);
		
	}
	
	
	
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		
		sql.delete(namespace+".goodsDelete",gdsNum);
		
	}
	
	@Override
	public void delivery(OrderInfoVO order) throws Exception {
		
		sql.update(namespace+".delivery", order);
		
	}
	
	@Override
	public List<OrderInfoVO> orderList() throws Exception {
	
		return sql.selectList(namespace+".orderList");
		
	}
	
	@Override
	public List<OrderListVO> OrderView(OrderInfoVO vo) throws Exception {
		
		System.out.println("orderView:"+vo);
		return sql.selectList(namespace+".orderView",vo);
	}
	
	
	@Override
	public void changeStock(GoodsVO good) throws Exception {
	
		sql.update(namespace +".changeStock",good);
		
	}
	
	@Override
	public List<ReplyListVO> allReply() throws Exception {
	
		return sql.selectList(namespace+".allReply");
		
	}
	
	@Override
	public void deleteReply(int repNum) throws Exception {
	
		sql.delete(namespace +".deleteReply",repNum);
	}
	
	
}
