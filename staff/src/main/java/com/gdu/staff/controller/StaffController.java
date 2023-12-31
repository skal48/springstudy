package com.gdu.staff.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.staff.dto.StaffDto;
import com.gdu.staff.service.StaffService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StaffController {

    private final StaffService staffService;
    
    @PostMapping(value="/add.do", produces = "application/json")
    public ResponseEntity<Map<String, Object>> add(StaffDto staff) {
      return staffService.registerStaff(staff);
    }
    
    @GetMapping(value="/list.do", produces = "application/json")
    public ResponseEntity<List<StaffDto>> list(){
      System.out.println(staffService.listStaff());
      return staffService.listStaff();
    }
    
    @GetMapping(value="/search/{sno}",  produces = "application/json")
    public ResponseEntity<StaffDto> search(@PathVariable(value="sno") String sno){
      
      System.out.println(staffService.searchStaff(sno) + sno);
      return staffService.searchStaff(sno);
    }
}
