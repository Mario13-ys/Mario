package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateImage;

@WebServlet(urlPatterns = "/createVerifyImage.do")
public class CreateVerifyImageController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		CreateImage createImage = new CreateImage();
		// 产生四位随机字符串
		String vCode = createImage.createCode();
		// 获取httpSession对象
		HttpSession session = request.getSession();
		// 将产生的四位随机字符串存放于session中（存放在session中的数据在一个会话范围内多个程序全局共享），以便验证
		session.setAttribute("verifyCode", vCode);

		// 设置返回的内容
		response.setContentType("img/jpeg");
		// 调用封装的类方法生成指定验证码字符串的内存图片
		BufferedImage image = createImage.CreateImage(vCode);
		// 获取字节流对象
		ServletOutputStream out = response.getOutputStream();
		// 将内存图像输出到浏览器，格式为JPEG
		ImageIO.write(image, "JPEG", out);
		// 刷新输出缓冲器（立即输出，而不用等待输出缓存满后才送至网络）
		out.flush();
		out.close();
	}
}