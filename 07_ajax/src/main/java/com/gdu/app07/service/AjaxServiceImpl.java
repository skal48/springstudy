package com.gdu.app07.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app07.dao.AjaxDao;
import com.gdu.app07.dto.AjaxDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AjaxServiceImpl implements AjaxService {
  
  private final AjaxDao AjaxDao1;
  
  

  @Override
  public List<AjaxDto> getDtoList() {
    // TODO Auto-generated method stub
    return AjaxDao1.getDtoList();
  }

  @Override
  public AjaxDto getDto(String name) {
    // TODO Auto-generated method stub
    int no = 0;
    if(name.equals("뽀로로")) {
      no = 1;
    }else if(name.equals("뽀루루")) {
      no = 2;
    }else if(name.equals("뽀러러")) {
      no =3;
    }
    return AjaxDao1.getDto(no);
  }

}
