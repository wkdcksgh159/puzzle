package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class InsertExp
 */
@WebServlet("/InsertExp")
public class UpdateExp extends HttpServlet {
	Member member;
	MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InsertExp 서블릿 실행 확인!");
		String memberId = request.getParameter("loginState");
		int memberGameLevel = Integer.parseInt(request.getParameter("level"));
		int memberGameExp = Integer.parseInt(request.getParameter("exp"));
		
		System.out.println(memberId);
		System.out.println(memberGameLevel);
		System.out.println(memberGameExp);
		
		member = new Member();
		member.setMemberId(memberId);
		member.setMemberGameLevel(memberGameLevel);
		member.setMemberGameExp(memberGameExp);
		
		memberService = new MemberService();
		memberService.updateMemberExpService(member);
	}

}
