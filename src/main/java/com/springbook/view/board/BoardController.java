package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	//검색 조건 목록 항목 설정
	@ModelAttribute("conditionMap")
	public Map<String ,String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo){
		System.out.println("dataTransform.do실행");
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	// 글 등록	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo/*,BoardDAO boardDAO*//* HttpServletRequest request */) throws IllegalStateException, IOException {
		System.out.println("글 등록 처리");
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename(); //업로드 파일 이름
			uploadFile.transferTo(new File("C://springworkspace//upload//"+fileName));
			
		}
		boardService.insertBoard(vo);	
		//return "getBoardList.do";  //포워드 방식으로 이동(@Controller의 기본 페이지 이동 방식)
		return "redirect:getBoardList.do";  //리다이렉트 방식
	}
		
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo /*,BoardDAO boardDAO*/) {
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, /*,BoardDAO boardDAO*/ Model model/*ModelAndView mav*/) {
		
//		mav.addObject("board", boardDAO.getBoard(vo)); 
//		mav.setViewName("getBoard.jsp");
		model.addAttribute("board",boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, /*BoardDAO boardDAO,*/ Model model/* ModelAndView mav */) {
		System.out.println("글 목록 보기");
//		boardDAO.getBoardList(vo);
//		mav.addObject("boardList",boardDAO.getBoardList(vo));
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList",boardService.getBoardList(vo));
		
		return "getBoardList.jsp";
	}
	
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(
//			@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
//			BoardVO vo,BoardDAO boardDAO,ModelAndView mav) {
//		
//		System.out.println("검색조건 :" + condition);
//		System.out.println("검색단어 :" + keyword);
//		
//		mav.addObject("boardList",boardDAO.getBoardList(vo));
//		mav.setViewName("getBoardList.jsp");
//		return mav;
//	}

}
