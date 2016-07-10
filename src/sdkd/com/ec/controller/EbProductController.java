package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;

import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Night Watch on 2016/7/6.
 */
public class EbProductController extends HttpServlet {
    EbProductDao productDao = new EbProductDao();
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
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EbProduct> hotProductList = productDao.getHotProduct();
        request.setAttribute("hotProductList",hotProductList);

        List<EbProduct> saleOfGoodsList = productDao.getSaleOfGoods();
        request.setAttribute("saleOfGoodsList",saleOfGoodsList);
        //跳转页面
        request.getRequestDispatcher("/notice.do").forward(request, response);

    }


    public void  detail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramsId=request.getParameter("id");
        int id=0;
        if(paramsId!=null && !"".equals(paramsId)){
            id=Integer.valueOf(paramsId);
        }

        // System.out.println(id + "**********8");
        EbProduct product= productDao.getProductById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/product-view.jsp").forward(request,response);
    }
}
