package cdy.hw.record.member.controller;

import java.io.IOException;

import cdy.hw.record.member.model.dto.RecordMember;
import cdy.hw.record.member.model.service.recordMemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signUp")
public class SignupController extends HttpServlet {
	
	
	//회원가입 폼으로 이동
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(req, resp);
		}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			
			RecordMember recordMember = new RecordMember();
			recordMember.setMemberId(inputId);
			recordMember.setMemberPw(inputPw);
			recordMember.setMemberNickname(inputName);
			
			recordMemberService service = new recordMemberService();
			
			int result = service.signup(recordMember);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				session.setAttribute("message", "회원가입 완료!");
				resp.sendRedirect("/");
			}else {
				session.setAttribute("message", "회원가입 오류...");
				resp.sendRedirect(req.getHeader("referer") ); 
			}
			
			
		}catch(Exception e) {
			System.out.println("[회원 가입 중 예외 발생]");
			e.printStackTrace();
		}
		
	}
	
}


