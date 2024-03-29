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

@WebServlet("/delete")
public class deleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
			String  recordNo = req.getParameter("recordNo");
			
			recordService service = new recordService();
			
			int result = service.delete(recordNo);
			
			HttpSession session = req.getSession();
			RecordMember recordmember = (RecordMember) session.getAttribute("loginMember");
			
			
			
			if(result > 0) { 
				
				
				List<DayRecord>  recordList = service.selectAll(recordmember.getMemberNo());
				session.setAttribute("recordList",  recordList);
				
				
			}else {
				session.setAttribute("message", "삭제 실패!");
			}
			
			resp.sendRedirect("/");
			
		}catch(Exception e) {
			System.out.println("[삭제 중 예외발생]");
			e.printStackTrace();
		}
		
		
	}

}
