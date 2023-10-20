package com.gdu.myhome.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

  @GetMapping({"/", "/main.do"})
  public String index() {
    return "layout/main";
  }
  
}
