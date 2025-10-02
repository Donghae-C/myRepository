package ex0807.board;

public class FreeBoardService implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("Free = " + board);
		System.out.println(getClass().getSimpleName() + "의 insert입니다.");
		return 1;
	}

	@Override
	public int update(Board board) {
		System.out.println("Free = " + board);
		System.out.println(getClass().getSimpleName() + "의 update입니다.");
		return 1;
	}

	@Override
	public Board searchByBno(int bno) {
		System.out.println("Free = " + bno);
		System.out.println(getClass().getSimpleName() + "의 searchByBno입니다.");
		return new FreeBoard(100, "test", "testfree1", "testcontent1");
	}

	@Override
	public int delete(int bno) {
		System.out.println("아무것도 안함");
		return 10;
	}
	

}
