package com.gdu.app14.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app14.dto.MemberDto;
@Mapper
public interface MemberMapper {
  //삽입
  public int insertMember(MemberDto memberDto);
  
  //목록
  public List<MemberDto> getMemberList(Map<String, Object> map);
  
  // 전체개수 
  public int getMemberCount();
  
  public MemberDto getMember(int memberNo);
  
  public int updateMember(MemberDto memberDto);
  
  public int deleteMember(int memberNo);
  
  public int deleteMembers(List<String> list);
  
  /*
   * #{} 문자열로 '3,4' 처럼 된다. 
   * ${} 문자로 3,4
   */
}
