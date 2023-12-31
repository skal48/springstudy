package com.gdu.mbp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MbpDto {
  private int no;
  private String author;
  private String title;
  private String content;
  private int hit;
  private String ip; 
  private Date postdate;
  
}
