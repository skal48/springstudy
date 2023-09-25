package com.gdu.app01.xml03;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
  private List<String> subject;
  private Set<String> contacts;
  private Map<String, String> friends;
}
