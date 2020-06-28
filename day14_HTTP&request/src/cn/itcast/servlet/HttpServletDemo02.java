package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * 1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
 * 2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
 * 3. Enumeration<String> getParameterNames():获取所有请求的参数名称
 * 4. Map<String,String[]> getParameterMap():获取所有参数的map集合
 * 	中文乱码问题：
 * 					* get方式：tomcat 8 已经将get方式乱码问题解决了
 * 					* post方式：会乱码
 * 						* 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
 */
@WebServlet("/servletDemo02")
public class HttpServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//当post请求方法时才需要使用这种方式解决中文乱码
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> set = parameterMap.keySet();
        for(String name:set){
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for(String value:values){
                System.out.println(value);
            }
        }
        System.out.println("-------------");
    }
}
