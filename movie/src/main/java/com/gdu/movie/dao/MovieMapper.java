package com.gdu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.movie.dto.MovieDto;

@Mapper
public interface MovieMapper {
  public int getMovieCount();
  public List<MovieDto> getMovieList();
  public List<MovieDto> getSearch(Map<String, Object> map); 
  public int getSearchCount(Map<String, Object> map);
  public MovieDto selectComedy();
}
