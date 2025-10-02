package ex0807.board;

public class UploadBoardService implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("upload = " + board);
		System.out.println(getClass().getSimpleName() + "의 insert입니다.");
		return 1;
	}

	@Override
	public int update(Board board) {
		System.out.println("upload = " + board);
		System.out.println(getClass().getSimpleName() + "의 update입니다.");
		return 1;
	}

	@Override
	public Board searchByBno(int bno) {
		System.out.println("upload = " + bno);
		System.out.println(getClass().getSimpleName() + "의 searchByBno입니다.");
		return new UploadBoard(103, "test3", "testUpload", "testcontent3", "file");
	}
	

}
