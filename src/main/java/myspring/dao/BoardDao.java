package myspring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import myspring.model.Board;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession session;		// root-context.xml에서 bean을 만들고 주입해야함 안그럼 오류 
	
	public int insert(Board board) {
		return session.insert("insert", board); 
	}
	public List<Board> getBoardList(){ 
		return session.selectList("list");
	}
	public void readcount(int no){ 
		session.update("hit", no);
	}
	public Board getBoard(int no) {
		return session.selectOne("content",no);
	}
	public int update(Board board) {
		return session.update("update", board);
	}
	public int delete(int no) {
		return session.delete("delete",no);
	}
	
}
