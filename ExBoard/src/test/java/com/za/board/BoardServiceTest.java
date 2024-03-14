package com.za.board;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.za.dto.BoardDto;
import com.za.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {
	@Autowired
	BoardService svc;
	
	@Test
	public void testGetAllList() throws Exception {
		ArrayList<BoardDto> list1 = svc.getBoardListByPageNumber(1);
		for(BoardDto dto : list1) {
			System.out.println(dto.getBno() + " / " + dto.getTitle() + " / " + dto.getContent() + " / " + dto.getWriter() + " / " + dto.getWritedate() + " / " + dto.getHitcount());
		}
	}
	
	@Test
	public void testGetLastPageNumber() throws Exception {
		System.out.println("마지막 페이지 번호 : " + svc.getLastPageNumber());
	}
	
	@Test
	public void testGetBoardDetail() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("글번호 입력해 : ");
		int bno = sc.nextInt();
		BoardDto dto = svc.getBoardDetail(bno);
		System.out.println(dto.getBno() + " / " + dto.getTitle() + " / " + dto.getContent() + " / " + dto.getWriter() + " / " + dto.getWritedate() + " / " + dto.getHitcount());
	}
	
	@Test
	public void testIncreaseHitcount() throws Exception {
		svc.increaseHitcount(100);
	}
	
	@Test
	public void testWriteBoard() throws Exception {
		BoardDto dto = new BoardDto(0, "za", "BoardServiceTest", "test content", 0, null);
		svc.writeBoard(dto);
	}
	
	@Test
	public void testUpdateBoard() throws Exception {
		svc.updateBoard(110, "한글수정", "테스트중");
	}
	
	@Test
	public void testDeleteBoard() throws Exception {
		svc.deleteBoard(111);
	}
}
