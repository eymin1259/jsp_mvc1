package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;


public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		  System.out.println("글 상세 조회 처리");
		  // 1.  검색할 글 번호를 추출
		     String seq = request.getParameter("seq");
		    
		  // 2. db 연동
		    BoardVO vo = new BoardVO();
		    vo.setSeq(Integer.parseInt(seq));
		    BoardDAO boardDAO = new BoardDAO();
		    BoardVO board = boardDAO.getBoard(vo);
		    
		     // 검색 결과를 세션에 저장하고 상세 조회 화면으로 이동함
		    /*
		    HttpSession session = request.getSession();
		    session.setAttribute("board", board);
		    return "getBoard";
		    */
		    // 검색 결과의 화면정보를 ModelAndView에 저장하여 리턴함
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("board", board); // 모델 정보 저장
		    mav.setViewName("getBoard");// view 정보 저장
		    
		      return mav;
		
	}

}
