package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class InsertBoardController /* implements Controller */{
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO boardDAO /* HttpServletRequest request */) {
		System.out.println("글 등록 처리");
		
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		//return "getBoardList.do";  //포워드 방식으로 이동(@Controller의 기본 페이지 이동 방식)
		return "redirect:getBoardList.do";  //리다이렉트 방식
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		System.out.println("글 등록 처리");
//		
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//		
//		//return "getBoardList.do";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}

}
