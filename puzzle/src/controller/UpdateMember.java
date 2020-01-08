package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/pwUpdate")
public class UpdateMember extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		System.out.println("UpdateMember 서블릿 실행");
		String memberId = request.getParameter("memberId");
		String prevMemberPw = request.getParameter("prevMemberPw");
		String nextMemberPw = request.getParameter("nextMemberPw");
		System.out.println("Update memberId : "+memberId);
		System.out.println("Update prevMemberPw : "+prevMemberPw);
		System.out.println("Update nextMemberPw : "+nextMemberPw);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(prevMemberPw);
		
		memberService = new MemberService();
		int check = memberService.updateMemberService(member, nextMemberPw);
		
		Gson gson = new Gson();
		String json = gson.toJson(check);
		response.getWriter().write(json);
	}

}
