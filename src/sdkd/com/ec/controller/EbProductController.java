package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Night Watch on 2016/7/6.
 */
public class EbProductController extends HttpServlet {


    EbProductDao productDao = new EbProductDao();
    EbPCategoryDao categoryDao = new EbPCategoryDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            list(request, response);
        } else if ("detail".equals(action)) {
            detail(request, response);
        } else {
            list(request, response);
        }
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*List<EbProduct> hotProductList = productDao.getHotProduct();
        request.setAttribute("hotProductList",hotProductList);

        List<EbProduct> saleOfGoodsList = productDao.getSaleOfGoods();
        request.setAttribute("saleOfGoodsList",saleOfGoodsList);
        //跳转页面
        request.getRequestDispatcher("/notice.do").forward(request, response);
       */

        //获取商品分类
        List<EbPCategory> categoriesList = categoryDao.getCategory();
        request.setAttribute("categoryList", categoriesList);


        String pageIndexParam = request.getParameter("pageIndex");
        String pageSizeParam = request.getParameter("pageSize");

        int pageIndex = 1;
        int pageSize = 4;

        if (pageIndexParam != null && !"".equals(pageIndexParam)) {
            pageIndex = Integer.parseInt(pageIndexParam);

        }

        if (pageSizeParam != null && !"".equals(pageSizeParam)) {
            pageSize = Integer.valueOf(pageSizeParam);
        }

        List<EbProduct> productList = productDao.getProductPager(pageIndex, pageSize);

        int count = productDao.getProductCount();//商品总数量；

        //获取商品页数
        int test = count % pageSize;
        if (test == 0) {
            int totalPage = count / pageSize;
            request.setAttribute("totalPage", totalPage);
        } else {
            int totalPage = count / pageSize + 1;
            request.setAttribute("totalPage", totalPage);
        }

        request.setAttribute("productList", productList);
        request.setAttribute("pageIndex", pageIndex);
/*
            List<Integer> countList = new ArrayList<Integer>();
            for(int i = 0;i<count;i++) {
                countList.add(count);
            }
            request.setAttribute("countList",countList);*/

        //跳转页面
        request.getRequestDispatcher("/product-list.jsp").forward(request, response);


    }


    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EbProduct> rentList = (List<EbProduct>) request.getSession().getAttribute("recent");
        String paramsId = request.getParameter("id");
        int id = 0;
        if (paramsId != null && !"".equals(paramsId)) {
            id = Integer.valueOf(paramsId);
        }

        //获取商品分类
        EbPCategoryDao categoryDao = new EbPCategoryDao();
        List<EbPCategory> categorieslist = categoryDao.getCategory();
        request.setAttribute("categoryList", categorieslist);

        //获取商品详情
        EbProduct product = productDao.getProductById(id);
        request.setAttribute("product", product);

        //最近浏览
        rentLook(request, product, id);

        //跳转
        request.getRequestDispatcher("/product-view.jsp").forward(request, response);


    }

    /*
    * 最近浏览
    * */
    public void rentLook(HttpServletRequest request, EbProduct product, int id) throws ServletException, IOException {


        List<EbProduct> rentList = (List<EbProduct>) request.getSession().getAttribute("recentList");
        List<EbProduct> list = new ArrayList<EbProduct>();

        if (rentList == null) {
            rentList = new ArrayList<EbProduct>();
        } else {
            for (EbProduct pro : rentList) {

                if (pro.getEpId() == id) {
                    rentList.remove(pro);//移除原先pro
                }
            }
        }
       /* if(rentList.size()<3){
            rentList.add(product);
        }else if(rentList.size()==3){
            rentList.remove(0);
            rentList.add(product);
        }*/
        rentList.add(product);
        if (rentList.size() > 5) {
            rentList.remove(0);
        }
        for (int i = 0;i < rentList.size();i++)
        {
            list.add(rentList.get(rentList.size()-i-1));
        }
        //   System.out.println("SSSSSSSS   "+rentList.size());
        request.getSession().setAttribute("recentList", list);

    }


}
