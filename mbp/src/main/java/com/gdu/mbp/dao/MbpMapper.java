package com.gdu.mbp.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.mbp.dto.MbpDto;

@Mapper
public interface MbpMapper {
  public List<MbpDto> selectList();
  public int insert(MbpDto mbpDto);
  public MbpDto selectMbpByNo(int no);
  public int delete(int no);
}
