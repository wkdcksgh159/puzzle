package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetSessionInfo
 */
@WebServlet("/GetSessionInfo")
public class GetSessionInfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetSessionInfo.doPost");
		response.setContentType("application/json;charset=utf-8");
		HttpSession session = request.getSession();
		String sessionInfo = (String)session.getAttribute("sessionInfo");
		System.out.println("sessionInfo : "+sessionInfo);
		
		Gson gson = new Gson();
		String json = gson.toJson(sessionInfo);
		System.out.println("json : "+json);
		response.getWriter().write(json);
	}

}
