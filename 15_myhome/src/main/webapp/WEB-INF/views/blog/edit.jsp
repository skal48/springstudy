<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="블로그작성" name="title"/>
</jsp:include>

<style>
   .ck.ck-editor {
    max-width: 1000px;
  }
  .ck-editor__editable {
    min-height: 400px;
  } 
  .ck-content {
    color: gray;
  }
  
 
</style>



<div>

  <form id="frm_blog_modify" method="post" action="${contextPath}/blog/modify.do"> <!-- 폼아이디는 나중에 제목 공백으로 넣지 않기위한 스크립트 짤때 필요 -->
    
    <h1 style="text-align: center;">${blog.blogNo}번 블로그 편집</h1>
    
    <div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">제목</span>
        <input type="text" name="title" id="title" value="${blog.title}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
    </div>
    
    <div>
      <label for="contents">내용</label>
      <textarea name="contents" id="contents">${blog.contents}</textarea>
    </div>
    <br/>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
    <input type="hidden" name="blogNo"   value="${blog.blogNo}">
    <button type="submit" class="btn btn-outline-primary me-md-2">수정완료</button>
    </div>
    
    <br/>
  </form>
 </div>

<script>

  
  
  

  const fnCkeditor = () => {
    DecoupledEditor
      .create(document.getElementById('ckeditor'), {
        ckfinder: {
          // 이미지 업로드 경로
          uploadUrl: '${contextPath}/blog/imageUpload.do'         
        }
      })
      .then(editor => {
        const toolbarContainer = document.getElementById('toolbar-container');
        toolbarContainer.appendChild(editor.ui.view.toolbar.element);
      })
      .catch(error => {
        console.error(error);
      });
  }
  
  const fnBlogModify = () => {
	    $('#frm_blog_modify').submit(() => {
	      $('#contents').val($('#ckeditor').html());
	    })
	  }
  
  fnCkeditor();
  fnBlogModify();


</script>


<%@ include file="../layout/footer.jsp" %>