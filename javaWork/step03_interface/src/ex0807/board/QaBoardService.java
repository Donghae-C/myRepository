package ex0807.board;

public class QaBoardService implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("QA = " + board);
		System.out.println(getClass().getSimpleName() + "의 insert입니다.");
		return 1;
	}

	@Override
	public int update(Board board) {
		System.out.println("QA = " + board);
		System.out.println(getClass().getSimpleName() + "의 update입니다.");
		return 1;
	}

	@Override
	public Board searchByBno(int bno) {
		System.out.println("QA = " + bno);
		System.out.println(getClass().getSimpleName() + "의 searchByBno입니다.");
		return new QaBoard(101, "test2", "testQa", "testContent2", true);
	}
}
