package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myspring.model.Board;
import myspring.service.BoardService;

@Controller
public class BoardController {

	@Autowired // 내가적는거임 그럼 위에 알아서 임포트됨
	private BoardService service; // service객체 주입받기

	// 글작성 폼
	@RequestMapping("boardform.do") // 요청받기
	public String boardform() { // 메서드 추가
		return "board/boardform";
	}

	// 글작성
	@RequestMapping("boardwrite.do")
	public String boardwrite(Board board, Model model) { // DTO객체생성 값을 가지고 이동할때는 Model만들어야함

		int result = service.insert(board);
		System.out.println("result:" + result);

		model.addAttribute("result", result);
		return "board/insertresult";

//		return "redirect:boardlist.do";
	}

	// 글목록
	@RequestMapping("boardlist.do")
	public String boardlist(Model model) {
		
		List<Board> list = service.getBoardList();
		System.out.println("list:"+list);
		model.addAttribute("list", list);
				
		return "board/boardlist";
	}
	// 상세페이지 : 조회수 증가 + 상세정보 구하기
	@RequestMapping("boardcontent.do")
	public String boardcontent(int no, Model model) {
		
		service.readcount(no);							// 조회수 증가
		Board board = service.getBoard(no);		// 상세 정보
		System.out.println("board:"+board);		
		model.addAttribute("board", board);		// 필요한내용을 보드에 저장
		
		return "board/boardcontent";
	}
	// 수정폼
	@RequestMapping("boardupdateform.do")
	public String boardupdateform(int no, Model model) {
		
		Board board = service.getBoard(no);		// 한 사람의 상세정보를 구함
		model.addAttribute("board", board);
		
		return "board/boardupdateform";
	}
	// 수정
	@RequestMapping("boardupdate.do")
	public String boardupdate(Board b, Model model) {
		
		int result = service.update(b);
		Board board = service.getBoard(b.getNo());		// 한 사람의 상세정보를 구함
		
		model.addAttribute("board", board);
		model.addAttribute("result", result);
		
		return "board/updateresult";
	}
	// 삭제
	@RequestMapping("boarddelete.do")
	public String boarddelete(int no, Model model) {
		
		int result = service.delete(no);
		model.addAttribute("result", result);
		
		return "board/deleteresult";
	}
}
