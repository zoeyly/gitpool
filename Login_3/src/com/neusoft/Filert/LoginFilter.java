package com.neusoft.Filert;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account;
import com.neusoft.loginservice.LoginService;

/**
 * Servlet Filter implementation class CookieFilter
 */
@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		Cookie[] cookies=request.getCookies();
		Cookie username_cookie=null;
		Cookie password_cookie=null;
		String username=null;
		String password=null;
		if(cookies!=null&&cookies.length>0) {
			for(Cookie c:cookies) {
				String name=c.getName();
				String value=c.getValue();
				if(name!=null&&name.equals("username")) {
					
					username=URLDecoder.decode(value, "utf-8");
					System.out.println("½âÂëºó  username"+username);
					username_cookie=c;
				}
				if(name!=null&&name.equals("password")) {
					password=value;
					password_cookie=c;
				}
			}
			
		}
		
		if(username!=null&&password!=null) {
			LoginService ls=new LoginService();
			Account acc=new Account(username,password,request.getRemoteAddr());
			acc=ls.login(acc);
			if(acc!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("acc", acc);
				request.getRequestDispatcher("succ.jsp").forward(request, response);
			}else {
				username_cookie.setMaxAge(0);
				response.addCookie(username_cookie);
				response.addCookie(password_cookie);
				response.sendRedirect("LoginServlet");
				
			}
			
			
			
		}
		System.out.println("doFilter");
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
