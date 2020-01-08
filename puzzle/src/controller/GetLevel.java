package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class GetLevel
 */
@WebServlet("/GetLevel")
public class GetLevel extends HttpServlet {
	MemberService memberService;
	Member member;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetLevel 서블릿 실행 확인!");
		response.setContentType("application/json;charset=utf-8");
		String memberId = request.getParameter("memberId");
		System.out.println("GetLevel memberId : "+memberId);
		
		member = new Member();
		member.setMemberId(memberId);
		
		List<Member> list = new ArrayList<Member>();
		memberService = new MemberService();
		list = memberService.selectLevelService(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().write(json);
		
	}

}
