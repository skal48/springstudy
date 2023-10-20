package com.gdu.myhome.util;

import java.security.MessageDigest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
@Component
public class MySecurityUtils {

  /* 
   * SHA256 암호화
   * 1. 입력값을 265비트(32바이트)로 암호화하는 해시 알고리즘이다. 
   * 2. 원본을 암호화할 수 있으나 암호화된 결과를 원본으로 되돌리는 복호화는 불가능하다. 
   * 3. java.security 패키지를 활용해서 구하서나, 암호화 디펜던시(예시 common-lang3)를 활용한다. 
   *  
   */
  
  public String getSHA256(String password) {
    StringBuilder sb = new StringBuilder();
    
    try {
      MessageDigest messageDigest = null;
      messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(password.getBytes());
      byte[] b = messageDigest.digest(); //암호화된 32바이트 배열이 생성됨 -> 64개의 글자가 만들어진다. 1바이트는 8비트 4개씩끊어서 한글자를 만든다.  
      for(int i = 0; i < b.length; i++) {
        sb.append(String.format("%02X", b[i]));  // 2자리 16진수 문자열로 변환하기             
      }    
    }catch(Exception e) {
      e.printStackTrace();
    }
    
    return  sb.toString();
  }
  // 인증코드 반환
  public String getRandomString(int count, boolean letters, boolean numbers) {
    return RandomStringUtils.random(count,letters , numbers);
  }
  
  //크로스 사이트 스크립팅(Cross Site Scripting) 방지
  public String preventXSS(String source) {
    source = source.replace("<","&lt;").replace(">","&gt;");
    return source;
  }
  
}
