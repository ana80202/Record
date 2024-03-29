package cdy.hw.record.member.model.service;

import static cdy.hw.record.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import cdy.hw.record.dto.DayRecord;
import cdy.hw.record.member.model.dao.RecordDAO;


public class recordService {
	
	private RecordDAO dao = new RecordDAO();

	public List<DayRecord> selectAll(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<DayRecord> recordList = dao.selectAll(conn,memberNo);
		
		close(conn);
		
		return recordList;
	}
	


	public int insert(String recordTitle, String recordMemo, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.insert(conn,recordTitle,recordMemo,memberNo);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}



	public int delete(String recordNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.delete(conn,recordNo);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return  result;
	}



	public DayRecord selectOne(String recordNo, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		DayRecord  dayrecord = dao.update(conn, recordNo, memberNo);
		
		close(conn);
		
		return  dayrecord ;
	}



	public int update(String recordtitle, String recordmemo, int memberNo, String recordNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.update(conn, recordtitle, recordmemo, memberNo, recordNo);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return  result;
	}
	
	

}
