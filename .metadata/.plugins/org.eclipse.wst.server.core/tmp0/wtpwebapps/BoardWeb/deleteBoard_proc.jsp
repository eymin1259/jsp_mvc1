<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@page import="com.globalin.biz.board.BoardVO"%>    


<%

request.setCharacterEncoding("utf-8");
String seq = request.getParameter("seq");

// db
BoardVO vo = new BoardVO();
vo.setSeq(Integer.parseInt(seq));

BoardDAO dao = new BoardDAO();
dao.deleteBoard(vo);

// 목록페이지 이동
response.sendRedirect("getBoardList.jsp");
%>