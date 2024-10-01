package com.globalin.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		System.out.println("글 목록 조회 처리");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		mav.addObject("boardList", boardList); // 모델 정보 저장
		mav.setViewName("getBoardList.jsp");// view 정보 저장

		return mav;

	}

}
