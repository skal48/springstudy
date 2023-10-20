package com.gdu.myhome.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaveUserDto {

 
  private String email;
  private Date joinedAt;
  private Date leavedAt;
  
}
