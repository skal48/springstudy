package com.gdu.mbp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.mbp.dao.MbpMapper;
import com.gdu.mbp.dto.MbpDto;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class MbpServiceImpl implements MbpService {

   private final MbpMapper mbpMapper;
   
  @Override
  public List<MbpDto> getList() {   
    return mbpMapper.selectList();
  }

  @Override
  public MbpDto getNo(int no) {    
    return mbpMapper.selectMbpByNo(no);
  }

  @Override
  public int add(MbpDto mbpDto) {
    int addResult = mbpMapper.insert(mbpDto);
    return addResult;
  }

  @Override
  public int delete(int no) {
    int deleteResult = mbpMapper.delete(no);
    return deleteResult;
  }

}
