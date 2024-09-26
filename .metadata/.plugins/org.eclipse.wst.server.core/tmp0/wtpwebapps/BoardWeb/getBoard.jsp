<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@page import="com.globalin.biz.board.BoardVO"%>

<%
	String seq = request.getParameter("seq");

BoardVO vo = new BoardVO();
vo.setSeq(Integer.parseInt(seq));
BoardDAO dao = new BoardDAO();
BoardVO board = dao.getBoard(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.content-center {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
</style>
</head>
<body class="content-center">


	<h2>상세조회</h2>
	<div>
		<a href="logout_proc.jsp">로그아웃</a>
	</div>
	<hr>

	<form action="updateBoard_proc.jsp" method="post">

		<input type="hidden" name="seq" value="<%=board.getSeq()%>">


		<table width="500" border="1">

			<tr>
				<td width="100">제목</td>
				<td><input type="text" name="title"
					value="<%=board.getTitle()%>"></td>
			</tr>

			<tr>
				<td width="100">작성자</td>
				<td><input type="text" name="writer" readonly
					value="<%=board.getWriter()%>"></td>
			</tr>


			<tr>
				<td width="100">내용</td>
				<td><textarea rows="10" cols="50" name="content"><%=board.getContent()%></textarea></td>
			</tr>


			<tr>
				<td width="100">등록일</td>
				<td><%=board.getRegdate()%></td>
			</tr>


			<tr>
				<td width="100">조회수</td>
				<td><%=board.getCnt()%></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="글수정"></td>
			</tr>

		</table>
	</form>

	<hr>

	
	<a href="deleteBoard_proc.jsp?seq=<%=board.getSeq()%>">글삭제</a>
	<a href="getBoardList.jsp">글목록</a>


</body>
</html>