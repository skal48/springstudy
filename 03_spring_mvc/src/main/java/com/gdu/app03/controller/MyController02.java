package com.gdu.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController02 {
  
  // Spring 4 버전 이후 사용 가능한 @RequestMapping
  // 1. @GETMapping
  // 2. @PostMapping
  
  @GetMapping(value="/notice/list.do")
  public String boardList() {
    //ViewResolver의 prefix : /WEB-INF/views/
    //ViewResolver의 suffix : .jsp
    return "notice/list"; //WEB-INF/notice/board/list
  }
  
  //반환이 없는 경우에는 요청 주소를 JSp 경로로 인식한다. 
  // /member/list.do 요청을 /member/list.jsp 경로로 인식한다. 이방법은 사용하지 않는다!
  @GetMapping(value="/member/list.do")
  public void memberList() {
    
  }
}
