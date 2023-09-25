package com.gdu.app02.xml01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
  private String name;
  private Contact contact;
  private Address address;
}
