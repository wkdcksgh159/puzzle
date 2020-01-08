package vo;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberLevel;
	private int memberGameLevel;
	private int memberGameExp;
	
	public int getMemberGameLevel() {
		return memberGameLevel;
	}
	public void setMemberGameLevel(int memberGameLevel) {
		this.memberGameLevel = memberGameLevel;
	}
	public int getMemberGameExp() {
		return memberGameExp;
	}
	public void setMemberGameExp(int memberGameExp) {
		this.memberGameExp = memberGameExp;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberLevel=" + memberLevel
				+ ", memberGameLevel=" + memberGameLevel + ", memberGameExp=" + memberGameExp + "]";
	}
	
}
