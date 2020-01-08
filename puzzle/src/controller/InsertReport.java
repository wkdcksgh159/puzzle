package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.ReportService;
import vo.Report;

/**
 * Servlet implementation class InsertImport
 */
@WebServlet("/addReport")
public class InsertReport extends HttpServlet {
	private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("InsertMember 서블릿 실행");
		String memberId = request.getParameter("loginState");
		int count = Integer.parseInt(request.getParameter("count"));
		int timer = Integer.parseInt(request.getParameter("timer"));
		System.out.println("Insert memberId : "+memberId);
		System.out.println("Insert count : "+count);
		System.out.println("Insert timer : "+timer);
		
		Report report = new Report();
		report.setMemberId(memberId);
		report.setCount(count);
		report.setTimer(timer);
		
		reportService = new ReportService();
		reportService.insertReportService(report);
	}

}
