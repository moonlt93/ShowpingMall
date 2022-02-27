package com.company.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.domain.CategoryVO;
import com.company.domain.GoodsVO;
import com.company.domain.GoodsViewVO;
import com.company.domain.MemberVO;
import com.company.domain.OrderInfoVO;
import com.company.domain.OrderListVO;
import com.company.domain.ReplyListVO;
import com.company.domain.ReplyVO;
import com.company.service.AdminService;

import com.company.util.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public void getIndex() throws Exception{
		logger.info("get index");
		
		
	}
	
	//상품등록
	@RequestMapping(value="/goods/register",method=RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category=service.category();
		model.addAttribute("category",JSONArray.fromObject(category));
		
	}
	//등록 POST
	@RequestMapping(value="/goods/register",method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo , MultipartFile file) throws Exception{
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		
			fileName =UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			
			//gdsImg에 원본 파일 경로+ 파일명 저장
			vo.setGdsImg(File.separator +"imgUpload" +ymdPath +File.separator + fileName );
			//gdsImg에 썸네일 파일 경로, 썸네일 파일 저장
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath+ File.separator +"s"+File.separator+ "s_"+fileName);
			System.out.println("file not null");

		} else {
		 fileName =  File.separator + "images" + File.separator + "none.png";
		 
		 vo.setGdsImg(fileName);
		 vo.setGdsThumbImg(fileName);
		 System.out.println("file null");
		}

	
		service.register(vo);
		
		
		return "redirect:/admin/index";
	}
	
	
	@RequestMapping(value ="/goods/list", method=RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception{
		
		logger.info("get list 페이지");
		
		List<GoodsViewVO> list = service.getList();
		
		model.addAttribute("list",list);
	}
	
	
	@RequestMapping(value="/goods/view",method=RequestMethod.GET)
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get goods view");

		
		GoodsViewVO goods = service.goodsView(gdsNum);
		

		model.addAttribute("goods",goods);
	}
	
	
	@RequestMapping(value="/goods/modify" , method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum,Model model) throws Exception{
		
		logger.info("상품수정페이지");
		
		GoodsViewVO goods = service.goodsView(gdsNum);
		model.addAttribute("goods",goods);
		
		List<CategoryVO> category = null;
		category = service.category();
		System.out.println("category리스트"+category);
		model.addAttribute("category", JSONArray.fromObject(category));
		
		
	}
	
	
	/*
	 * // 상품 수정
	 * 
	 * @RequestMapping(value ="/goods/modify", method = RequestMethod.POST) public
	 * String postGoodsModify(GoodsVO vo, MultipartFile file,HttpServletRequest req)
	 * throws Exception { logger.info("post goods modify");
	 * 
	 * service.goodsModify(vo);
	 * 
	 * return "redirect:/admin/index"; }
	 */
	
	// 상품 수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
	 logger.info("post goods modify");

	 // 새로운 파일이 등록되었는지 확인
	 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	  // 기존 파일을 삭제
	  new File(uploadPath + req.getParameter("gdsImg")).delete();
	  new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
	  
	  // 새로 첨부한 파일을 등록
	  String imgUploadPath = uploadPath + File.separator + "imgUpload";
	  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
	  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
	  
	  vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
	  vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	  
	 } else{
		 // 새로운 파일이 등록되지 않았다면
	  // 기존 이미지를 그대로 사용
	  vo.setGdsImg(req.getParameter("gdsImg"));
	  vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
	  
	 }
	 
	 	service.goodsModify(vo);
	 
	 return "redirect:/admin/index";
	}
	
	
	// 상품 삭제
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
	 logger.info("post goods delete");

	 service.goodsDelete(gdsNum);
	 
	 return "redirect:/admin/index";
	}
	
	
	
	public void postCKEditorImgUpload(HttpServletRequest req,
									   HttpServletResponse res,
									   @RequestParam MultipartFile upload) throws Exception{
		logger.info("post CKEditor img upload");
		
		UUID uid =UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		//인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			
			String fileName = upload.getOriginalFilename();
			byte[] bytes =upload.getBytes();
			
			//업로드 경로
			String ckUploadPath =uploadPath + File.separator +"ckUpload" +File.separator + uid + "_" + fileName;
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			
			String callback =req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "/ckUpload/"+ uid + "_" + fileName; //작성화면 
			
			//업로드시 메시지 출력
			
			printWriter.println("<script type= 'text/javascript'>"
					+ "window.parent.CKEDITOR.tools.callFunction("
					+ callback+",'"+fileUrl+"','이미지를 업로드하였습니다.')"
					+"</script>");
			
			printWriter.flush();
			
		 } catch (IOException e) { e.printStackTrace();
		 } finally {
		  try {
		   if(out != null) { out.close(); }
		   if(printWriter != null) { printWriter.close(); }
		  } catch(IOException e) { e.printStackTrace(); }
		 }
		 
		 return; 
		}
			
		/*
		 * //delivery 상태 변화
		 * 
		 * @RequestMapping(value = "/shop/orderView", method = RequestMethod.POST)
		 * public String delivery(OrderInfoVO order) throws Exception{
		 * 
		 * service.delivery(order);
		 * 
		 * return "redirect:/admin/shop/orderView?n=" +order.getOrderId(); }
		 */
	
	// 주문 목록
	@RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
	 logger.info("get order list");
	   
	 List<OrderInfoVO> orderList = service.OrderList();
	 
	 model.addAttribute("orderList", orderList);
	}

	// 주문 상세 목록
	@RequestMapping(value = "/shop/orderView", method = RequestMethod.GET)
	public void getOrderList(@RequestParam("n") String orderId,
	      OrderInfoVO order, Model model,HttpSession session) throws Exception {
			logger.info("get order view");
	 
		 order.setOrderId(orderId);  
		 System.out.println("ORDERiD:"+orderId);
		 
		 List<OrderListVO> orderView = service.OrderView(order);
		 model.addAttribute("orderView", orderView);
		 System.out.println("ORDERVIEW!@#!@#:"+orderView);

	}
	//주문 상태 변경
	@RequestMapping(value="/shop/orderView",method = RequestMethod.POST)
	public String Postdelivery(OrderInfoVO vo) throws Exception{
		
		service.delivery(vo);
		
		List<OrderListVO> orderView = service.OrderView(vo);
		GoodsVO goods = new GoodsVO();
		
		for(OrderListVO i : orderView) {
			goods.setGdsNum(i.getGdsNum());
			goods.setGdsStock(i.getCartStock());
			service.changeStock(goods);
		}
		
		return "redirect:/admin/shop/orderView?n="+ vo.getOrderId();
		
	}
	
	//모든 소감
	@RequestMapping(value="/shop/allReply", method= RequestMethod.GET)
	public void getAllReply(Model model) throws Exception{
		logger.info("get all reply");
		
		List<ReplyListVO> reply = service.allReply();
		
		model.addAttribute("reply", reply);
		
	}
	// 댓글 삭제
	@RequestMapping(value="/shop/allReply", method= RequestMethod.POST)
	public String DeleteReply(ReplyListVO vo) throws Exception{
		
		
		int repNum = vo.getRepNum();
		service.deleteReply(repNum);
		
		
		return "redirect:/admin/shop/allReply";
		
		
		
		
	}
	

	
	
			
		
	}
									
	
	
	
