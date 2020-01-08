package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDao;
import dao.ReportDao;
import vo.Report;
import vo.Member;



public class ReportService {
	public List<Report> selectReportListService() {
		System.out.println("selectReportListService 실행 확인!");
		Connection conn = null;
		ReportDao reportDao = null;
		DBService dbService = null;
		List<Report> list = null;
		try {	
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			reportDao = new ReportDao();
			//before
			list = reportDao.selectReportList(conn);
			//after
			
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<Report> selectReportListMyListService(Member member) {
		System.out.println("selectReportListMyListService 실행 확인!");
		Connection conn = null;
		ReportDao reportDao = null;
		DBService dbService = null;
		List<Report> list = null;
		try {	
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			reportDao = new ReportDao();
			//before
			list = reportDao.selectReportListMyList(conn, member);
			//after
			
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<Report> selectReportListMonthService() {
		System.out.println("selectReportListMonthService 실행 확인!");
		Connection conn = null;
		ReportDao reportDao = null;
		DBService dbService = null;
		List<Report> list = null;
		try {	
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			reportDao = new ReportDao();
			//before
			list = reportDao.selectReportListMonth(conn);
			//after
			
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<Report> selectReportListTodayService() {
		System.out.println("selectReportListTodayService 실행 확인!");
		Connection conn = null;
		ReportDao reportDao = null;
		DBService dbService = null;
		List<Report> list = null;
		try {	
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			reportDao = new ReportDao();
			//before
			list = reportDao.selectReportListToday(conn);
			//after
			
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void insertReportService(Report report) {
		System.out.println("insertReportService 실행 확인!");
		Connection conn =  null;
		ReportDao reportDao = null;
		DBService dbService = null;
		try {
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			reportDao = new ReportDao();
			
			reportDao.insertReport(conn, report);
			
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}
}
