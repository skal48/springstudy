package com.gdu.app01.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app01.xml02.Board;



@Configuration
public class AppConfig {
  @Bean(name = "user")
  public User qwerty() { // name="user"로 인해서 메소드 이름은 의미가 없어진다.
    User user = new User();
    user.setUserId("admin");
    user.setUserNo(1);
    
    return user;
  }
  
  @Bean(name ="board")
  public Board qwer() {
    Board board = new Board();
    
    board.setTitle("공지사항");
   
    
    return board;
    
    
  }
  
  
}
