package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.User;

import dao.UserDao;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
	public void doPost ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		//设置请求参数编码格式为utf -8.防止中文参数乱码
		request . setCharacterEncoding("utf-8");
		//按照表单的各元素的name属性值获取各请求参数值
		String userName = request.getParameter("userName") ;
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode") ;
		//获取HttpSession对象
		HttpSession session = request.getSession( );
		//取出CreateVerifyImageController中存放的验证码字符串
		String saveVcode = (String) session. getAttribute("verifyCode");
		String forwardPath = ""; //转发程序的url-pattern
		//比较输入的验证码和随机生成的验证码是否相同
		if (!vcode. equalsIgnoreCase(saveVcode)) { // 不同
			//将需要传递的数据存放在request域范围中，目标转发页面可以从中获取
			request.setAttribute("info", "验证码不正确! ");
			forwardPath = "/error.jsp";
		} else {//验证码正确
			UserDao userDao = new UserDao( ) ;
			User currentUser = userDao.get(userName) ;
			if ( currentUser == null) { //用户名不存在
				//将需要传递的数据存放在request域范围中，目标转发页面可以从中获取
				request. setAttribute("info", "您输入的用户名不存在! ");
				forwardPath = "/error.jsp";
			} else { //用户名存在
				if (!currentUser.getPassword().equals(password)) { //密码不正确
					//将需要传递的数据存放在request域范围中，目标转发页面可以从中获取
					request.setAttribute("info","您输入的密码不正确! ");
							forwardPath = "/error.jsp" ;
				} else { //用户名密码正确
					//将需要传递的数据存放在session域范围中，- -个会话阶段的所有程序都可以从中获取
					session. setAttribute( "currentUser", currentUser) ;
					forwardPath = "/main.jsp";
				}
			}
	}
		//获取转发对象
		RequestDispatcher rd = request.getRequestDispatcher( forwardPath);
		//将请求转发到目标程序
		rd. forward(request, response);
		}
}
