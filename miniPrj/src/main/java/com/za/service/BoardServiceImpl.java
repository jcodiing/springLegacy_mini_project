package com.za.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.za.dao.BoardDao;
import com.za.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao bDao;
	
	@Override
	public ArrayList<BoardDto> getBoardListByPageNumber(int page) {
		return bDao.getAllList(page);
	}
	
	@Override
	public int getLastPageNumber() {
		int cnt = bDao.getCountAll(); // 모든 게시글의 갯수
		if(cnt%20==0) {
			return cnt/20;
		}
		return cnt/20 + 1;
	}

	@Override
	public BoardDto getBoardDetail(int bno) {
		return bDao.selectOneBoard(bno);
	}

	@Override
	public void increaseHitcount(int bno) {
		bDao.increasehitCount(bno);
	}

	@Override
	public void writeBoard(BoardDto dto) {
		bDao.write(dto);
	}

	@Override
	public void updateBoard(int bno, String title, String content) {
		bDao.update(bno, title, content);
	}

	@Override
	public void deleteBoard(int bno) {
		bDao.delete(bno);
	}

	
	
}
