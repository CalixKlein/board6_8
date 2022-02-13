package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController /*implements Controller*/ {
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginView(/* @ModelAttribute("user") */UserVO vo) {
		System.out.println("로그인 화면으로 이동...");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO,HttpSession session) {
		System.out.println("로그인 인증 처리...");
		if(vo.getId() == null|| vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		UserVO user = userDAO.getUser(vo);
		
		if ( user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else
			return "login.jsp";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("로그인 처리");
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		
//		ModelAndView mav= new ModelAndView();
//		
//		if(user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		}else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		
//		return mav;
//	}
	
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("로그인 처리");
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		
//		if(user != null) {
//			return "getBoardList.do";
//		}else {
//			return "login";
//		}	
//	}
}
