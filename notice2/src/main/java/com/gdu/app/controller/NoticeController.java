package com.gdu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdu.app.dto.NoticeDto;
import com.gdu.app.service.NoticeService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class NoticeController {
  
  private final NoticeService noticeService;
  @RequestMapping(value = "/list.do", method = RequestMethod.GET)
  public String list(Model model) { //forward 할 데이터는 Model에 저장한다. 
    List<NoticeDto> noticeList = noticeService.getNoticeList();
    model.addAttribute("noticeList",noticeList);  //forward할 데이터 저장하기 (저장한 이름은 noticeList)
    return "notice/list"; // notice 폴더 아래의 list.jsp로 forward 하시오. 
  }
  
  @RequestMapping(value = "/notice/write.do", method=RequestMethod.GET)
  public String write() {
    return "notice/write";
    
  }

}
