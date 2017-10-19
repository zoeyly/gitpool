package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Account;
import com.neusoft.loginservice.LoginService;
import com.neusoft.utils.MD5Utils;

/**
 * 登陆控制器
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("type");
		if("1".equals(command)){
			String _username = request.getParameter("username");
			String _password = request.getParameter("password");
			System.out.println(_username + " " + _password);
			Account mAcc = new Account();
			mAcc.setUsername(_username);
			mAcc.setPassword(_password);
			mAcc.setIp(request.getRemoteAddr());
			
			if(_username !=null || _username != "" && _password !=null || _password != ""){
				 mAcc = new LoginService().login(mAcc);
			}
			if(mAcc!=null){
				String isCheck = request.getParameter("checkbox");
				System.out.println(isCheck);
				if(isCheck != null && isCheck.equals("1")){
					//编码
					Cookie use_ck = new Cookie("username",URLEncoder.encode(_username,"utf-8"));
					use_ck.setMaxAge(7*24*60*60);
					//加密  
					/*Cookie psw_ck = new Cookie("password",MD5Utils.GetMD5Code(_password));*/
					Cookie psw_ck = new Cookie("password",_password);
				/*	System.out.println(MD5Utils.GetMD5Code(_password));*/
					psw_ck.setMaxAge(7*24*60*60);
					response.addCookie(use_ck);
					response.addCookie(psw_ck);
				}	
				request.setAttribute("usernae", _username);
				request.getRequestDispatcher("succ.jsp").forward(request, response);		
			}else{
				pw.append("<script> alert(\"unacc\")</script>");

			}
		}

		pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta charset=\"UTF-8\">");
		pw.append("<title>");
		pw.append("登陆");
		pw.append("</title>");
		pw.append("</head>");
		pw.append("<script>");
		pw.append("function judge(){ ");
		pw.append("var _username = document.getElementById(\"username\"); ");
		pw.append("var _errorSpan = document.getElementById(\"errorSpan\"); ");
		pw.append("var _password = document.getElementById(\"password\"); ");
		pw.append("if(_username.value == null || _username.value == \"\"){ ");
		pw.append("_errorSpan.innerHTML = \"用户名不能为空\"; ");
		pw.append("return; ");
		pw.append("} else { ");
		pw.append("_errorSpan.innerHTML = \"\"; ");
		pw.append("} ");
		pw.append("if(_password.value == null || _password.value == \"\"){  ");
		pw.append("_errorSpan.innerHTML = \"密码不能为空\"; ");
		pw.append("return; ");
		pw.append("}else{ ");
		pw.append("_errorSpan.innerHTML = \"\"; ");
		pw.append(" } ");
		pw.append("loginForm.submit();");	
		pw.append("}");
		pw.append("</script>");
		pw.append("<body background=\"img/a.jpg\" style=\"background-size: 1400px 600px;background-repeat: no-repeat;\">");
		pw.append("<form name=\"loginForm\" action=\"\" method=\"post\"> ");
		pw.append("<input type=\"hidden\"  name=\"type\"  value=\"1\"/>");
		pw.append("<div style=\"width: 600px;height: 300px;position: absolute;top:22%;left:30%;border: 2 solid black; background: greenyellow;\">");
		pw.append("<div style=\"height: 20%; font-size: 25px;text-align: center;line-height: 60px;background: mediumseagreen; color: darkolivegreen;\">系统登录</div>");
		pw.append("<div style=\"height: 20%; font-size: 20px;padding-left: 15%;color: white;margin-top: 15px;\">");
		pw.append("用户名：<br />");
		pw.append("<input id=\"username\" name=\"username\" style=\"border: 1px solid silver; border-radius: 5px;background-color: aliceblue;width: 200px;height: 25px;\" placeholder=\"请输入用户名\" /><br />");
		pw.append("<div style=\"height: 20%; font-size: 20px;padding-left: 15%;color: white;margin-top: 10px;\">");
		pw.append("密码：<br />");
		pw.append("<input id=\"password\" name=\"password\" style=\"border: 1px solid silver; border-radius: 5px;background-color: aliceblue;width: 200px;height: 25px;margin-top: 7px;\" placeholder=\"请输入密码\" /><br />");
		pw.append("<input id=\"checkbox\" type=\"checkbox\"  name=\"checkbox\"   value=\"1\" style=\"margin-top: 20px;margin-left:200px; \"/>：记住密码！");
		pw.append("</div>");
		
		pw.append("<div>");
		pw.append("<span id=\"errorSpan\" style=\"color: red;\"></span><br />");
		pw.append("<input onclick=\"judge()\" style=\"border: 1px solid silver;width: 100px;height: 30px;margin-top: 70px;margin-left: 150px;background-color: aliceblue;text-align: center;\"value=\"提交\"></input>");
		pw.append("</div>");
		pw.append("</form>");
		pw.append("</body>");
		pw.append("</html>");
		
		
//		pw.append("<div>");
//		pw.append("<input id=\"checkbox\" type=\"checkbox\"  name=\"checkbox\"  style=\"margin-top: 30px;margin-left:300px; \"/>：记住密码！");
//		pw.append("</div>");
		
		
//		LoginService ls = new LoginService();
//		
//	
//		String s=request.getParameter("type");
//		if(s=="1") {
//				boolean flag = false;
//				if(_username !=null || _username != "" && _password !=null || _password != ""){
//					 flag = new LoginService().login(_username, _password);
//				}
//				
//				if(flag){
//				pw.append("<script> alert(\"unacc\")</script>");
//	//			request.getRequestDispatcher("succ.jsp").forward(request, response);		
//				}else {
//					pw.append("<script> alert(\"acc\")</script>");
//				}
//		}
//		
//		
//		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
