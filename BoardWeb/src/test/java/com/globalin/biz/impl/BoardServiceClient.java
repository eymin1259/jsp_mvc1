package com.globalin.biz.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;

public class BoardServiceClient {

   public static void main(String[] args) {
      // 1. Spring 컨테이너 구동함
      AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 요청함
      BoardService BoardService = (BoardService)container.getBean("boardService");
      
      // 3. 글 등록
      BoardVO vo = new BoardVO();
      vo.setTitle("임시 제목");
      vo.setWriter("홍길동");
      vo.setContent("임시 내용 ....................");
      BoardService.insertBoar(vo);
      
      // 4. 글 목록 조회 기능 테스트
      List<BoardVO> boardList = BoardService.getBoardList();
      for(BoardVO board : boardList) {
         System.out.println("----> "+board.toString());
      }
      // 5. Spring컨테이너 종료
      container.close();
   }

}
