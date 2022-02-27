package com.company.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.company.domain.MemberDTO;
import com.company.domain.MemberVO;

@Service
public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;

	public MemberVO signin(MemberVO vo) throws Exception;
	
	public void signout(HttpSession session) throws Exception;
	

	
	//authKey 업데이트 
	public void updateAuthKey(Map<String, String> map);
	
}
