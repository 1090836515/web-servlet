package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1......");

        //第一种转发方式
        /*resp.setStatus(302);
        resp.setHeader("location","/day15/responseDemo2");
        */

        //resp.sendRedirect("/day15/responseDemo2");

        //动态获取路径
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/responseDemo2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
