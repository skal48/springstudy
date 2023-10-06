package com.gdu.app08.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app08.dto.MemberDto;
@Repository
public class MemberDao {
  
  private MemberDto member1;
  private MemberDto member2;
  private MemberDto member3;
  @Autowired
  public void setBean(MemberDto member1, MemberDto member2, MemberDto member3) {
    
    this.member1 = member1;
    this.member2 = member2;
    this.member3 = member3;
  }
  
  public MemberDto getMemberByNo(int MemberNo) {
    MemberDto MemberDto = null;
    if(member1.getMemberNo() == MemberNo) {
      MemberDto = member1;
    } else if(member2.getMemberNo() == MemberNo) {
      MemberDto = member2;
    } else if( member3.getMemberNo() == MemberNo) {
      MemberDto = member3;
    }
         
    return MemberDto;
  }
  
}
