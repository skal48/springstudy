package com.gdu.myhome.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class MyFileUtils {

  //블로그 작성시 사용될 이미지가 저장될 경로 반환하기 
  public String getBlogImagePath() {
    /*  /storage/yyyy/MM/dd  */
    LocalDate today = LocalDate.now();
    return "/blog/" + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(today); 
    //return "/storage/" + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(today);
    
  }
  
  // 업로드 게시판 작성시 첨부한 파일이 저장될 경로 반환하기
  public String getUploadPath() {
    LocalDate today = LocalDate.now();
    return "/upload/" + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(today);
  }
  
  // 파일이 저장될 이름 반환하기 
  public String getFilesystemName(String originalName) {
    
    /* UUID.확장자 */
    
    String extName = null;
    if(originalName.endsWith("tar.gz")) { // 확장자에 마침표가 포함되는 예외 경우를 처리한다. 
      extName = "tar.gz";      
    } else {
      String[] arr = originalName.split("\\.");  // [.] 또는 \\.
      extName = arr[arr.length - 1];
    }
    
    return UUID.randomUUID().toString().replace("-", "") + "." + extName;
  }
  //블로그 이미지가 저장된 어제 경로를 반환
  public String getBlogImagePathInYesterday() {
    LocalDate date = LocalDate.now();
    date = date.minusDays(1);  // 1일 전
    return "/blog/" + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(date);
  }
}
