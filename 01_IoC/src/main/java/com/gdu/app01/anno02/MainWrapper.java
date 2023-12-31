package com.gdu.app01.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.gdu.app01.xml02.Board;

public class MainWrapper {

  public static void main(String[] args) {
    
    //AppConfig.java에 등록된 bean 생성
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
    // bean 가져오기 
    Board board = ctx.getBean("board123", Board.class);
    
    //확인
    System.out.println(board.getTitle() + ", " + board.getEditor());
    
    //ctx닫기
    ctx.close();
    
    
  }

}
