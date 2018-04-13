package org.westos.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class LoginExpectionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		LoginExpection loginExpection = null;
		if(exception instanceof LoginExpection){
			loginExpection = (LoginExpection)exception;
		}else{
			loginExpection = new LoginExpection("未知错误");
		}
		//错误信息
		String message = loginExpection.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("message", message);
		//指向错误页面
		modelAndView.setViewName("msg");
		return modelAndView;
	}

}
