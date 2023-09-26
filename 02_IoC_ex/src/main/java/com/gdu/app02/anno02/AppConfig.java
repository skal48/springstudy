package com.gdu.app02.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  public MyJdbcConnection myJdbcConnection() {
    MyJdbcConnection mjc = new MyJdbcConnection();
    mjc.setDriver("oracle.jdbc.OracleDriver");
    mjc.setUrl("jdbc:oracle:thin:@127.0.0.1:1512:xe");
    mjc.setUser("GD");
    mjc.setPassword("1111");
    return mjc;
    
  }
  @Bean
  public MyJdbcDao myJdbcDao() {
    return new MyJdbcDao();
  }
  
  
  @Bean  
  public MyJdbcService myJdbcService() {
    return new MyJdbcService(myJdbcDao());
  }
  
}
