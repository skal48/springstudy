/**
 * 가입 이전 단계  : 약관 동의 페이지 
 *
 */
 
 $(() => {
		fnChkEach();
		fnChkAll();
		fnJoinForm();
	})
 
  // 전체 선택을 클릭하면 개별 선택에 영향을 미친다.
  const fnChkAll = () => {
  	  $('#chk_all').click((ev) => {
  		  $('.chk_each').prop('checked', $(ev.target).prop('checked'));
  	  })
  }
  
  
  
  
  // 개별 선택을 클릭하면 전체 선택에 영향을 미친다.
  const fnChkEach = () => {  // 함수의 경우 const로 해야지 변수가 변하는 걸 막을 수 있음
  	  $(document).on('click', '.chk_each', () => {
  		  var total = 0;
  		  $.each($('.chk_each'), (i, elem) => {
  			  total += $(elem).prop('checked');
  		  })
  		  $('#chk_all').prop('checked', total === $('.chk_each').length);
  	  })
  }
  