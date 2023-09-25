package com.gdu.app02.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/apCtx.xml");
    
    Address address = ctx.getBean("address", Address.class);
    
    Contact contact = ctx.getBean("contact", Contact.class);
       
    Person person = ctx.getBean("person", Person.class);
    
    System.out.println(address.getJibun() +", "+ address.getPostcode() + ", " + address.getRoad());
    System.out.println(contact.getFax() + ", " + contact.getMobile());
    System.out.println(person.getName() +", "+ person.getAddress() +", " + person.getContact());
    
    
    

  }

}
