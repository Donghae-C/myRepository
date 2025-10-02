package ex0807.board;


public class UploadBoard extends Board {
	private String fileName;

	public UploadBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadBoard(int bno, String subject, String writer, String content, String fileName) {
		super(bno, subject, writer, content);
		this.fileName = fileName;
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("fileName=").append(fileName).append(super.toString());
		return builder.toString();
	}
	
	
	
}
