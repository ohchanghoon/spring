package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dao.BoardDao;
import myspring.model.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;		//dao로 넘어가기위해서 dao객체 주입하는거
	
	public int insert(Board board) {
		return dao.insert(board);
	}
	public List<Board> getBoardList(){ //퍼블릭으로 만들어야되는이유 : 패키지가 다름
		return dao.getBoardList();
	}
	public void readcount(int no){ 
		dao.readcount(no);
	}
	public Board getBoard(int no) {
		return dao.getBoard(no);
	}
	
}
