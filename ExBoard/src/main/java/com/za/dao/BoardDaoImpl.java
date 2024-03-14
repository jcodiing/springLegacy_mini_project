package com.za.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.za.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDto> getAllList(int pageNum) {
		ArrayList<BoardDto> listRet = new ArrayList<BoardDto>();
		
		int endRnum = pageNum * 20;   // p.1--->20, p.2--->40, p.3--->60
		int startRnum = endRnum - 19;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startRnum", startRnum);
		hmap.put("endRnum", endRnum);
		List<BoardDto> list1 = sqlSession.selectList("BoardMapper.selectAll", hmap);
		listRet.addAll(list1);
		return listRet;
	}

	public int getCountAll() {
		return sqlSession.selectOne("BoardMapper.selectCountAll");
	}

	@Override
	public BoardDto selectOneBoard(int bno) {
		return sqlSession.selectOne("BoardMapper.selectOneBoard", bno);
	}

	@Override
	public void increasehitCount(int bno) {
		sqlSession.update("BoardMapper.increaseHitCountPlusOne", bno);  
	}

	@Override
	public void write(BoardDto dto) {
		sqlSession.insert("BoardMapper.insertBoard", dto);
	}

	@Override
	public void update(int bno, String title, String content) {
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("bno", bno);
		hMap.put("title", title);
		hMap.put("content", content);
		sqlSession.update("BoardMapper.updateBoard", hMap);
	}

	@Override
	public void delete(int bno) {
		sqlSession.delete("BoardMapper.deleteBoard", bno);
	} 
}
