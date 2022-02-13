package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardController /* implements Controller */ {
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("board", boardDAO.getBoard(vo)); 
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		System.out.println("글 상세 조회 처리");
//		
//		String seq = request.getParameter("seq");
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//			
//		BoardDAO boardDAO = new BoardDAO();
//		BoardVO board = boardDAO.getBoard(vo);
//		
////		HttpSession session = request.getSession();
////		session.setAttribute("board", board);
////		
////		return "getBoard";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board",board);
//		mav.setViewName("getBoard");
//		return mav;
//	}

}
