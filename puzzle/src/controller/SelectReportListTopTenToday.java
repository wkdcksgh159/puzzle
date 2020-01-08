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

/**
 * Servlet implementation class SelectImportListTopTenToday
 */
@WebServlet("/today")
public class SelectReportListTopTenToday extends HttpServlet {
	private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectReportListTopTenToday 서블릿 실행 확인!");
		response.setContentType("application/json;charset=utf-8");
		
		reportService = new ReportService();
		List<Report> list = reportService.selectReportListTodayService();
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().write(json);
	}

}
