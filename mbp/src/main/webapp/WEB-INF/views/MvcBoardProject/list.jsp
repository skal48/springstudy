<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  
</head>
<body>

  <div>
    <span><a href="${contextPath}/MvcBoardProject/write.do">새글작성</a></span>  
  <hr>
  <div>
    <table border="1">
      <thead>
        <tr>
          <td>번호</td>
          <td>제목</td>
          <td>작성자</td>
          <td>작성일</td>
          <td>조회수</td>
        </tr>  
      </thead>
      <tbody>
        <c:forEach items="${list}" var="l">
          <tr>
            <td>${l.no}</td>
            <td><a href="${contextPath}/MvcBoardProject/detail.do?no=${l.no}">${l.title}</a></td>
            <td>${l.author}</td>
            <td>${l.postdate}</td>
            <td>${l.hit}</td>
          </tr>  
        </c:forEach>
      </tbody>    
    </table>
  </div>
 

</body>
</html>