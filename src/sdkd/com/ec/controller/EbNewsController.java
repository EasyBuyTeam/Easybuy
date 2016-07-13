package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsController extends HttpServlet {

    EbNewsDao newsDao = new EbNewsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //

        String action = request.getParameter("action");
        if("list".equals(action)){
            list(request,response);
        }else if("detail".equals(action)){
            detail(request,response);
        }else{
            list(request,response);
        }


    }
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<EbNews> newlist = newsDao.getNews();
        request.setAttribute("newList",newlist);

        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    public void  detail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String paramsId=request.getParameter("id");
        int id=0;
        if(paramsId!=null && !"".equals(paramsId)){
            id=Integer.valueOf(paramsId);
        }
        //获取最近公告
        EbNoticeDao noticeDao=new EbNoticeDao();
        List<EbNotice> noticelist = noticeDao.getNotice();
        request.setAttribute("noticeList",noticelist);

        //获取动态新闻
        List<EbNews> newlist = newsDao.getNews();
        request.setAttribute("newList",newlist);

        //获取新闻详情byId
        EbNews news= newsDao.getNewsById(id);
        request.setAttribute("news",news);
        request.getRequestDispatcher("/news-view.jsp").forward(request,response);
    }



}
