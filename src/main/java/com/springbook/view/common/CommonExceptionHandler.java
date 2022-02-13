package com.springbook.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.springbook.view")
public class CommonExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
		public ModelAndView handleArithmeticExcetion(Exception e) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception",e);
			mav.setViewName("/common/arithmeticError.jsp");
		
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
		public ModelAndView NullPointerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/nullPointError.jsp");
	
	return mav;
	}
	
	@ExceptionHandler(Exception.class)
		public ModelAndView Exception(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/Error.jsp");
	
	return mav;
	}

}
