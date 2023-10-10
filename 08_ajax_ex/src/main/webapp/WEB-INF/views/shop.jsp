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
	  fnShopSearch();	
  })
  
  function fnShopSearch() {
	  $('#btn_search').click(function() {
		  
		  $.ajax({
			  type: 'get',
			  url: '${contextPath}/shop/search.go',
			  data: {
				     'display' : $('#display').val(),
			         'sort' : $('.order').val(),
			         'keyword': $('#keyword').val()
			         },
				dataType: 'json',
				success: function(resData) { 
					var first = '<table border="1"><tr><td>상품명</td><td>썸네일</td><td>최저가</td><td>판매처</td></tr>';
					for(var i = 0; i < resData.length ; i++){
						var item = resData[i]
					  first += ('<tr><td>'+resData.title+'</td><td>'+
						           '<a href="'+resData.link+'"><img src="'+resData.image+'"/></a></td>'+
							         '<td>'+resData.lprice+'</td><td>'+resData.mallName+'</td></tr>');
					}
					var last = '</table>';
					$('#search_result').append(first + last);
				}
       
		  })
		
	})
	
}
  
</script>
</head>
<body>

  <div>
  	<h3>주말에 풀어보기</h3>
	<form action ="${contextPath}/shop/search.go" method="get"> 
		 <div>
		 검색결과건수
		 	<select id="display">
		 		<option value="10" >10</option>
		 		<option value="15">15</option>
		 		<option value="20">20</option>
		 	</select>
		 </div>	
		 <div>
			 <input type="radio" class="order" id="search" name="order" value="sim">
			 <label for="search">유사도순</label>
			 <input type="radio" class="order" id="date" name="order" value="date">
			 <label for="date">날짜순</label>
			 <input type="radio" class="order" id="lowPrice" name="order" value="asc">
			 <label for="lowPrice">낮은가격순</label>
			 <input type="radio" class="order" id="highPrice" name="order" value="dsc">
			 <label for="highPrice">높은가격순</label>
		 </div>
		 <div>
			 <label for="keyword"> 검색어 입력 </label>
			 <input type="text" id="keyword" name="keyword"> 
			 <button type = "submit" id="btn_search">검색</button>
		 </div>
  </form> 
 </div>	

<hr>
  <div id="search_result"></div>

</body>
</html>
