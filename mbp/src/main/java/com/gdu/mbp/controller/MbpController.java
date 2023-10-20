package com.gdu.mbp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.mbp.dto.MbpDto;
import com.gdu.mbp.service.MbpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MbpController {

  private final MbpService mbpService;
  
  @GetMapping(value= "/")
  public String list(Model model) {
    List<MbpDto> list = mbpService.getList();
    model.addAttribute("list", list);
    return "MvcBoardProject/list";
  }
  
  @GetMapping(value="/MvcBoardProject/write.do")
  public String write() {
    return "MvcBoardProject/write";
  }
  
  @PostMapping(value="/MvcBoardProject/insert.do")
  public String add(MbpDto mbpDto, Model model) {
    int addResult = mbpService.add(mbpDto);
    model.addAttribute("addResult", addResult);
    return "MvcBoardProject/write"; 
  }
  
  @GetMapping(value="/MvcBoardProject/detail.do")
  public String detail(@RequestParam int no, Model model) {
    MbpDto mbpDto = mbpService.getNo(no);
    model.addAttribute("mbp",mbpDto);
    return "MvcBoardProject/detail";
  }
  
  @PostMapping(value="/MvcBoardProject/delete.do")
  public String delete(int no, Model model) {
    int deleteResult = mbpService.delete(no);
    model.addAttribute("deleteResult", deleteResult);
    return "MvcBoardProject/detail";
    
  }
  
}
