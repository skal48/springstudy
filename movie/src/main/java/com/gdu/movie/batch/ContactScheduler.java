package com.gdu.movie.batch;

import org.springframework.stereotype.Component;

import com.gdu.movie.service.MovieService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Component
public class ContactScheduler {
 
  private final MovieService movieService;
  
  //@Scheduled(cron="0 0/1 * * * ?")
  public void doSomething() {
    
    // 1분 마다 가장 예전에 등록된 연락처를 삭제하는 스케쥴러 
    //delete -ContactMapper/contactMapper - ContactService/ContactServiceImp
    
    
    
    log.info("doSomthing()");
  }
  
}
