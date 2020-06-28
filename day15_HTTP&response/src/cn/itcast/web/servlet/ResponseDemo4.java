package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 浏览器(客户端)通常使用gbk(gb2312)编码，tomcat通常使用ISO-8859-1
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setHeader("content-type","text/html;charset=utf-8");//第一种方式

        resp.setContentType("text/html;charset=utf-8");
        ServletOutputStream sos = resp.getOutputStream();
        sos.write("你好啊".getBytes("utf-8"));//没有参数就默认GBK编码

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
