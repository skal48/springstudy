package com.gdu.app02.xml02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.gdu.app02.anno01.AppConfig;
import com.gdu.app02.anno02.MyJdbcService;

public class MainWrapper {

  public static void main(String[] args) {
    
   AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
   
   MyJdbcService myJdbcService = ctx.getBean("myJdbcService", MyJdbcService.class);
   
   myJdbcService.add();
   myJdbcService.remove();
   myJdbcService.modify();
   myJdbcService.select();
    
   ctx.close();
    
  }

}
