package com.gdu.myhome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.FreeDto;

@Mapper
public interface FreeMapper {
  public int insertFree(FreeDto freeDto);
  public List<FreeDto> getFreeList(Map<String, Object> map);
  public int getFreeCount(); 
}