package org.westos.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

//使用登录拦截器执行登录认证功能,保护网页
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if(url.endsWith("ogin")) {
			return true;
		}
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		Object admin = session.getAttribute("admin");
		if (user == null && admin == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").
			forward(request, response);
			return false;
		}
		return true;
	}
}
