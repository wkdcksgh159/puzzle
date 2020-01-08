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
 * Servlet implementation class DeleteMember
 */
@WebServlet("/closeByMember")
public class DeleteMember extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		System.out.println("DeleteMember 서블릿 실행");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println("Delete memberId : "+memberId);
		System.out.println("Delete memberPw : "+memberPw);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		memberService = new MemberService();
		int check = memberService.deleteMemberService(member);

		Gson gson = new Gson();
		String json = gson.toJson(check);
		response.getWriter().write(json);
		
		request.getSession().invalidate();
	}

}
