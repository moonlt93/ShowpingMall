package com.company.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.domain.CartListVO;
import com.company.domain.CartVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.MemberVO;
import com.company.domain.OrderInfoDetailVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
import com.company.domain.ReplyVO;
import com.company.service.shopService;


@Controller
@RequestMapping("/shop/*")
public class shopController {

 private static final Logger logger = LoggerFactory.getLogger(shopController.class);
 
 @Inject
 shopService service;
    
 // 카테고리별 상품 리스트
 @RequestMapping(value = "/list", method = RequestMethod.GET)
 public void getList(@RequestParam("c") int cateCode,
		 			  @RequestParam("L") int level, Model model) throws Exception {
	 logger.info("get llist");
  
	  List<GoodsViewVO> list = null;
	  list = service.getList(cateCode, level);
 
  model.addAttribute("list", list);
  
 }
 
 @RequestMapping(value="/view", method=RequestMethod.GET)
 public void getView(@RequestParam("n") int gdsNum,Model model) throws Exception{
	 logger.info("get view");
	 
	 
	 GoodsViewVO view =service.goodsView(gdsNum);
	 model.addAttribute("view",view);
		/*
		 * List<ReplyListVO> reply = service.replyList(gdsNum);
		 * model.addAttribute("reply",reply);
		 */
 }
 
	/*
	 * //상품 VIEW 및 댓글 작성
	 * 
	 * @RequestMapping(value="/view", method=RequestMethod.POST) 
	 * public String
	 * getView(ReplyVO reply,HttpSession session) throws Exception{
	 * logger.info("get view");
	 * 
	 * 
	 * MemberVO member=(MemberVO)session.getAttribute("member");
	 * 
	 * reply.setUserId(member.getUserId());
	 * 
	 * service.registReply(reply);
	 * 
	 * return "redirect:/shop/view?n?"+ reply.getGdsNum(); //내가 댓글쓰던데로 와야지 }
	 */
 
 //상품조회
 @ResponseBody
 @RequestMapping(value="/view/replyList",method = RequestMethod.GET)
 public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum)throws Exception{
	
	 logger.info("get reply list");
	 
	 List<ReplyListVO> reply = service.replyList(gdsNum);
	 
	 
	 return reply;
	 
 }
	
	//상품 소감(댓글) 작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply,  HttpSession session) throws Exception {
			logger.info("regist reply");
	
			MemberVO member = (MemberVO)session.getAttribute("member");
			reply.setUserId(member.getUserId());
	
			service.registReply(reply);
	} 
	 
 
	// 상품 소감(댓글) 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply,HttpSession session) throws Exception {
	 logger.info("post delete reply");

	 int result = 0;
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 String userId = service.idCheck(reply.getRepNum());
	   
	 if(member.getUserId().equals(userId) || "ADMIN".equals(member.getUserName())) {
	  
	  reply.setUserId(member.getUserId());
	  service.deleteReply(reply);
	  
	  result = 1;
	 }
	 
	 return result; 
	}
 
 
	// 상품 소감(댓글) 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
	 logger.info("modify reply");
	 
	 int result = 0;
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 String userId = service.idCheck(reply.getRepNum());
	 
	 if(member.getUserId().equals(userId)) {
	  
	  reply.setUserId(member.getUserId());
	  service.modifyReply(reply);
	  result = 1;
	 }
	 
	 return result;
	} 

	//카트 담기
	@ResponseBody
	@RequestMapping(value="/view/addCart",method = RequestMethod.POST)
	public int addCart(CartVO cart,HttpSession session ) throws Exception{
		
		int result= 0 ;
		
		MemberVO member =(MemberVO)session.getAttribute("member");
		
		if(member != null) {
			
			cart.setUserId(member.getUserId());
			service.addCart(cart);
			result = 1;			
		}
		
		return result;
	}
	
	
	
	@RequestMapping(value="/cartList",method =RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception{
		
		logger.info("get cart list");
		
		MemberVO member =(MemberVO)session.getAttribute("member");
		String userId = member.getUserId();
		
		List<CartListVO> cartList = service.cartList(userId);
		
		model.addAttribute("cartList",cartList);
		
	}
	//삭제시
	@ResponseBody
	@RequestMapping(value="/deleteCart" , method=RequestMethod.POST)
	public int deleteCart(HttpSession session,
						   @RequestParam(value="chbox[]") List<String> chArr, CartVO cart) throws Exception{
		
	logger.info("delete cart");
	
	MemberVO member = (MemberVO)session.getAttribute("member");
	String userId = member.getUserId();
	
	int result = 0;
	int cartNum =0;
	
	if(member != null) {
		cart.setUserId(userId);
	
		for(String i :chArr) {
			cartNum = Integer.parseInt(i);
			cart.setCartNum(cartNum);
			service.deleteCart(cart);
		}
			result =1;
		
	}
		return result;
	}
	
	
	
	
	// 주문
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderInfoVO order, OrderInfoDetailVO orderDetail,Model model) throws Exception {
	 logger.info("order");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");  
	 String userId = member.getUserId();
	 System.out.println("userId"+userId);
	 
	 
	 Calendar cal = Calendar.getInstance();
	 int year = cal.get(Calendar.YEAR);
	 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	 String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
	 String subNum = "";
	 
	 for(int i = 1; i <= 6; i ++) {
	  subNum += (int)(Math.random() * 10);
	 }
	 
	 String orderId = ymd + "_" + subNum;
	 
	 order.setOrderId(orderId);
	 order.setUserId(userId);
	 
	 System.out.println("뭐가 들어가있나?: "+order);
	  
	 service.orderInfo(order);
	
	 orderDetail.setOrderId(orderId);   
	
	 service.orderInfoDetails(orderDetail);
	 
	 service.orderInfoDelete(userId);
	 
	 return "redirect:/shop/orderList";  
	}
	
	
	// 주문 목록
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, OrderInfoVO order, Model model) throws Exception {
	 logger.info("get order list");
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 String userId = member.getUserId();
	 
	 order.setUserId(userId);
	 
	 List<OrderInfoVO> orderList = service.orderList(order);
	 
	 model.addAttribute("orderList", orderList);
	}
	
	
	// 주문 상세 목록
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(HttpSession session,
	      @RequestParam("n") String orderId,
	      OrderInfoVO order, Model model) throws Exception {
	 logger.info("get order view");
	 
	 System.out.println("뷰 띄웠나?"+model);
	 
	 MemberVO member = (MemberVO)session.getAttribute("member");
	 String userId = member.getUserId();
	 
	 order.setUserId(userId);
	 order.setOrderId(orderId);
	 
	 List<OrderListVO> orderView = service.orderView(order);
	 
	 model.addAttribute("orderView", orderView);
	}
	
	
}