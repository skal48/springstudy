package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdu.app06.dao.BoardDao;
import com.gdu.app06.dto.BoardDto;

import lombok.NoArgsConstructor;

public class BoardServiceImpl implements IBoardService {
  
  private BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
 
  
  @Override
  public List<BoardDto> getBoardList() {
    // TODO Auto-generated method stub
    return boardDao.getBoardList();
  }

  @Override
  public BoardDto getBoardByNo(int boardNo) {
    // TODO Auto-generated method stub
    return boardDao.getBoardByNo(boardNo);
  }

}