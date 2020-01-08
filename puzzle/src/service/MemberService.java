package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDao;
import vo.Member;
import vo.Report;

public class MemberService {
	public String login(Member member) {
		System.out.println("MemberService login() 실행 확인!");
		Member returnMember = null;
		Connection conn = null;
		MemberDao memberDao = null;
		DBService dbService = null;
		try {	
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			
			//before
			returnMember = memberDao.login(conn, member);
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
		
		return returnMember.getMemberId();
	}
	
	public void insertMemberService(Member member) {
		System.out.println("insertMemberService 실행 확인!");
		Connection conn =  null;
		MemberDao memberDao = null;
		DBService dbService = null;
		try {
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			
			memberDao.insertMember(conn, member);
			
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
	
	public int updateMemberService(Member member, String nextMemberPw) {
		System.out.println("updateMemberService 실행 확인!");
		Connection conn =  null;
		MemberDao memberDao = null;
		DBService dbService = null;
		int check = 0;
		try {
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			
			check = memberDao.updateMember(conn, member, nextMemberPw);
			
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
		return check;
	}
	
	public int deleteMemberService(Member member) {
		System.out.println("deleteMemberService 실행 확인!");
		Connection conn =  null;
		MemberDao memberDao = null;
		DBService dbService = null;
		int check = 0;
		try {
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			
			check = memberDao.deleteMember(conn, member);
			
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
		return check;
	}
	
	public List<Member> selectLevelService(Member member) {
		System.out.println("selectLevelService 실행 확인!");
		Connection conn =  null;
		MemberDao memberDao = null;
		DBService dbService = null;
		List<Member> list = null;
		try {
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			
			list = memberDao.selectLevel(conn, member);
			
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
		return list;
	}
	
	public void updateMemberExpService(Member member) {
		System.out.println("updateMemberExpService 실행 확인!");
		Connection conn =  null;
		MemberDao memberDao = null;
		DBService dbService = null;
		try {
			dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			
			memberDao.updateMemberExp(conn, member);
			
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
