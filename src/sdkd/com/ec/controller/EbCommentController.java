package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbCommentDao;
import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbPCategory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class EbCommentController extends HttpServlet {


       EbCommentDao commentDao=new EbCommentDao();
       EbPCategoryDao categoryDao=new EbPCategoryDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取商品分类列表
        List<EbPCategory> categotyList=categoryDao.getCategory();
        request.setAttribute("categotyList",categotyList);

        //获取留言
        List<EbComment> commentlist = commentDao.getNews();
        request.setAttribute("commentList",commentlist);
        request.getRequestDispatcher("/guestbook.jsp").forward(request,response);


    }




}
