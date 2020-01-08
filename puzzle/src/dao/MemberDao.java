package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Report;
import vo.Member;

public class MemberDao {
	/*
	 *  SELECT member_id FROM member
	 *  WHERE member_id=? AND member_pw=? AND member_level='Y'
	 */
	public Member login(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao login 실행 확인!");
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT member_id FROM puzzle_member WHERE member_id=? AND member_pw=? AND member_level='Y'";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString("member_id"));
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return returnMember;
	}
	
	public void insertMember(Connection conn, Member member) throws Exception{
		System.out.println("MemberDao insertMember 실행 확인!");
		PreparedStatement stmt = null;
		String sql = "INSERT INTO puzzle_member (member_id, member_pw, member_level) VALUES(?, ?, 'Y')";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return;
	}
	
	public int updateMember(Connection conn, Member member, String nextMemberPw) throws Exception {
		System.out.println("MemberDao updateMember 실행 확인!");
		PreparedStatement stmt = null;
		String sql = "UPDATE puzzle_member SET member_pw=? WHERE member_id=? AND member_pw=?";
		int check = 0;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, nextMemberPw);
			stmt.setString(2, member.getMemberId());
			stmt.setString(3, member.getMemberPw());
			check = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return check;
	}
	
	public int deleteMember(Connection conn, Member member) throws Exception {
		System.out.println("MemberDao deleteMember 실행 확인!");
		PreparedStatement stmt = null;
		int check = 0;
		String sql = "DELETE FROM puzzle_member WHERE member_id=? AND member_pw=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			check = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return check;
		
	}
	
	public List<Member> selectLevel(Connection conn, Member member) throws Exception{
		System.out.println("MemberDao selectLevelDao 실행 확인!");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		
		String sql = "SELECT game_level, game_exp FROM puzzle_member WHERE member_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			rs = stmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberGameLevel(rs.getInt("game_level"));
				member.setMemberGameExp(rs.getInt("game_exp"));
				list.add(member);
				
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return list;
	}
	
	public void updateMemberExp(Connection conn, Member member) throws Exception {
		System.out.println("MemberDao updateMemberExp 실행 확인!");
		PreparedStatement stmt = null;
		String sql = "UPDATE puzzle_member SET game_level=?, game_exp=? WHERE member_id=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, member.getMemberGameLevel());
			stmt.setInt(2, member.getMemberGameExp());
			stmt.setString(3, member.getMemberId());
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return;
	}
}
