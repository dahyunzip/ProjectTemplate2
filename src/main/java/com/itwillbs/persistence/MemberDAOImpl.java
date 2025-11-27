package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper.";

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberVO member) {
		return sqlSession.insert(NAMESPACE + "insertMember", member);
	}

	@Override
	public int insertAuthority(String username, String authority) {
		Map<String, String> param = new HashMap<>();
		param.put("username", username);
		param.put("authority", authority);
		return sqlSession.insert(NAMESPACE + "insertAuthority", param);
	}

	@Override
	public MemberVO findByUsername(String username) {
		return sqlSession.selectOne(NAMESPACE + "selectByUsername", username);
	}

	@Override
	public void updateMemberInfo(MemberVO vo) throws Exception {
		sqlSession.update(NAMESPACE+"updateMemberInfo", vo);
	}

	@Override
	public void updateEnabled(String username, int enabled) throws Exception {
		sqlSession.update(NAMESPACE + "updateEnabled", 
				Map.of("username", username, "enabled", enabled));
	}
	
	
}
