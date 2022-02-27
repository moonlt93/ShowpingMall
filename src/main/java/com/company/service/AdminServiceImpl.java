package com.company.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.dao.AdminDAO;
import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;
	
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		
		return dao.category();
	}

	
		@Override
		public void register(GoodsVO vo) throws Exception {
			
			 dao.register(vo);
			
		}
		
		@Override
		public List<GoodsViewVO> getList() throws Exception {
		
			System.out.println("리스트 조회");
			return dao.getList();
		}
		
		
		//상품 view
		@Override
		public GoodsViewVO goodsView(int gdsNum) throws Exception {
		
			return dao.goodsView(gdsNum);
		
		}
		
		
		@Override
		public void goodsModify(GoodsVO vo) throws Exception {
				
				dao.goodsModify(vo);
		}
	
	
		@Override
		public void goodsDelete(int gdsNum) throws Exception {
		
			dao.goodsDelete(gdsNum);
			
		}
		
		@Override
		public void delivery(OrderInfoVO vo) throws Exception {
				
			dao.delivery(vo);
		}
		
		@Override
		public List<OrderInfoVO> OrderList() throws Exception {
			
			return dao.orderList();
		}
		@Override
		public List<OrderListVO> OrderView(OrderInfoVO vo) throws Exception {
			
			
			System.out.println("서비스들어감:"+vo);
			return dao.OrderView(vo);
		}
		
		
		
		@Override
		public void changeStock(GoodsVO vo) throws Exception {
		
			 dao.changeStock(vo);
		}
		
		
		@Override
		public List<ReplyListVO> allReply() throws Exception {
		
			return dao.allReply();
			
		}
		
		@Override
		public void deleteReply(int repNum) throws Exception {
		
			dao.deleteReply(repNum);
			
		}
		
		
}
