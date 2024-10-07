package com.globalin.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {

		System.out.println("글 등록 처리");
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/ora/uploadfile/" + fileName));
		}

//		boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);

		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {

		System.out.println("글 수정 처리");
		System.out.println("새로운 정보 : => " + vo);

//		boardDAO.updateBoard(vo);
		boardService.updateBoard(vo);

		return "getBoardList.do";

	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		System.out.println("글 삭제 처리");

//		boardDAO.deleteBoard(vo);
		boardService.deleteBoard(vo);

		return "getBoardList.do";

	}

//	@RequestMapping("/getBoard.do")
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//
//		System.out.println("글 상세 조회 처리");
//
//		BoardVO board = boardDAO.getBoard(vo);
//
//		mav.addObject("board", board); // 모델 정보 저장
//		mav.setViewName("getBoard.jsp");// view 정보 저장
//
//		return mav;
//	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		System.out.println("글 상세 조회 처리");

//		BoardVO board = boardDAO.getBoard(vo);
		BoardVO board = boardService.getBoard(vo);

		model.addAttribute("board", board); // 모델 정보 저장

		return "getBoard.jsp";
	}

//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//
//		System.out.println("글 목록 조회 처리");
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//
//		mav.addObject("boardList", boardList); // 모델 정보 저장
//		mav.setViewName("getBoardList.jsp");// view 정보 저장
//
//		return mav;
//
//	}

	@ModelAttribute("conditionMap")
	public Map<String, String> getConditionMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("제목", "TITLE");
		map.put("내용", "CONTENT");
		return map;
	}

	@RequestMapping(value = "/getBoardList.do", method = RequestMethod.GET)
	public String getBoardList(BoardVO vo, Model model) {

		System.out.println("글 목록 조회 처리");
		
		
		// null check
		if(vo.getSearchCondition() == null) {
			System.out.println("vo.getSearchCondition()1  == null");
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			System.out.println("vo.getSearchKeyword() 2 == null");
			vo.setSearchKeyword("");
		}
		
		
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		List<BoardVO> boardList = boardService.getBoardList(vo);

//		model.addAttribute("conditionMap", conditionMap); // 모델 정보 저장
		model.addAttribute("boardList", boardList); // 모델 정보 저장

		return "getBoardList.jsp";

	}

	@RequestMapping(value = "/getBoardList.do", method = RequestMethod.POST)
	public String getBoardList(
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, BoardVO vo,
			Model model) {

		System.out.println("글 검색 처리 -> " + condition + ", " + keyword);
		
		if(vo.getSearchCondition() == null) {
			System.out.println("vo.getSearchCondition( 11  == null");
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			System.out.println("vo.getSearchKeyword() 22 == null");
			vo.setSearchKeyword("");
		}
		
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		List<BoardVO> boardList = boardService.getBoardList(vo);

		model.addAttribute("boardList", boardList); // 모델 정보 저장

		return "getBoardList.jsp";

	}

}
