package com.globalin.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;


public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("글 목록 조회 처리");
		
		// 데이터베이스 연동
	    BoardVO vo = new BoardVO();
	    BoardDAO boardDAO = new BoardDAO();
	    List<BoardVO> boardList = boardDAO.getBoardList(vo);
	    
	    // 검색 결과를 세션에 저장하고 목록화면으로 이동함
	   /*
	    HttpSession session = request.getSession();
	    session.setAttribute("boardList", boardList);
	    return "getBoardList";
	    */
	    // 검색 결과의 화면정보를 ModelAndView에 저장하여 리턴함
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("boardList", boardList); // 모델 정보 저장
	    mav.setViewName("getBoardList");// view 정보 저장
	    
	      return mav;
	      
	}

}
