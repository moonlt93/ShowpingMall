package com.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
@Repository
public interface AdminDAO {

//카테고리 
	
public List<CategoryVO> category() throws Exception;
	
//배송상태
public void delivery(OrderInfoVO order)throws Exception;

//상품 등록

public void register(GoodsVO vo) throws Exception;

//상품 리스트

public List<GoodsViewVO> getList() throws Exception;


//상품조회

public GoodsViewVO goodsView(int gdsNum) throws Exception;


//상품수정

public void goodsModify(GoodsVO vo) throws Exception;

//상품삭제

public void goodsDelete(int gdsNum) throws Exception;


//모든 목록
public List<OrderInfoVO> orderList() throws Exception;

//특정 목록
public List<OrderListVO> OrderView(OrderInfoVO vo) throws Exception;


public void changeStock(GoodsVO good) throws Exception;


public List<ReplyListVO> allReply() throws Exception;


public void deleteReply(int repNum) throws Exception;


}




