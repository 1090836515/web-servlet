package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        boolean flag=false;
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie:cookies){
                if("lastTime".equals(cookie.getName())){
                    flag=true;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    Date date=new Date();
                    String str_date = sdf.format(date);
                    URLEncoder.encode(str_date,"utf-8");//编码
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24);
                    resp.addCookie(cookie);
                    String value = cookie.getValue();
                    URLDecoder.decode(value,"utf-8");
                    resp.getWriter().write("<h1>欢迎回来，你上次的访问时间为"+value+"</h1>");
                    break;
                }
            }
        }

        if(cookies==null || flag==false){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            Date date=new Date();
            String str_date = sdf.format(date);
            URLEncoder.encode(str_date,"utf-8");//编码
            Cookie cookie=new Cookie("lastTime",str_date);
            resp.addCookie(cookie);
            cookie.setMaxAge(60*60*24);
            resp.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }

    }
}
