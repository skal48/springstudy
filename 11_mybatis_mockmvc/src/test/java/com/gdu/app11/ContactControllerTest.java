package com.gdu.app11;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;
//Junit4를 사용한다.
@RunWith(SpringJUnit4ClassRunner.class)
//테스트에서 사용할 Bean 이 @component로 생성되었다. 
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
// 메소드 이름순으로 테스트를 수행한다. 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//WeApplicationContext를 사용할 수 있다 .(spring Container 에 Bean을 생성해 둔다.)
@WebAppConfiguration
//로그 
@Slf4j
public class ContactControllerTest {
  
  @Autowired
  private WebApplicationContext webApplicationContext; //테스트 수행할때 MockMvc 가 요구하는 것이다. 
  
  //MocMvc 객체 : 테스트를 수행하는 객체
  private MockMvc mockMvc;
  
  // 테스트 수행 이전에 MockMvc mockMvc 객체를 만든다. 
  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
  
  //삽입테스트
  //요청방식 : post
  //요청 주소 : /contact/add.do
  //요청 파라미터 : name, tel, wmail. address
  @Test
  public void test01_삽입() throws Exception {
    log.info(mockMvc
        .perform(MockMvcRequestBuilders      // 요청 수행      
            .post("/contact/add.do")         // 요청 방식 주소 
            .param("name","뽀로로")          // 요청 파라미터 
            .param("tel", "02-111-1111")
            .param("email", "pororo@naver.com")
            .param("address", "pororo villiage"))
        .andReturn()   //요청결과 
        .getFlashMap() // 요청결과가 저장된 flash로 가져옴 
        .toString());  
  }
  
  @Test
  public void test02_상세조회() throws Exception {
    log.info(mockMvc
              .perform(MockMvcRequestBuilders
                  .get("/contact/detail.do")
                  .param("contactNo", "1"))
              .andReturn()
              .getModelAndView()
              .getModelMap()
              .toString());
  }

}
