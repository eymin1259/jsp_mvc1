package com.globalin.biz.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;

public class BoardServiceClient {

   public static void main(String[] args) {
      // 1. Spring �����̳� ������
      AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� ��û��
      BoardService BoardService = (BoardService)container.getBean("boardService");
      
      // 3. �� ���
      BoardVO vo = new BoardVO();
      vo.setTitle("�ӽ� ����");
      vo.setWriter("ȫ�浿");
      vo.setContent("�ӽ� ���� ....................");
      BoardService.insertBoar(vo);
      
      // 4. �� ��� ��ȸ ��� �׽�Ʈ
      List<BoardVO> boardList = BoardService.getBoardList();
      for(BoardVO board : boardList) {
         System.out.println("----> "+board.toString());
      }
      // 5. Spring�����̳� ����
      container.close();
   }

}
