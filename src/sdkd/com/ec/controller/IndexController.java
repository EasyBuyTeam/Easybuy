package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/8.
 */
public class IndexController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbPCategoryDao categoryDao = new EbPCategoryDao();
        EbProductDao productDao = new EbProductDao();
        EbNewsDao newsDao = new EbNewsDao();
        EbNoticeDao noticeDao = new EbNoticeDao();

        //TODO 获取总商品
        List<EbProduct> productList=productDao.getProduct();
        request.setAttribute("productList",productList);

        //TODO 获取今日特价商品列表
        List<EbProduct> saleOfGoodsList = productDao.getSaleOfGoods();
        request.setAttribute("saleOfGoodsList",saleOfGoodsList);

        //TODO 获取热卖推荐商品列表
        List<EbProduct> hotProductList = productDao.getHotProduct();
        request.setAttribute("hotProductList",hotProductList);

        //TODO 获取最新公告列表
        List<EbNotice> noticelist = noticeDao.getNotice();
        request.setAttribute("noticeList",noticelist);

        //TODO 获取新闻动态列表
        List<EbNews> newlist = newsDao.getNews();
        request.setAttribute("newList",newlist);

        //TODO 获取商品分类数据
        List<EbPCategory> categorieslist = categoryDao.getCategory();
        request.setAttribute("categoryList",categorieslist);


        //跳转页面
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
