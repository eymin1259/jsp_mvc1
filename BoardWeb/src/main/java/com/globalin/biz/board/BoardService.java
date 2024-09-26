package com.globalin.biz.board;

import java.util.List;

public interface BoardService {

	void insertBoar(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList() ;
}
