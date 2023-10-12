package com.gdu.app12.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app12.dao.ContactMapper;
import com.gdu.app12.service.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * cron
 * 
 * 1.특정 시간이 특전 서비스를 동작시킬 수 있는 프로그램이다. 
 * 2.크론식으로 동작할 시간을 지정할 수 있다. 
 * 3. 크론식
 *  1) 형식
 *   초 분 식 일 월 요일
 *  2) 상세
 *   (1) 초 : 0 ~ 59
 *   (2) 분 : 0 ~ 59
 *   (3) 시 : 0 ~ 23
 *   (4) 일 : 1 ~ 31
 *   (5) 월 : 0 ~ 11(JAN FEB MAR QPR MAY JUN JL AUG SEP OCT NOV DEC)
 *   (6) 요일 : 1 ~ 7(MON TUE WEN THR FRI SAT SUN)
 *  3) 방식 
 *   (1) ? : 설정 없음("요일"에서 사용)
 *   (2) * : 매번("초 분 시 일 월"에서 사용)
 *   (3) - : 범위
 *   (4) / : 주기
 *  4) 예시
 *    (1) 특정 시간 (금요일 19시 0분 0초에 동작)
 *      0 0 19 * * FRI 
 *    (2) 특정 범위
 *      

 */





@RequiredArgsConstructor
@Slf4j
@Component
public class ContactScheduler {
 
  private final ContactService contactService;
  
  //@Scheduled(cron="0 0/1 * * * ?")
  public void doSomething() {
    
    // 1분 마다 가장 예전에 등록된 연락처를 삭제하는 스케쥴러 
    //delete -ContactMapper/contactMapper - ContactService/ContactServiceImp
    contactService.hourlyDelete();
    
    
    log.info("doSomthing()");
  }
  
}
