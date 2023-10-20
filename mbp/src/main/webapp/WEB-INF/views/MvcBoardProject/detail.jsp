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
	 
	  fnDeleteResult();
	  fnBtnDelete();
	  fnList();
	  })
  
  function fnBtnDelete(){
	  $('#btn_delete').click(function () {
		  if(confirm('게시글을 삭제할까요?') === 1){
			  $('#frn_delete').submit();
		  }
	  })
	  
  }
	  
  function fnDeleteResult(){
      var deleteResult = '${deleteResult}';
      if(deleteResult !== ''){
        if(deleteResult === '1'){
            alert('공지사항이 삭제되었습니다.'); 
            window.location = "${contextPath}/";
        } else {
        alert('공지사항 삭제가 실패했습니다.');
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
    <h1>MvcBoard 게시글 상세보기화면</h1>
    <div>
	    <form method="post" id="frm_delete" action="${contextPath}/MvcBoardProject/delete.do">
	     <div><h2>${mbp.no}번 게시글</h2></div>
	     <div>작성자: ${mbp.author}</div>
	     <div>작성일: ${mbp.postdate}</div>
	     <div>작성IP: ${mbp.ip}</div>
	     <div>조회수: ${mbp.hit}</div>
	     <div>제목: ${mbp.title}</div>
	     <div>내용</div>
	     <div>${mbp.content}</div>
	     <div>
	       <input type="hidden" id="no" name="no" value="${mbp.no}">
	       <button type="submit" id="btn_delete">삭제하기</button>
	       <button type="button" id="btn_list">목록보기</button>
	     </div>
	    </form>
    </div>
  </div>
  
  
    

</body>
</html>