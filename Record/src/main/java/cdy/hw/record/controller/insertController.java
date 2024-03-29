package cdy.hw.record.controller;

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

@WebServlet("/insert")
public class insertController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			String recordTitle = req.getParameter("recordTitle");
			String recordMemo = req.getParameter("recordMemo");
			
			RecordMember  recordmember = (RecordMember) session.getAttribute("loginMember"); 
			
			
			recordService service = new recordService();
			
			int result = service.insert(recordTitle,recordMemo,recordmember.getMemberNo());
			
			if(result > 0) { 
				session.setAttribute("message", "등록되었습니다");
				
				List<DayRecord> recordList = service.selectAll(recordmember.getMemberNo());
				session.setAttribute("recordList", recordList);
				
				resp.sendRedirect("/");
					
			}else {
				session.setAttribute("message", "등록실패!");
				
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
			
		}catch(Exception e) {
			System.out.println("[record 등록 중 예외발생]");
			e.printStackTrace();
		}
	}
	
	

}
