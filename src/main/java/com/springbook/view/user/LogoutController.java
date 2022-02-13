package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController /* implements Controller */ {
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		System.out.println("로그아웃 처리");
//		
//		HttpSession session = request.getSession();
//		session.invalidate();
//		
//		//return "login";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login.jsp");
//		return mav;
//	}

}
