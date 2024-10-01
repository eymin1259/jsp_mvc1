package com.globalin.biz.board;

import java.util.List;

public interface BoardService {

	//CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo);
	// 글 수정
	public void updateBoard(BoardVO vo);
	// 글삭제
	public void deleteBoard(BoardVO vo);
	// 글 상세조회
	public BoardVO getBoard(BoardVO vo);
	// 글 목록조회
	public List<BoardVO> getBoardList(BoardVO vo);
	
}
