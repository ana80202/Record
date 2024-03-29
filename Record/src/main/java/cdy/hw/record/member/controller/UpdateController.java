package cdy.hw.record.member.controller;

import java.io.IOException;
import java.util.List;

import cdy.hw.record.dto.DayRecord;
import cdy.hw.record.member.model.dto.RecordMember;
import cdy.hw.record.member.model.service.recordService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	
	private recordService service = new recordService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			HttpSession session = req.getSession();
			RecordMember recordMember = (RecordMember) session.getAttribute("loginMember");
			
			DayRecord dayrecord = service.selectOne(req.getParameter("recordNo"), recordMember.getMemberNo());
			
			req.setAttribute("dayrecord", dayrecord);
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
			
			
			
		}catch(Exception e) {
		System.out.println("[수정할 record 조회 중 예외 발생]");
		e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			RecordMember recordMember = (RecordMember) session.getAttribute("loginMember");
			String  recordtitle = req.getParameter("recordTitle");
			String  recordmemo = req.getParameter("recordMemo");
			String  recordNo = req.getParameter("recordNo");
			
			int result = service.update( recordtitle,recordmemo,recordMember.getMemberNo(), recordNo );
			
			if(result > 0) {
				session.setAttribute("message", "수정 되었습니다!");
				
			
				List<DayRecord> recordList = service.selectAll(recordMember.getMemberNo());
				session.setAttribute("recordList", recordList);
				
			
				resp.sendRedirect("/");
				
			}else {
				session.setAttribute("message", "수정 실패!");
				
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
		}catch(Exception e) {
			System.out.println("[Record 수정 중 예외 발생]");
			e.printStackTrace();
		}
		
	}
	

}
