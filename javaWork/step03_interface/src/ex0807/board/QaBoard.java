package ex0807.board;

public class QaBoard extends Board {
	private boolean replyState;

	public QaBoard() {
		super();
	}
	
	public QaBoard(int bno, String subject, String writer, String content, boolean replyState) {
		super(bno, subject, writer, content);
		this.replyState = replyState;
	}

	public boolean isReplyState() {
		return replyState;
	}

	public void setReplyState(boolean replyState) {
		this.replyState = replyState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("replyState=").append(replyState).append(super.toString());
		return builder.toString();
	}
	
	
	
	
}
