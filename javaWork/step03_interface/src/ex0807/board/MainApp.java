package ex0807.board;

public class MainApp {
	
	BoardService service; //필드를 다형성이용(FreeBoardService, QaBoardService, UploadBoardService)
	Board board; //(Board들)
	
	public MainApp() {
		service = new FreeBoardService();
		test(new FreeBoard(100, "test", "testcontent", "testFree"));
		service = new QaBoardService();
		test(new QaBoard(101, "test", "testcontent", "testQa", true));
		service = new UploadBoardService();
		test(new UploadBoard(100, "test", "testcontent", "testUpload", "test"));
	}
	
	public void test(Board board) {
		service.insert(board);
		service.update(board);
		Board searchedBoard = service.searchByBno(0);
		System.out.println(searchedBoard);
		service.delete(6);
		BoardService.searchAll();
		System.out.println("--------------------------------------------------------");
	}

	public static void main(String[] args) {
		new MainApp();
	}

}
