package com.company.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.domain.MemberDTO;
import com.company.domain.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sql;
	
	@Inject
	private static String namespace="com.company.mappers.memberMapper";
	
	
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		
		sql.insert(namespace +".signup",vo);

	}
	
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
	
		return sql.selectOne(namespace+".signin",vo);
		
	}
	
	
	@Override
	public void Authentication(MemberDTO memberDTO) {
		
		sql.insert(namespace + ".Authentication",memberDTO);
		
	}
	
	@Override
	public void updateAuthKey(Map<String, String> map) {
		
		sql.update(namespace +".updateAuthKey",map);
		
	}
	

}
