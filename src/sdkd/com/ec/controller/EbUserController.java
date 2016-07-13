package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by cpy on 2016/7/7.
 */
public class EbUserController extends HttpServlet {
    //用户业务逻辑实例
    //UserBiz userBiz = new UserBizImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        EbUserDao userDao = new EbUserDao();
        int status =  0;//判断用户类型（1.普通用户，2管理员）
        int j = 0;

      for(int i = 0; i<userDao.getUser().size();i++) {

          if (name != null && name.equals(userDao.getUser().get(i).getEuName())) {
             if (passWord != null && passWord.equals(userDao.getUser().get(i).getEuPassword())) {
                  if(userDao.getUser().get(i).getEuStatue()==null){
                      status =1;
                  } else {
                      status = Integer.parseInt(userDao.getUser().get(i).getEuStatue());
                  }
                  break;
              }else{
                  j++;
              }
          }else {
              j++;
          }
      }
        if(j<=userDao.getUser().size()-1){
            request.setAttribute("user",name);
            if(status==1){
                request.getRequestDispatcher("/welcome.jsp").forward(request,response);
            }else  if(status==2){
                request.getRequestDispatcher("/manage/index.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/welcome.jsp").forward(request,response);
            }

        }else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

}
