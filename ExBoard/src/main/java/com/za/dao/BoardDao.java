package com.za.dao;

import java.util.ArrayList;

import com.za.dto.BoardDto;

public interface BoardDao {
	ArrayList<BoardDto> getAllList(int pageNum);
	int getCountAll(); // 마지막 페이지번호를 리턴.
	public BoardDto selectOneBoard(int bno);  // bno --> BoardDto 객체를 리턴.
	void increasehitCount(int bno); // 조회수 하나 늘려줌
	void write(BoardDto dto);
	void update(int bno, String title, String content);
	void delete(int bno);
}
