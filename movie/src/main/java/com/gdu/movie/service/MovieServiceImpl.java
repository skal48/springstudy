package com.gdu.movie.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gdu.movie.dao.MovieMapper;
import com.gdu.movie.dto.MovieDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
  private final MovieMapper movieMapper;
  
  @Override
  public Map<String, Object> getMovieList() {
    
    int movieCount = movieMapper.getMovieCount();
    List<MovieDto> list = movieMapper.getMovieList();
    
   
    return Map.of("message", "전체" + movieCount +"개의 목록을 가져왔습니다."
          , "list" ,list
          , "status" , 200);
  }
  
  @Override
  public Map<String, Object> getSearchMovie(Map<String, Object> map) {
    
    System.out.println(map);
    
    
    
    int searchCount = movieMapper.getSearchCount(map);
    List<MovieDto> list = movieMapper.getSearch(map);
    
    
    return Map.of("message",  searchCount +"개의 검색결과가 있습니다."
        , "list" ,list
        , "status" , 200);
  }
  
  public void comedyText() {
    
  }
  
  
}
