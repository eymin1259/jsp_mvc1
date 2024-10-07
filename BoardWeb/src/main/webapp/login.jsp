<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/> </title>
</head>
<body>


<div align="center">
   <h1><spring:message code="message.user.login.title"/></h1>
   <div>
   		<a href="login.do?lang=en"><spring:message code="message.user.login.language.en"></spring:message> </a>
   </div>
   
   <div>
   		<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko"></spring:message> </a>
   </div>
   <hr>
   <form action="login.do" method="post">
       <table border="1" cellpadding="0" cellspacing="0">
          <tr>
             <td bgcolor="orange"><spring:message code="message.user.login.id"></spring:message></td>
             <td><input type="text" name="id" value="${user.id}"></td>
          </tr>
          
          <tr>
             <td bgcolor="orange"><spring:message code="message.user.login.password"></spring:message></td>
             <td><input type="password" name="password"></td>
          </tr>
          
          <tr>
              <td colspan="2" align="center">
                 <input type="submit" value="<spring:message code="message.user.login.loginBtn"></spring:message>">
              </td>
          </tr>
       </table>
   </form>
   <hr>
</div>
</body>
</html>