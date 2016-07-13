package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbUser;
import sdkd.com.ec.model.ShoppingCart;
import sdkd.com.ec.model.ShoppingCartItem;
import sdkd.com.ec.service.EbOrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class EbShoppingController extends HttpServlet {

     EbProductDao productDao=new EbProductDao();
     EbOrderService orderService = new EbOrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        boolean issame =false;
        //1.获取商品ID
        String paramsId = request.getParameter("id");
        int id = 0;
        if(paramsId != null && !"".equals(paramsId)){
            id = Integer.parseInt(paramsId);
        }
        EbProduct product = productDao.getProductById(id);

        String action = request.getParameter("action");
        if("mod".equals(action)){
            modifyCart(request, response);
        }else if("remove".equals(action)){
            removeCart(request, response);
        }else if("pay".equals(action)){
            payCart(request, response);
            return;
        }else {

            //2.存储至session
            //存session之前判断是否已经存在
            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new ShoppingCart();
                cart.addItem(product, 1);
            } else {
                //如果存在，查找有无相同的商品，如果有则更新数量
                List<ShoppingCartItem> items = cart.getItems();
                if (items != null && items.size() > 0) {
                    for (ShoppingCartItem item : items) {
                        EbProduct itemPro = item.getProduct();
                        if (itemPro.getEpId() == id) {
                            item.setQuantity(item.getQuantity() + 1);
                            issame = true;  //标识
                        }
                    }
                }
                //若不存在，则直接添加，数量默认为1
                if (!issame) {
                    cart.addItem(product, 1);
                }
            }
            request.getSession().setAttribute("cart", cart);
        }
        //gson-->
//        response.getWriter().write();
//        request.getRequestDispatcher("/shopping.jsp").forward(request,response);  //转发
        response.sendRedirect("/shopping.jsp");   //重定向
    }



    /**
     * 购物车页面进行修改
     */
    public void modifyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        long quantity = 0;
        int index = 0;
        String quantityParam = request.getParameter("quantity");
        String indexParam = request.getParameter("index");
        if(quantityParam!=null && !"".equals(quantityParam)){
            quantity = Long.valueOf(quantityParam);
        }
        if(indexParam!=null && !"".equals(indexParam)){
            index = Integer.valueOf(indexParam);
        }
        cart.modifyQuantity(index,quantity);
    }

    /**
     * 删除购物车
     */
    public void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        int index = 0;
        String indexParam = request.getParameter("index");
        if(indexParam!=null && !"".equals(indexParam)){
            index = Integer.valueOf(indexParam);
        }
        cart.removeItem(index);
    }

    /**
     * 结算
     */
    public void payCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 判断用户是否登录
      /*  EbUser user = (EbUser) request.getSession().getAttribute("currUser");
        if(user==null){
            response.sendRedirect("/login.jsp");
            return;
        }*/
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        //以下为测试
        EbUser ebuser = new EbUser();
        ebuser.setEuName("李徐蕊");
        ebuser.setEuID("1000000002");
        ebuser.setEuAddress("山东科大");
        request.getSession().setAttribute("currUser",ebuser);

        if(cart!=null){
            orderService.payOrder(cart,ebuser);
        }
      //  double account=cart.getTotalCost();
   //     System.out.println("TTTTTTT"+account);
        request.setAttribute("cart",cart);

        response.sendRedirect("/shopping-result.jsp");
    }

}



