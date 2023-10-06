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
  $(function(){
	fnMemberInfo();
	fnFlower();
  })
  function fnMemberInfo(){
	$('#btn_bmi').click(function(){
      $.ajax({
        type: 'get',
        url: '${contextPath}/member/health.check',
        data: 'memberNo=' + $('#memberNo').val(),
        dataType: 'json',
        success: function(resData){  // resData == {"bmi":xx, "state":xx, "name":xx}
         	fnBmi(resData);
        	fnProfile();
        }
      })
	})
  }
  
  function fnBmi(resData){
	  $('#bmi_info').empty();
      $('#bmi_info').append('<ul><li>' + resData.name + '</li><li>' + resData.bmi + '</li><li>' + resData.state + '</li></ul>');
  }
  
  function fnProfile(){
	  $('#profile').empty();
	  $('#profile').append('<img src="${contextPath}/member/profile.display?memberNo=' + $('#memberNo').val() +'" width="192px">');
  }
  
  
  function fnFlower(){
	  $('#btn_flower').click(function(){
		  var path = encodeURIComponent('D:\\GDJ69\\assets\\images');
		  var filename = $('#flower').val();
		  $('#picture').empty();
		  $('#picture').append('<img src="${contextPath}/member/picture.do?path=' + path + '$filename=' + filename +'"width="192px">' );
	  })
  }
  
  
</script>
</head>
<body>

  <div>
   <select id="memberNo">
     <option>1</option>
     <option>2</option>
     <option>3</option>
   
   </select>
   <button type="button" id="btn_bmi">BMI 정보확인</button>   
  </div>
  
  <hr>
  
  <div>
    <div>
      <select id = 'flower'>
        <c:forEach var="f" begin="1" end="4" step="1">
          <option> flower${f}.jpg </option>        
        </c:forEach>      
      </select>
      <button id = "btn_flower">꽃 가져오기</button>
      
      <hr>
        
      <div id="picture"></div>
      <div id="profile"></div>    
    </div> 
    <div id="bmi_info"></div>
  </div>

 <hr>
  
  <div>
    <a href="${contextPath}/shop.go">쇼핑하러가기</a>
  </div>


</body>
</html>