
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@page import="com.globalin.biz.board.BoardVO"%>    
        
<%@ page import="com.globalin.biz.user.impl.UserDAO" %>
<%@ page import="com.globalin.biz.user.UserVO" %>
<%

request.setCharacterEncoding("utf-8");
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

// db
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

BoardDAO dao = new BoardDAO();
dao.insertBoard(vo);

// 목록페이지 이동
response.sendRedirect("getBoardList.jsp");
%>