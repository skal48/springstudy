package com.gdu.movie;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.gdu.movie.dao.MovieMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class MovieTestCase {
  
  @Autowired
  private MovieMapper movieMapper;
  
  @Test
  public void 영화목록테스트() {
   int listCount = movieMapper.getMovieCount();
   assertEquals(10, listCount);
  }

}
