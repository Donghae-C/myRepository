package ex0807.board;

import java.util.List;

/**
 * 모든 게시판 유형이 공통으로 사용할 메소드 정의
 * :규격서 역할
 */
public interface BoardService {
	/**
	 * 등록
	 * @return : int (0이면 실패, 1이상이면 성공)
	 * @param : Board(Free or QnA or Upload)
	 */
	int insert(Board board); //작성된 글 등록 메서드
	/**
	 * 글번호에 해당하는 작성자와 내용만 수정
	 * @return : int (0이면 실패, 1이상이면 성공)
	 * @param : Board(Free or QnA or Upload)
	 */
	int update(Board board); //작성된 글 수정 메서드
	/**
	 * 글번호로 게시물 검색하기
	 * @return : Board(Free or QnA or Upload)
	 * @param : int 글번호
	 */
	Board searchByBno(int bno);
	
	/**
	 * 삭제기능
	 */
	default int delete(int bno) {
		System.out.println("삭제합니다.");
		return 1;
	};
	
	/**
	 * 전체검색기능
	 */
	static List<Board> searchAll(){
		System.out.println("slelctAll임");
		return null;
	}
}
