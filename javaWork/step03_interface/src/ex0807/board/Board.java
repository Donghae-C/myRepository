package ex0807.board;
/**
 * 모든 게시판 유형이 공통으로 사용하는 속성을 관리하는 객체
 */
public class Board {
	private int bno;
	private String subject;
	private String writer;
	private String content;
	
	public Board() {
		
	}
	
	public Board(int bno, String subject, String writer, String content) {
		this.bno = bno;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", bno=").append(bno).append(", subject=").append(subject).append(", writer=").append(writer)
				.append(", content=").append(content);
		return builder.toString();
	}
	
	
	
	
	
}
