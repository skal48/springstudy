package com.gdu.app08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdu.app08.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopController {

  private final ShopService shopService;
   @ResponseBody
   @GetMapping(value="/shop/search.go", produces="application/json; charset=UTF-8" )
  public Map<String, Object> naverShopping(
                                @RequestParam("searchNo") int searchNo,
                                @RequestParam("order") String order,
                                @RequestParam("keyword") String keyword                               
                                ){
     
     String clientId = "emwjRM02_8WIWde35QI4"; //애플리케이션 클라이언트 아이디
     String clientSecret = "2Zd240M_xE"; //애플리케이션 클라이언트 시크릿


     StringBuffer text = new StringBuffer();
     try {        
         text.append(URLEncoder.encode(keyword, "UTF-8"));
         text.append("&display="+ searchNo);
         text.append("&sort="+ order);
     } catch (UnsupportedEncodingException e) {
         throw new RuntimeException("검색어 인코딩 실패",e);
     }

     String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text;    // JSON 결과
     
     Map<String, String> requestHeaders = new HashMap<>();
     requestHeaders.put("X-Naver-Client-Id", clientId);
     requestHeaders.put("X-Naver-Client-Secret", clientSecret);
     String responseBody = shopService.get(apiURL,requestHeaders);  //item{},{},{}  이거 나눠서 저장해야 하는데
     Map<String,Object> finalResult = new HashMap<String, Object>;
     finalResult = responseBody;
    return responseBody;
  }


  
}
