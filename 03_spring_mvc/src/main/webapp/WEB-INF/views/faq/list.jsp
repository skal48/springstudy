<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var addResult = '${addResult}';  	  // var addResult = '1'; add성공
										  // var addResult = '0'; add실패	
										  // var addResult = ''; add와 상관없이 목록보기를 한다. 
	if(addResult !== ''){
		if(addResult === '1'){
			alert('add 성공했습니다.');
		} else{
			alert('add 실패했습니다.')
		}
	}										  
</script>
</head>
<body>
  faq list
    
</body>
</html>