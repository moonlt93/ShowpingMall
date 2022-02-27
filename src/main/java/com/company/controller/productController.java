package com.company.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.domain.productVO;
import com.company.service.productService;


@RequestMapping("/product")
@Controller
public class productController {
	
	@Inject
	productService service;

	
	//게시물 목록
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void getList(Model model)  throws Exception  {
	
	List<productVO> list = service.list();
	System.out.println("list내용물 확인"+list);
	
	model.addAttribute("list",list);
		
	}
	
	//게시물 작성
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
	
	//게시글 작성
	@RequestMapping(value="/write",method = RequestMethod.POST)
	public String postWrite(productVO vo) throws Exception{
		
		service.write(vo);
		
		return "redirect:/product/list";
	}
	
	
	@RequestMapping(value="/click",method=RequestMethod.GET)
	public void getClick(@RequestParam("showNo") int showNo, Model model) throws Exception{
		
		productVO vo = service.click(showNo);
		
		model.addAttribute("list",vo);
	
	}
	
	//게시물 작성
		@RequestMapping(value="/modify", method=RequestMethod.GET)
		public void getModify(@RequestParam("showNo") int showNo,Model model) throws Exception{
			

			productVO vo = service.click(showNo);
			
			model.addAttribute("list",vo);
			
			
		}
		
		//게시글 수정
		@RequestMapping(value="/modify", method=RequestMethod.POST)
		public String PostModify(productVO vo) throws Exception{
			
			service.modify(vo);
			return "redirect:/product/click?showNo="+vo.getShowNo();
			
		}
		
		@RequestMapping(value="/delete", method=RequestMethod.GET)
		public String getDelete(@RequestParam("showNo") int showNo)throws Exception{
			
			service.delete(showNo);
			
			return "redirect:/product/list";
		}
		
		
		//게시물 목록
		@RequestMapping(value="/listPage",method=RequestMethod.GET)
		public void GetListPaging(Model model,@RequestParam("num") int num)  throws Exception  {
		
		//게시물 총 갯수
			
		int count = service.count();
		
		//한 페이지 출력할 갯수
		int postNum =10;
		
		//하단 페이징 번호([게시물 총 갯수 / 한 페이지에 출력할 갯수]의 올림)
		int pageNum =(int)Math.ceil((double)count/postNum);
		
		
		//출력할 게시물
		int displayPost =(num-1) * postNum;
		
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		
		//마지막 번호 계산
		int endPageNum_tmp =(int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false :true;
		
		boolean next = endPageNum * pageNum_cnt >= count ?false :true;
		
	
		List list = null;
		list=service.list();
		System.out.println("list내용물 확인"+list);
		
		model.addAttribute("list",list);
		model.addAttribute("pageNum", pageNum);
		
		//시작 및 끝 번호
		model.addAttribute("startPageNum",startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		//이전 및 다음
		
		model.addAttribute("prev",prev);
		model.addAttribute("next", next);
		
		//현재 페이지
		
		model.addAttribute("select", num);

		
		}
	
	
 	
	
}
