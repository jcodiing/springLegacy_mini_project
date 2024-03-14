package com.za.service;

import java.util.ArrayList;

import com.za.dto.BoardDto;

public interface BoardService {
	ArrayList<BoardDto> getBoardListByPageNumber(int pageNumbr);
	int getLastPageNumber();
	BoardDto getBoardDetail(int bno);
	void increaseHitcount(int bno);
	void writeBoard(BoardDto dto);
	void updateBoard(int bno, String title, String content); 
	void deleteBoard(int bno);
}
