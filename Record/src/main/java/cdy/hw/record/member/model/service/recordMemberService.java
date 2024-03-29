package cdy.hw.record.member.model.service;

import java.sql.Connection;

import static  cdy.hw.record.common.JDBCTemplate.*;


import cdy.hw.record.member.model.dao.recordMemberDAO;
import cdy.hw.record.member.model.dto.RecordMember;

public class recordMemberService {
	
	private recordMemberDAO dao = new recordMemberDAO();


	//로그인 서비스
	public RecordMember login(String inputId, String inputPw) throws Exception {

		Connection conn = getConnection();
		
		RecordMember loginMember = dao.login(conn,inputId,inputPw);
		
		close(conn);
		
		return loginMember;

	}

//회원가입 서비스
	public int signup(RecordMember recordMember) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.signup(conn,recordMember);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
		
	}
	
	

}
