package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sdust on 2016/7/8.
 */
public class EbUserReController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String rePassWord = request.getParameter("rePassWord");
        EbUserDao userDao = new EbUserDao();


        //userDao.setUser(userDao.getUser().size()+1,name,passWord);
       // if(name!=null&&passWord!=null&&rePassWord!=null&&passWord.equals(rePassWord)){
           // userDao.setUser(userDao.getUser().size()+1,name,passWord);
           // request.getRequestDispatcher("/reg-result.jsp").forward(request,response);

      //  }

        if(!name.equals("")&&!passWord.equals("")&&!rePassWord.equals("")&&passWord.equals(rePassWord)){

            userDao.setUser(userDao.getUser().size()+1,name,passWord);
           // userDao.setUser(20);
            request.getRequestDispatcher("/reg-result.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }
}
