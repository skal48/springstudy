package com.gdu.myhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.gdu.myhome.dao.FreeMapper;
import com.gdu.myhome.dto.FreeDto;
import com.gdu.myhome.util.MyPageUtils;
import com.gdu.myhome.util.MySecurityUtils;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class FreeServiceImpl implements FreeService {

   private final FreeMapper freeMapper;
   private final MyPageUtils myPageUtils;
   private final MySecurityUtils mySecurityUtils;
  
   @Override
   public int addFree(HttpServletRequest request) {
     
     String email = request.getParameter("email");
     String contents = mySecurityUtils.preventXSS(request.getParameter("contents"));
     
     FreeDto free = FreeDto.builder()
                     .email(email)
                     .contents(contents)
                     .build();
     
     return freeMapper.insertFree(free);
     
   }
   
   
   @Transactional(readOnly = true)    //성능향상을 위해서 
   @Override
   public void loadFreeList(HttpServletRequest request, Model model) {
     
     Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
     int page = Integer.parseInt(opt.orElse("1"));
     
     int display = 10;
     
     int total = freeMapper.getFreeCount();
     
     myPageUtils.setPaging(page, total, display);
     
     Map<String, Object> map = Map.of("begin", myPageUtils.getBegin()
                                    , "end", myPageUtils.getEnd());
     
     List<FreeDto> freeList = freeMapper.getFreeList(map);
     
     model.addAttribute("freeList", freeList);
     model.addAttribute("paging", myPageUtils.getMvcPaging(request.getContextPath() + "/free/list.do"));
     model.addAttribute("beginNo", total - (page - 1) * display);
     
   }
   
   @Override
  public int addReply(HttpServletRequest request) {
    
     // 요청 파라미터 (댓글 작성 화면에서 받아오는 정보들)
     // 댓글 정보(EMAil, contents)
     // 원글 정보(depth, group_no, group_order)
     String email = request.getParameter("email");
     String contents = request.getParameter("contents");
     int depth = Integer.parseInt(request.getParameter("depth"));
     int groupNo = Integer.parseInt(request.getParameter("groupNo"));
     int groupOrder = Integer.parseInt(request.getParameter("groupOrder"));
     
     // 원글 dto
     // 기존 댓글 업데이트(원글 Dto)
     FreeDto free = FreeDto.builder()
                         .groupNo(groupNo)
                         .groupOrder(groupOrder)
                         .build();
     freeMapper.updateGroupOrder(free);
     
     // 댓글DTO
     // 댓글 삽입(댓글DTO)
     FreeDto reply = FreeDto.builder()
                         .email(email)
                         .contents(contents)
                         .depth(depth + 1)
                         .groupNo(groupNo)
                         .groupOrder(groupOrder + 1)
                         .build();
     
     int addReplyResult = freeMapper.insertReply(reply);
     
    return addReplyResult;
  }
   
  @Override
  public int removeFree(int freeNo) {  
    return freeMapper.deleteFree(freeNo);
  } 
  @Transactional(readOnly = true) 
  @Override
  public void loadsearchList(HttpServletRequest request, Model model) {
    
    String column = request.getParameter("column");
    String query = request.getParameter("query");
    
    Map<String, Object> map = new HashMap<>(); 
    map.put("column", column);
    map.put("query", query);
    
    int total = freeMapper.getSearchCount(map);
    
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    String strPage = opt.orElse("1");
    int page = Integer.parseInt(strPage);
    
    int display =10;
    
    myPageUtils.setPaging(page, total, display);
    
    map.put("begin", myPageUtils.getBegin());
    map.put("end", myPageUtils.getEnd());
    
    List<FreeDto> freeList = freeMapper.getSearchList(map); 
    
    model.addAttribute("freeList", freeList);   //모델로 가져가는 것은 jsp와 같은 이름이어야 페이지가 표시된다. 
    model.addAttribute("paging", myPageUtils.getMvcPaging(request.getContextPath() + "/free/search.do", "column="+column+"&query="+query));
    model.addAttribute("beginNo", total - (page - 1) * display);
    
  }
  
  
}
