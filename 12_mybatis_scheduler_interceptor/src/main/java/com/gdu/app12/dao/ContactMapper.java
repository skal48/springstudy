package com.gdu.app12.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app12.dto.ContactDto;


  
  /*
   *  @Mapper
   * 1. 맵퍼의 쿼리문을 호출할 수 있는 인터페이스에 추가하는 마이바티스 어노테이션 
   * 2. 메소드이름과 호출할 쿼리문의 아이디(id)을 동일하게 맞추면 자동으로 호출한다.
   * 3. @mapper가 등록된 인터페이스의 검색이 가능하도록 @MapperScan을 추가해야한다. (sqlSessionTemplate Bean 이 등록된 AppConfig.java에 추가한다. )
   * 4. 매퍼의 namespace 값을 인터페이스 경로로 작성한다. 
   */
  
  
  
  @Mapper
  public interface ContactMapper {
  
    
    public int insert(ContactDto contactDto); 
    
   
    public int update(ContactDto contactDto);
    
   
    public int delete(int contactNo);
    
    
    public List<ContactDto> selectList();
    
    public ContactDto selectContactByNo(int contactNo);
    
    public int hourlyDelete();
  }