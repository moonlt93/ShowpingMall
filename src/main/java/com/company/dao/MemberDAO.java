package com.company.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.company.domain.MemberDTO;
import com.company.domain.MemberVO;

@Repository
public interface MemberDAO {
	
	public void signup(MemberVO vo) throws Exception;

	public MemberVO signin(MemberVO vo) throws Exception;

	public void Authentication(MemberDTO memberDTO);

	public void updateAuthKey(Map<String, String> map);
	
	
	

}
