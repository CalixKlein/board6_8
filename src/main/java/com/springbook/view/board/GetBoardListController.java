package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardListController /* implements Controller */ {
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO boardDAO,ModelAndView mav) {
		
		mav.addObject("boardList",boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		System.out.println("글 목록 검색 처리");
//		
//		BoardVO vo = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO();
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
//		
////		HttpSession session = request.getSession();
////		session.setAttribute("boardList", boardList);
////		
////		return "getBoardList";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("boardList",boardList);
//		mav.setViewName("getBoardList");
//		return mav;
//	}

}
