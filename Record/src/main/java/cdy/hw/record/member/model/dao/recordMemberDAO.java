package cdy.hw.record.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import cdy.hw.record.member.model.dto.RecordMember;

import static  cdy.hw.record.common.JDBCTemplate.*;



public class recordMemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public  recordMemberDAO() {
		try {
			prop = new Properties();
			
			String filePath
			= recordMemberDAO.class.getResource("/cdy/hw/record/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public RecordMember login(Connection conn, String inputId, String inputPw) throws Exception {
		
		RecordMember loginMember = null;
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new RecordMember();
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberId(rs.getString(2));
				loginMember.setMemberNickname(rs.getString(3));
				loginMember.setEnrollDate(rs.getString(4));
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return loginMember;
		
	}

	public int signup(Connection conn, RecordMember recordMember) throws Exception {
		
	int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, recordMember.getMemberId());
			pstmt.setString(2, recordMember.getMemberPw());
			pstmt.setString(3, recordMember.getMemberNickname());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
}
