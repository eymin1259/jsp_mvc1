package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;


public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 삭제 처리");
		 
		   String seq = request.getParameter("seq");

		   BoardVO vo = new BoardVO();
		   vo.setSeq(Integer.parseInt(seq));
		   
		   BoardDAO boardDAO = new BoardDAO();
		   boardDAO.deleteBoard(vo);
		   
		  // return  "getBoardList.do";
		   // 검색 결과의 화면정보를 ModelAndView에 저장하여 리턴함
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("redirect:getBoardList.do");// view 정보 저장
		    return mav;
		
		
	}

}
