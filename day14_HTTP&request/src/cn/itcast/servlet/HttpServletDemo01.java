package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
@WebServlet({"/demo1","/demo2,demo3"})
public class HttpServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String header = req.getHeader("user-agent");
        if(header.contains("Chrome")){
            System.out.println("谷歌来了....");
        }*/
        String referer = req.getHeader("referer");
        System.out.println(referer);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();//post方法时获取请求数据，get方法时使用QueryString()方法
        String line=null;
        if((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}
