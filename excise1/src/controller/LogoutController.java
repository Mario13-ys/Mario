package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout.do")

public class LogoutController extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(); //获取sesson对象
		session.removeAttribute("currentUser"); //清除存放在session中 名为currentUser的信息
		response.sendRedirect("login.html"); //重定向到login. htm1页面
	}
}