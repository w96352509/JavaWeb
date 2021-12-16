package cc.openhome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    String header = 
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset='UTF-8'>" +
            "<title>Login Result</title>" +
            "</head>" +
            "<body>";
    String footer =
            "</body>" +
            "</html>";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        out.printf(header);
	        if ("caterpillar".equals(username) && "12345678".equals(password)) {
	            out.print("<h1>登入成功</h1>");
	        } else {
	            out.print("<h1>失敗</h1><br>");
	            out.print("<a href='form.html'>帳號密碼錯誤</a>");
	        }
	        out.print(footer);
	}

    
}
