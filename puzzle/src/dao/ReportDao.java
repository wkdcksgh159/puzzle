package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Report;
import vo.Member;

public class ReportDao {
	public List<Report> selectReportList(Connection conn) throws SQLException {
		System.out.println("selectReportList 메소드 실행 확인!");
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT report_id, member_id, report_date, count, timer FROM puzzle_report ORDER BY timer ASC, count ASC LIMIT 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Report i = new Report();
				i.setReportId(rs.getInt("report_id"));
				i.setMemberId(rs.getString("member_id"));
				i.setReportDate(rs.getString("report_date"));
				i.setCount(rs.getInt("count"));
				i.setTimer(rs.getInt("timer"));
				list.add(i);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return list;
	}
	
	public List<Report> selectReportListMyList(Connection conn, Member member) throws SQLException {
		System.out.println("selectReportListMyList 메소드 실행 확인!");
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT report_id, member_id, report_date, count, timer FROM puzzle_report WHERE member_id=? ORDER BY timer ASC, count ASC";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				Report i = new Report();
				i.setReportId(rs.getInt("report_id"));
				i.setMemberId(rs.getString("member_id"));
				i.setReportDate(rs.getString("report_date"));
				i.setCount(rs.getInt("count"));
				i.setTimer(rs.getInt("timer"));
				list.add(i);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return list;
	}
	
	public List<Report> selectReportListMonth(Connection conn) throws SQLException {
		System.out.println("selectReportListMonth 메소드 실행 확인!");
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT report_id, member_id, report_date, count, timer FROM puzzle_report WHERE year(report_date) = year(Now()) and Month(report_date)=Month(Now()) ORDER BY timer ASC, count ASC LIMIT 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Report i = new Report();
				i.setReportId(rs.getInt("report_id"));
				i.setMemberId(rs.getString("member_id"));
				i.setReportDate(rs.getString("report_date"));
				i.setCount(rs.getInt("count"));
				i.setTimer(rs.getInt("timer"));
				list.add(i);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return list;
	}
	
	public List<Report> selectReportListToday(Connection conn) throws SQLException {
		System.out.println("selectReportListToday 메소드 실행 확인!");
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT report_id, member_id, report_date, count, timer FROM puzzle_report WHERE year(report_date) = year(Now()) and month(report_date) = month(Now()) and day(report_date) = day(Now()) ORDER BY timer ASC, count ASC LIMIT 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Report i = new Report();
				i.setReportId(rs.getInt("report_id"));
				i.setMemberId(rs.getString("member_id"));
				i.setReportDate(rs.getString("report_date"));
				i.setCount(rs.getInt("count"));
				i.setTimer(rs.getInt("timer"));
				list.add(i);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return list;
	}
	
	public void insertReport(Connection conn, Report report) throws Exception{
		System.out.println("MemberDao insertMember 실행 확인!");
		PreparedStatement stmt = null;
		String sql = "INSERT INTO puzzle_report (member_id, report_date, count, timer) VALUES(?, now(), ?, ?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, report.getMemberId());
			stmt.setInt(2, report.getCount());
			stmt.setInt(3, report.getTimer());
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return;
	}
}
