<%@page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>

<%@page import="com.globalin.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	BoardVO vo = new BoardVO();
BoardDAO dao = new BoardDAO();
List<BoardVO> boardList = dao.getBoardList();
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
	justify-content:center;
	align-items: center;
}
</style>
</head>
<body class="content-center">

	<h2>board list</h2>

	<div>
		<a href="logout_proc.jsp">로그아웃</a>
	</div>
	<div>
	<a href="insertBoard.jsp">새글 등록</a>
	</div>
	<hr>

	<form action="getBoardList" method="post" >
		<table border="1" width="700">
			<tr>

				<td align="right"><select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
				</select> <input type="text" name="searchKeyword"> <input
					type="submit">
					
					
					</td>
			</tr>
		</table>
	</form>


	<table border="1" width="700">
		<tr>
			<td width="100">번호</td>
			<td width="200">제목</td>
			<td width="100">작성자</td>
			<td width="200">등록일</td>
			<td width="100">조회수</td>

		</tr>


		<%
			for (BoardVO board : boardList) {
		%>

		<tr>


			<td><%=board.getSeq()%></td>
			<td><a href="getBoard.jsp?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a>
			</td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getRegdate()%></td>
			<td><%=board.getCnt()%></td>
		</tr>



		<%
			}
		%>
	</table>

</body>
</html>