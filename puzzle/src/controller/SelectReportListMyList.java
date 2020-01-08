package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReportService;
import vo.Report;
import vo.Member;

/**
 * Servlet implementation class SelectImportListMyList
 */
@WebServlet("/myList")
public class SelectReportListMyList extends HttpServlet {
	private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectImportListMyList 서블릿 실행 확인!");
		response.setContentType("application/json;charset=utf-8");
		//loginState 데이터를 가져와서 객체에 저장
		String loginState = request.getParameter("loginState");
		Member member = new Member();
		member.setMemberId(loginState);
		reportService = new ReportService();
		List<Report> list = reportService.selectReportListMyListService(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().write(json);
	}

}
