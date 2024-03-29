package cdy.hw.record.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cdy.hw.record.dto.DayRecord;


import static cdy.hw.record.common.JDBCTemplate.*;




public class RecordDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	//기본생성자안에 xml작성 까먹지 말기!!
	public RecordDAO() {
		try {
			prop = new Properties();
			
			String filePath
			= RecordDAO.class.getResource("/cdy/hw/record/sql/record-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

	public List<DayRecord> selectAll(Connection conn, int memberNo) throws Exception {
		
		List<DayRecord> recordList = new ArrayList<DayRecord>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DayRecord record = new DayRecord();
				
				record.setRecordNo(rs.getInt("RECORD_NO"));
				record.setRecordTitle(rs.getString("RECORD_TITLE"));
				record.setRecordMemo(rs.getString("RECORD_MEMO"));
				record.setRecordDate(rs.getString("RECORD_DATE"));
				
				recordList.add(record);
				
			}
		
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return  recordList;
	}



	public int insert(Connection conn, String recordTitle, String recordMemo, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, recordTitle);
			pstmt.setString(2, recordMemo);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}






	public int delete(Connection conn, String recordNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, recordNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}






	public DayRecord update(Connection conn, String recordNo, int memberNo) throws Exception {
		
		DayRecord  dayrecord  = null;
		
		try {
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, recordNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dayrecord = new DayRecord ();
				dayrecord.setRecordNo(rs.getInt("RECORD_NO"));
				dayrecord.setRecordTitle(rs.getString("RECORD_TITLE"));
				dayrecord.setRecordMemo(rs.getString("RECORD_MEMO"));
				dayrecord.setRecordDate(rs.getString("RECORD_DATE"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return dayrecord;
	}






	public int update(Connection conn, String recordtitle, String recordmemo, int memberNo, String recordNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("update2");
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, recordtitle);
			pstmt.setString(2, recordmemo);
			pstmt.setString(3, recordNo);
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
