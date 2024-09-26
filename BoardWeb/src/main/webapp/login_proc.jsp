<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.globalin.biz.user.impl.UserDAO" %>
<%@ page import="com.globalin.biz.user.UserVO" %>

<%

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	
	System.out.println("loginUser id => " + id);
	System.out.println("loginUser password => " + password);

	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user =userDAO.getUser(vo);
	
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>