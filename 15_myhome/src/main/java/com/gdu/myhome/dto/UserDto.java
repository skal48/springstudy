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
public class UserDto {

  private int userNo;
  private String email;
  private String pw;
  private String name;
  private String gender;
  private String mobile;
  private String postcode;
  private String roadAddress;
  private String jibunAddress;
  private String detailAddress;
  private int agree;
  private Date modifiedAt;
  private Date joinedAt;
}
