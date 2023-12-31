package com.gdu.app03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController05 {
  
  /* redirect 하는 방법
     1. 스프링이 지원하는 방식 
       return "redirect:이동경로";
         public String add(){
         return "redirect:/list.do";
     2. 자바스크립트 코드를 만든다.
       location.href='이동경로';
         public String add(HTTPServletResponse response){
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("location.href='이동경로'");
            out.println("<script>");
        }  -주로 alert창을 이용할때 쓴다. 
  */
  /*
   * redirect 이동 경로
   * 1. 반드시 URLMapping 값을 작성한다. 
   * 2. 이동할 JSP 경로를 작성할 수 없다. 
   */
  
  //@RequestMapping(value = "/faq/add.do", method = RequestMethod.POST)
  public String add(HttpServletRequest reqeust) {
    String title = reqeust.getParameter("title");
    String content = reqeust.getParameter("content");
    // title이 빈 문자열이면 add 실패로 가정(DB 처리할 때 insert 성공은 1, 실패는 0이다.)
    int addResult = title.isEmpty() ? 0 : 1;
    
    // addResult를 가지고 faq 목록 보기로 이동(리다이렉트에서 모델에 담아서 전달하면 안된다. )
    
    
    return "redirect:/faq/list.do?addResult=" + addResult;  //jsp가 오면 작동을 안함(redirect하면)
  }
  
  //@RequestMapping(value="/faq/list.do", method=RequestMethod.GET)
  public String list(@RequestParam(value="addResult", required=false) String addResult, Model model) { //@RequestParam은 우리가 파싱하지 않아도 알아서 변환해 준다. 
    
    model.addAttribute("addResult", addResult);  //1 or 0을 전달한다. 
 
    return "faq/list";  //WEB-INF/views/faq/list.jsp
  }
  
  
  @RequestMapping(value = "/faq/add.do", method = RequestMethod.POST)
  public String add2(HttpServletRequest request
                   , RedirectAttributes redirectAttributes) { // redirect 상황에서 값을 전달할 때 사용한다. 
    //요철 파라미터 
    String title = request.getParameter("title");
    
    //title이 빈문자열이면 add 실패 
    int addResult = title.isEmpty() ? 0 : 1 ;
    
    // faq 목록 보기로 redirect 할 때 addResult를 "flash attribute"로 곧바로 전달하기 
    redirectAttributes.addFlashAttribute("addResult", addResult);
    
    // faq 목록보기로 redirect
    return "redirect:/faq/list.do";
  }
  
  @RequestMapping(value="/faq/list.do", method=RequestMethod.GET)
  public String list2() {
    return "faq/list";
  }
  
  
  
  
  
}
