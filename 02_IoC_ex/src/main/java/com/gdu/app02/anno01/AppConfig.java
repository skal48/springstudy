package com.gdu.app02.anno01;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Calculator calc() {
    return new Calculator();   
  }
  
  @Bean
  public Member member() {
    Member member = new Member();
    member.setName("김이박");
    member.setHeight(160.0);
    member.setWeight(50.0);
    member.setCalculator(calc());
    double w = member.getWeight();
    double h = member.getHeight();
    Calculator c = member.getCalculator();
    member.setBmi(c.div(w, c.div(c.mul(h, h), 10000)));
    double bmi = member.getBmi();
    String status = ((bmi < 20) ? "저체중" : (bmi < 25) ? "정상" : (bmi < 30) ? "과체중" :"비만");
    member.setStatus(status);
    
    return member;
  }
  
  @Bean 
  public Fitness fitness() {
    Fitness fitness = new Fitness();
    
    fitness.setName("우리피트니스");
    fitness.setMembers(Arrays.asList(member()));
    
    return fitness;
    
  }
  
  
}
