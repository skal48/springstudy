package com.gdu.app13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app13.service.FileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FileController {
  
  
  private final FileService fileService;
  
  @RequestMapping(value="/upload.do", method=RequestMethod.POST)
  public String upload(MultipartHttpServletRequest multipartRequest, RedirectAttributes redirectAttributes) {
    int addResult = fileService.upload(multipartRequest);
    redirectAttributes.addFlashAttribute("addResult",addResult);
    return "redirect:/main.do";
  }
  
  @RequestMapping(value="/ajax/upload.do", method=RequestMethod.POST, produces="application/json")
  @ResponseBody     // 잭슨은 Map이나 List를 json 형식으로 자동 변환해준다.
  public Map<String, Object> ajaxUpload(MultipartHttpServletRequest multipartRequest) {
    return fileService.ajaxUpload(multipartRequest);
  } 
  @RequestMapping(value="/cheditor/upload.do", method=RequestMethod.POST, produces="application/json")
  @ResponseBody     //ajax이 아니지만 붙여 줘야함
  public Map<String, Object> ckeditorUpload(MultipartFile upload, HttpServletRequest request){ //MultipartFile upload 이거는 지켜져야할 사항이다.
    return fileService.ckeditorUpload(upload, request.getContextPath());
    
  }
  
  @RequestMapping(value="/add.do", method=RequestMethod.POST)
  public void add(@RequestParam String contents) {
    System.out.println(contents);
  }
  
}
