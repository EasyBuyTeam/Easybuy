package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Night Watch on 2016/7/7.
 */
@WebServlet(name = "EbNoticeController")
public class EbNoticeController extends HttpServlet {

    EbNoticeDao noticeDao = new EbNoticeDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        List<EbNotice> noticelist = noticeDao.getNotice();
        request.setAttribute("noticeList",noticelist);

        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }


    public void  detail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String paramsId=request.getParameter("id");
        int id=0;
        if(paramsId!=null && !"".equals(paramsId)){
            id=Integer.valueOf(paramsId);
        }

        //获取最新公告
        List<EbNotice> noticelist = noticeDao.getNotice();
        request.setAttribute("noticeList",noticelist);
        //获取新闻动态
        EbNewsDao newsDao=new EbNewsDao();
        List<EbNews> newlist = newsDao.getNews();
        request.setAttribute("newList",newlist);

        //获取公告详情byId
        EbNotice notice= noticeDao.getNoticeById(id);
        request.setAttribute("notice",notice);
        request.getRequestDispatcher("/news-view.jsp").forward(request,response);
    }
}
