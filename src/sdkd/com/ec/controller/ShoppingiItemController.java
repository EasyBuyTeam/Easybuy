package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Night Watch on 2016/7/9.
 */
@WebServlet(name = "ShoppingiItemController")
public class ShoppingiItemController extends HttpServlet {
    EbProductDao productDao = new EbProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramsId = request.getParameter("id");
        int id = 0;
        if(paramsId!=null&&!"".equals(paramsId)){
            id = Integer.parseInt(paramsId);
        }
        EbProduct product = productDao.getProductById(id);

    }
}
