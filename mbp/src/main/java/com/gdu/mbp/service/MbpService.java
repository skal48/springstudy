package com.gdu.mbp.service;

import java.util.List;

import com.gdu.mbp.dto.MbpDto;

public interface MbpService {
  public List<MbpDto> getList();
  public MbpDto getNo(int no);
  public int add(MbpDto mbpDto);
  public int delete(int no);
  
}
