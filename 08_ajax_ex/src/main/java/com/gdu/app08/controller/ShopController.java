package com.gdu.app08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdu.app08.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopController {

  private final ShopService shopService;
   @ResponseBody
   @GetMapping(value="/shop/search.go", produces="application/json; charset=UTF-8" )
  public Map<String,Object> naverShopping(  @RequestParam(name = "display", defaultValue = "10") int display,
                                @RequestParam(name = "order", defaultValue = "sim") String order,
                                @RequestParam("keyword") String keyword,
                                Model model
                                ){
     
     String clientId = "emwjRM02_8WIWde35QI4"; //애플리케이션 클라이언트 아이디
     String clientSecret = "2Zd240M_xE"; //애플리케이션 클라이언트 시크릿


     StringBuffer text = new StringBuffer();
     try {        
         text.append(URLEncoder.encode(keyword, "UTF-8"));
         text.append("&display="+ display);
         text.append("&sort="+ order);
     } catch (UnsupportedEncodingException e) {
         throw new RuntimeException("검색어 인코딩 실패",e);
     }

     String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text;    // JSON 결과
     
     Map<String, String> requestHeaders = new HashMap<>();
     requestHeaders.put("X-Naver-Client-Id", clientId);
     requestHeaders.put("X-Naver-Client-Secret", clientSecret);
     String responseBody = shopService.get(apiURL,requestHeaders);
     
     
     
     System.out.println(responseBody);
     
    
     
    return null;  
        
  }


  
}
