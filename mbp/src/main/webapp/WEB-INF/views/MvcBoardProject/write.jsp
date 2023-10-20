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
<script>
  $(function() {
	  fnAddResult();
	  fnList();
	  })
  
  function fnAddResult(){
  var addResult = '${addResult}';
  if(addResult !== ''){
    if(addResult === '1'){
      alert('게시글이 등록되었습니다.');     
    	window.location = "${contextPath}/";
      
    } else {
    alert('게시글 등록이 실패했습니다.');
    }
  }
  }
 
  function fnList() {
	 $('#btn_list').click(function(){
		 location.href = "${contextPath}/";
	 }) 
  }
  
</script>
</head>
<body>

  <div>
    <h1>MvcBoard 작성화면</h1>
    <div>
      <form method="post" action="${contextPath}/MvcBoardProject/insert.do">
       <div><label for="author">작성자</label></div>
       <div><input type="text" id="author" name="author"></div>
       <div><label for="title">제목</label></div>
       <div><input type="text" id="title" name="title"></div>
       <div><label for="content">내용</label></div>
       <div><textarea rows="5" cols="25" name="content" id="content"></textarea> </div>
       <div>
         <button type="submit" id="btn_save">저장하기</button>
         <button type="reset" >다시작성</button>
         <button type="button" id="btn_list">목록보기</button>
       </div>
      </form>
    </div>
  </div>
    

</body>
</html>