package com.springbook.view.board;

import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController /* implements Controller */ {
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("글 삭제 처리");
//		String seq = request.getParameter("seq");
//		
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		//return "getBoardList.do";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;	
//	}

}
