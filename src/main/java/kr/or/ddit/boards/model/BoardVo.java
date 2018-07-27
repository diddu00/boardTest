package kr.or.ddit.boards.model;

public class BoardVo {
	private String board_code;	
	private String board_nm;	
	private String board_use;
	
	
	public BoardVo() {
		super();
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getBoard_nm() {
		return board_nm;
	}
	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	@Override
	public String toString() {
		return "BoardVo [board_code=" + board_code + ", board_nm=" + board_nm
				+ ", board_use=" + board_use + "]";
	}
	
	
}
